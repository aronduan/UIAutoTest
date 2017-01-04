package com.xbwq.utils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import com.xbwq.utils.Locator.ByType;

/**
 * Created by Administrator on 2017/1/4.
 */
public class XmlUtils {


    public static HashMap<String, Locator> readXMLDocument(String xmlPath,String pageName) throws Exception {

        HashMap<String, Locator> locatorMap = new HashMap<String, Locator>();
        locatorMap.clear();

        File file = new File(xmlPath);
        if (!file.exists()) {
            return locatorMap=null;
        }

        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(file);
        //获取根节点元素对象
        Element root = document.getRootElement();

        //遍历
        for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
            Element page = (Element) i.next();
            if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {

                for (Iterator<?> l = page.elementIterator(); l.hasNext();) {
                    String type = null;
                    String timeOut = "3";
                    String address = null;
                    String locatorName = null;
                    Element locator = (Element) l.next();

                    for (Iterator<?> j = locator.attributeIterator(); j.hasNext();) {
                        Attribute attribute = (Attribute) j.next();
                        if (attribute.getName().equals("type")) {
                            type = attribute.getValue();
                            //log.info("get locator type " + type);
                        } else if (attribute.getName().equals("timeOut")) {
                            timeOut = attribute.getValue();
                            //log.info("get locator timeOut " + timeOut);
                        } else {
                            address = attribute.getValue();
                            //log.info("get locator address " + value);
                        }

                    }
                    Locator temp = new Locator(address,Integer.parseInt(timeOut), getByType(type));
                    locatorName = locator.getText();
                    //log.info("locatorName is " + locatorName);
                    locatorMap.put(locatorName, temp);
                }
                continue;
            }

        }
        return locatorMap;

    }

    //默认用xpath
    public static ByType getByType(String type) {
        ByType byType = ByType.xpath;
        if (type == null || type.equalsIgnoreCase("xpath")) {
            byType = ByType.xpath;
        } else if (type.equalsIgnoreCase("id")) {
            byType = ByType.id;
        } else if (type.equalsIgnoreCase("name")) {
            byType = ByType.name;
        } else if (type.equalsIgnoreCase("className")) {
            byType = ByType.className;
        }
        return byType;
    }

}
