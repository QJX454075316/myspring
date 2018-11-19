package com.qjx.myspring.beans;

/**
 * @author junxiangquan
 * @date 2018-11-9
 */
public interface BeanFactory {
    /**
     * 根据名字获取对象
     * @param beanName
     * @return obj对象
     */
    Object getBean(String beanName);
}
