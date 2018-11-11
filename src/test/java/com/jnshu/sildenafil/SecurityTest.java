package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.mapper.ModuleDao;
import com.jnshu.sildenafil.system.mapper.RoleDao;
import com.jnshu.sildenafil.system.mapper.RoleModuleDao;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
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
public class SecurityTest {
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private RoleModuleService roleModuleService;
    @Autowired(required = false)
    private RoleService roleService;
    @Autowired(required = false)
    private ModuleService moduleService;

    @Test
    public void testGetUserName() {

        userService.getUserByUserName(null);
    }

}
