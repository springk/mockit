package com.springk.mockit;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * MockitRest
 *
 * @author wjy
 * @date 2020-08-21 16:21
 * @since 1.0.0
 */
public class MockitRestTest {


    /**
     * 重置
     */
    @Test
    public void resetMock(){
        List list = mock(List.class);
        when(list.size()).thenReturn(999);
        list.add(1);
        assertEquals(999,list.size());
        //重置mock，清除所有的互动和预设
        reset(list);
        assertEquals(0,list.size());
    }
}
