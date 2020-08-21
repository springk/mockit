package com.springk.mockit;


import com.springk.mockit.domain.User;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * MockitDefineObjectIfNullTest
 *
 * @author wjy
 * @date 2020-08-21 15:34
 * @since 1.0.0
 */
public class MockitDefineObjectIfNullTest {

    /**
     * RETURNS_SMART_NULLS
     * 如果通过RETURNS_SMART_NULLS参数创建的mock对象在没有调用stubbed方法时会返回SmartNull。
     * 例如：返回类型是String，会返回"";是int，会返回0；是List，会返回空的List。
     * 另外，在控制台窗口中可以看到SmartNull的友好提示。
     */
    @Test()
    public void returnSmartNulls(){
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));

        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }

    /**
     * RETURNS_DEEP_STUBS
     * 使用该命令，可以操作该对象更深层次对象的操作，不会报空指针异常
     */
    @Test()
    public void returnDeepStubs(){
        User user = mock(User.class, RETURNS_DEEP_STUBS);
        when(user.getDeptment().getDeptName()).thenReturn("信息部");

        user.getDeptment().getDeptName();
        verify(user.getDeptment()).getDeptName();

        assertEquals("信息部",user.getDeptment().getDeptName());
    }

}
