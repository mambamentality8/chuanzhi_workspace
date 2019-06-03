package com.itheima.proxy;

/**
 * 模拟经纪公司的标准
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IActor {

    /**
     * 基本表演
     * @param money
     */
    public void basicAct(Float money);

    /**
     * 危险的表演
     * @param money
     */
    public void dangerAct(Float money);
}
