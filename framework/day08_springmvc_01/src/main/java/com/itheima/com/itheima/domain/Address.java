package com.itheima.com.itheima.domain;

import java.io.Serializable;

/**
 * 地址的实体类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Address implements Serializable {

    private String provinceName;
    private String cityName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
