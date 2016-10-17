package com.xbwq.Config;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;  
public class XMLParser {
    
    public List getXMl() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/com/xbwq/Config/TestData.xml"));
        
        //获取根节点
        Element root = document.getRootElement();
        
        List list = new ArrayList();
        
        for(Iterator<?> i = root.elementIterator(); i.hasNext(); ){
            Element secondNode = (Element)i.next();
            Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
            Map<String, String> inMap = new HashMap<String, String>();
            
            for(Iterator<?> j = secondNode.elementIterator(); j.hasNext();){
                Element inNode = (Element)j.next();
                inMap.put(inNode.getName(),inNode.getText());
            }
            map.put(secondNode.getName(), inMap);
            list.add(map);
        }
        
        return list;
       }    
        
}  
