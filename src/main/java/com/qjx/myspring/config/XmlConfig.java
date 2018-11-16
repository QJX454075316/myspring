package com.qjx.myspring.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取xml配置
 * @author junxiangquan
 */
public class XmlConfig {

    public static Map<String,Bean> getConfig(String path) {
        Map<String,Bean> configMap = new HashMap<>();
        Document doc = null;
        SAXReader  reader = new SAXReader();
        InputStream in = XmlConfig.class.getResourceAsStream(path);
        try {
            doc = reader.read(in);
        }catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查xml的路径!");
        }
        String  xpath = "//bean";
        List<Element> list = doc.selectNodes(xpath);
        if(list!=null){
            for (Element element:list){
                Bean bean = new Bean();
                String id = element.attributeValue("name");
                String className = element.attributeValue("class");
                bean.setId(id);
                bean.setClassName(className);
                List<Element> propElems = element.elements("property");
                if (propElems!=null){
                    for (Element propelem:propElems){
                        Property  property = new Property();
                        String propName = propelem.attributeValue("name");
                        String value = propelem.attributeValue("value");
                        String ref = propelem.attributeValue("ref");
                        property.setName(propName);
                        property.setValue(value);
                        property.setRef(ref);
                        bean.getProperties().add(property);
                    }
                }
                if (configMap.containsKey(id)){
                    throw new RuntimeException("bean节点ID重复：" + id);
                }
                configMap.put(id,bean);
            }
        }
        return  configMap;
    }
}
