package com.springk.mockit;


import com.springk.mockit.dao.UserDao;
import com.springk.mockit.domain.User;
import com.springk.mockit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

/**
 * MockitThorwExceptionTest
 *
 * @author wjy
 * @date 2020-08-21 15:34
 * @since 1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitThorwExceptionTest {

    /**
     * 注入userService对象
     */
    @InjectMocks
    private UserService userService;

    /**
     * UserDao模拟数据层调用，创建UserDao实例对象
     */
    @Mock
    private UserDao userDao;

    /**
     * mockit 抛出异常
     * 异常抛出有两种方式：
     * 1、方法有返回值的异常抛出
     * 2、void方法异常抛出 （抛出的异常要实际的异常类，不能直接抛出基类Exception()）
     */
    @Test(expected = Exception.class)
    public void testMockitThrowException(){
        //1、方法有返回值的异常抛出
        Mockito.when(userDao.getByName(anyString())).thenThrow(new NullPointerException());
        User user= userService.getUserInfo("mockit");

        //2、void方法异常抛出 （抛出的异常要实际的异常类，不能直接抛出基类new Exception()）
        doThrow(new RuntimeException()).when(userDao).deleteByName(anyString());
        userService.deletByName("mockit");
    }


}
