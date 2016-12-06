package com.xbwq.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.appium.java_client.android.AndroidDriver;

public class Common {
	public AndroidDriver driver;
	public Common(AndroidDriver driver) throws MalformedURLException{
//		driver = Driver.getDriver();
		this.driver = driver;
	}
	
	
	public List<String> page(String pageName){
		
		List<String> list = new ArrayList<String>();
		
		String currentPath = this.getClass().getResource(".").getPath().toString();
		File f = new File(currentPath+"page.xml");
		
		// documentBuilderΪ������ֱ��ʵ����(��XML�ļ�ת��ΪDOM�ļ�)
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		
		try {
			// ����documentBuilderFactory����
			dbf = DocumentBuilderFactory.newInstance();
			// ����db������documentBuilderFatory�����÷���documentBuildr����
			db = dbf.newDocumentBuilder();
			// �õ�һ��DOM�����ظ�document����
			Document dt = db.parse(f);

			
			NodeList pageList = dt.getElementsByTagName("page");
			
			for(int i=0; i<pageList.getLength(); i++){
				Node node = pageList.item(i);
				Element elem = (Element)node;
				
				if(pageName.equals(elem.getAttribute("name"))){
					
					NodeList elementList = dt.getElementsByTagName("Element");
					
					for(int j=0; j<elementList.getLength(); j++){
						Node node1 = elementList.item(j);
						Element elem1 = (Element)node1;
						list.add(elem1.getAttribute("eleName"));
					}
					break;
				}

			}

//			
//			Node node2 = elementList.item(1);
//			Element elem2 = (Element)node2;
//			System.out.println(elem2.getAttribute("eleName"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
