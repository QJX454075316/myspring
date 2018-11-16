package com.qjx.myspring.testbean;

/**
 *  测试代码
 * @author junxiangquan
 */
public class Address {
    private String city;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + "]";
    }
}
