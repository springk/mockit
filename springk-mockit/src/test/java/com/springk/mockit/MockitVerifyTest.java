package com.springk.mockit;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * MockitVerifyTest
 *
 * @author wjy
 * @date 2020-08-21 15:51
 * @since 1.0.0
 */
public class MockitVerifyTest {

    /**
     * 验证执行次数
     */
    @Test
    public void verifyTimes(){
        List list = mock(List.class);
        list.add(1);

        list.add(2);
        list.add(2);

        //验证是否被调用一次，等效于下面的times(1)
        verify(list).add(1);
        verify(list,times(1)).add(1);

        //验证是否被调用2次
        verify(list,times(2)).add(2);

        //验证是否从未被调用过
        verify(list,never()).add(3);

        //验证至少调用一次
        verify(list,atLeastOnce()).add(1);

        //验证至少调用2次
        verify(list,atLeast(2)).add(2);

        //验证至多调用2次
        verify(list,atMost(2)).add(2);
    }

    /**
     * 验证执行顺序
     */
    @Test
    public void verifyInOrders(){
        List list = mock(List.class);
        List list2 = mock(List.class);
        list.add(1);
        list2.add("hello");
        list.add(2);
        list2.add("mockit");
        //将需要排序的mock对象放入InOrder
        InOrder inOrder = inOrder(list,list2);
        //下面的代码不能颠倒顺序，验证执行顺序
        inOrder.verify(list).add(1);
        inOrder.verify(list2).add("hello");
        inOrder.verify(list).add(2);
        inOrder.verify(list2).add("mockit");
    }

}
