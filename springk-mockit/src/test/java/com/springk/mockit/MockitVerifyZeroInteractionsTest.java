package com.springk.mockit;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * MockitVerifyZeroInteractionsTest
 * 确保模拟对象上无互动发生
 * @author wjy
 * @date 2020-08-21 16:23
 * @since 1.0.0
 */
public class MockitVerifyZeroInteractionsTest {


    /**
     * 确保模拟对象上无互动发生
     */
    @Test
    public void verify_interaction(){
        List list = mock(List.class);
        List list2 = mock(List.class);
        List list3 = mock(List.class);
        list.add(100);
        verify(list).add(100);
        verify(list,never()).add(200);
        //验证零互动行为
        verifyZeroInteractions(list2,list3);
    }


}
