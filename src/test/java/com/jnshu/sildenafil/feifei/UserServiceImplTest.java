package com.jnshu.sildenafil.feifei;

import com.jnshu.sildenafil.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserList() {
    }

    @Test
    public void getUserByUserName() {
    }

    @Test
    public void getRoleIdByUserName() {
        System.out.println(userService.getRoleIdByUserName("admin"));
    }

    @Test
    public void getUserByUserId() {
    }

    @Test
    public void deleteUserByUserId() {
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void updateUserByUserId() {
    }

    @Test
    public void updateUserPasswordByUserId() throws Exception {
        userService.updateUserPasswordByUserId("123456","123456",1L);
    }

    @Test
    public void userLoginTest() throws Exception{
        System.out.println(userService.userLogin("admin", "123456"));
    }


}