package com.qjx.myspring.beans.configbean;

import com.qjx.myspring.beans.BeanFactory;
import com.qjx.myspring.config.Bean;
import com.qjx.myspring.config.Property;
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

    /**
     * 根据bean对象创建Object对象
     * @param bean
     * @return 创建的对象
     */
    private Object createObject(Bean bean) {
        String beanId = bean.getId();
        String className = bean.getClassName();
        Class c = null;
        Object o = null;

        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("您配置的class属性不合法："+className);
        }
        try {
            o = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("该类缺少一个无参构造方法："+className);
        }
        if (bean.getProperties()!=null){
            for(Property property:bean.getProperties()){

            }
        }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
