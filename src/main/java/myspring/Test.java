package myspring;


import com.qjx.myspring.beans.BeanFactory;
import com.qjx.myspring.beans.configbean.ClassPathXmlApplicationContext;
import com.qjx.myspring.config.Bean;
import com.qjx.myspring.config.XmlConfig;
import com.qjx.myspring.testbean.Address;
import com.qjx.myspring.testbean.User;

import java.io.File;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        testIOC();
        //testConfig();
    }
    /**
     * 测试IOC容器
     */
    private static void testIOC(){

        BeanFactory bf = new ClassPathXmlApplicationContext("application.xml");

        User user = (User) bf.getBean("user");
        System.out.println(user);
        System.out.println("address hashcode:"+user.getAddress().hashCode());

        Address address = (Address) bf.getBean("address");
        System.out.println(address);
        System.out.println("address hashcode:"+address.hashCode());
    }
    /**
     * 测试读取配置文件
     */
    private static void testConfig(){
        Map<String, Bean> map = XmlConfig.getConfig("/ApplicationContext.xml");
        for (Map.Entry<String, Bean> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }
    }

}
