package com.springk.mockit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * MockitReturnAnswerTest
 *
 * @author wjy
 * @date 2020-08-21 16:01
 * @since 1.0.0
 */
public class MockitReturnAnswerTest {

    @Mock
    private List mockList;

    /**
     * 初始化mock：MockitoAnnotations.initMocks(this);
     * 等同于在类上面使用@RunWith(MockitoJUnitRunner.class)标签
     */
    @Before
    public void testBefore(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Answer结构测试
     */
    @Test
    public void answerTest(){
        when(mockList.get(anyInt())).thenAnswer(new MockitAnswer());
        assertEquals("hello mockit:1",mockList.get(1));
        assertEquals("hello mockit:999",mockList.get(999));
    }

    private class MockitAnswer implements Answer<String> {
        @Override
        public String answer(InvocationOnMock invocation){
            Object[] args = invocation.getArguments();
            return "hello mockit:"+args[0];
        }
    }

    /**
     * thenReturn使用
     * any() 匹配任何的参数
     * anyInt() 匹配int类型的参数
     */
    @Test
    public void returnTest(){
        when(mockList.get(anyInt())).thenReturn("mockit");
        assertEquals("mockit",mockList.get(0));
    }

}
