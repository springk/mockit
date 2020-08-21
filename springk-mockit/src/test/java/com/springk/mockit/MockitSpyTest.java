package com.springk.mockit;

import com.springk.mockit.util.MockitUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * MockitSpyTest
 * Spy是一个真实的对象，但它可以设置对象行为
 * @author wjy
 * @date 2020-08-21 16:09
 * @since 1.0.0
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitSpyTest {

    @Mock()
    private MockitUtil mockitUtil;

    @Test
    public void spyTest(){
        //通过spy来调用真实的api
        List list = spy(new ArrayList());
        list.add(1);
        assertEquals(1,list.size());

        //通过mock调用的不是真是的api
        List listMock = mock(List.class);
        listMock.add(1);
        assertEquals(0,listMock.size());

        //通过thenCallRealMethod来调用真实的api
        when(mockitUtil.doSomething(anyInt())).thenCallRealMethod();
        assertEquals(100,mockitUtil.doSomething(100));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void spyOnObjects(){
        List list = new LinkedList();
        List spy = spy(list);
        //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
        //when(spy.get(0)).thenReturn(3);

        //使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn(999).when(spy).get(999);
        //预设size()期望值
        when(spy.size()).thenReturn(100);
        //调用真实对象的api
        spy.add(1);
        spy.add(2);
        assertEquals(100,spy.size());
        assertEquals(1,spy.get(0));
        assertEquals(2,spy.get(1));
        verify(spy).add(1);
        verify(spy).add(2);
        assertEquals(999,spy.get(999));
    }




}
