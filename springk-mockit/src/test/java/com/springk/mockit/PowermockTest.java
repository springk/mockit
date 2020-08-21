package com.springk.mockit;

import com.springk.mockit.util.MockitUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * PowermockTest
 * Mockito 不能够 mock 静态方法，可以使用 Powermock。
 * PrepareForTest 里面对应的为static方法对应的类名
 * @author wjy
 * @date 2020-08-21 16:26
 * @since 1.0.0
 */
@RunWith(PowerMockRunner.class )
@PrepareForTest(MockitUtil.class )
public class PowermockTest {

    /**
     * mock对应静态方法
     * 另外一种方式可以自己写一个非静态的方法，对静态方法做个封装
     */
    @Test
    public void testSomething() {
        PowerMockito.mockStatic(MockitUtil.class);
        PowerMockito.when(MockitUtil.getMockitName()).thenReturn("test");
        Assert.assertEquals(MockitUtil.getMockitName(),"test");
    }


    /**
     * 另外一种方式可以自己写一个非静态的方法，对静态方法做个封装,在调用这个方法做mock
     */
    private void someMethod() {
        MockitUtil.getMockitName();
    }

}
