package com.springk.mockit.util;

/**
 * MockitUtil
 *
 * @author wjy
 * @date 2020-08-21 16:13
 * @since 1.0.0
 */
public class MockitUtil {

    /**
     * mockit测试类，传入一个int类型参数，输出对应的参数信息
     * @param i
     * @return i
     */
    public int doSomething(int i){
        return i;
    }


    /**
     * static 方法
     * @return Mockit
     */
    public static String getMockitName() {
        return "Mockit";
    }

}
