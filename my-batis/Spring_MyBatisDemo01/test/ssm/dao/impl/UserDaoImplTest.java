package ssm.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.UserDao;
import ssm.mapper.UserMapper;
import ssm.po.User;

public class UserDaoImplTest {


    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");//得到spring容器
    }

    /*@Test
    public void findUserById() throws Exception {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");//获取这个bean
        User user = userDao.findUserById(1);
        System.out.println(user);
    }*/

    @Test
    public void findUserById() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}