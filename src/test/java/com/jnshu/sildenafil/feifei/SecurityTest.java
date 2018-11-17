package com.jnshu.sildenafil.feifei;


import com.jnshu.sildenafil.common.exception.ServiceException;
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

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void roleModuleUpdateTest() {
        List<Long> moduleIdList = new ArrayList<>();
        long j;
        for (int i = 0; i < 10; i++) {
            j = i+2;
            moduleIdList.add(i, j);
        }
        System.out.println(moduleIdList);
        try {
            roleModuleService.updateRoleModuleByRoleId(1L, new ArrayList<>());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void moduleUpdateTest() {
        List<Long> moduleIdList = new ArrayList<>();
        long j;
        for (int i = 0; i < 10; i++) {
            j = i+2;
            moduleIdList.add(i, j);
        }

    }
}