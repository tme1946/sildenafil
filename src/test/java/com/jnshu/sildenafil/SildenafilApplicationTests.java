package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SildenafilApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        long time = System.currentTimeMillis();
        User user = new User();
        user.setCreateAt(time);
        user.setCreateBy("GengGui");
        user.setPassword("dfaffafaffasfdfdsf");
        user.setRoleId(2323l);
        user.setUpdateAt(time);
        user.setUpdateBy("Taimur");
        user.setUserName("tom");
        userService.save(user);
    }

}
