package com.qjx.myspring.beans.configbean;

import com.qjx.myspring.beans.BeanFactory;
import com.qjx.myspring.config.Bean;
import com.qjx.myspring.config.XmlConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * xml配置beans
 * @author Administrator
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String,Object> ioc;
    private Map<String, Bean> config;

    public ClassPathXmlApplicationContext(String path){
        ioc = new HashMap<>();
        config = XmlConfig.getConfig(path);
        if(config != null){
            for (Entry<String,Bean> entry:config.entrySet()){
                String beanId = entry.getKey();
                Bean bean = entry.getValue();
                Object obj = createObject(bean);
                ioc.put(beanId,obj);

            }
        }
    }

    private Object createObject(Bean bean) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
