package com.qjx.myspring.beans;

/**
 * @author junxiangquan
 * @date 2018-11-9
 */
public interface BeanFactory {
    /**
     * @param beanName
     * @return obj对象
     */
    Object getBean(String beanName);
}
