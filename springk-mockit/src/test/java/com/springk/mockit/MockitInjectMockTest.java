package com.springk.mockit;


import com.springk.mockit.dao.UserDao;
import com.springk.mockit.domain.User;
import com.springk.mockit.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.anyString;

/**
 * MockitInjectMockTest
 *
 * @author wjy
 * @date 2020-08-21 15:34
 * @since 1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitInjectMockTest {

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


    @Before
    public void init(){
        //将UserDao实例对象注入到userService中，如果不进行此操作，userService中的userDao对象为null
        ReflectionTestUtils.setField(userService, "userDao", userDao);
    }

    /**
     * 模拟userDao.getByName方法的返回对象，参数为任意String类型
     */
    @Test
    public void getUserInfoByname(){
        Mockito.when(userDao.getByName(anyString())).thenReturn(getUserInfoInstance());

        User user= userService.getUserInfo("mockit");
        Assert.assertEquals("mockit-testname",user.getName());
    }

    /**
     * mock对应user对象，用来测试
     * @return User
     */
    private User getUserInfoInstance() {
        User user = new User();
        user.setName("mockit-testname");
        user.setSex("male");
        user.setAge(18);
        return user;
    }
}
