package com.jnshu.sildenafil.feifei;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private UserDao userDao;

    @Test
    public void testUpdateUserById() {

        try {
            log.warn("{}",userService.updateUserByUserId(null));
        }catch (ServiceException se){
            log.error("error{}",se.getMessage());
        }

    }

    @Test
    public void userTest1() {
        User user=null;
        System.out.println(userDao.updateById(null));
    }

    @Test
    public void getUserPageTest() {
        IPage iPage=userService.getUserList(null,null,null,
                "o");
        System.out.println(iPage);
    }
}
