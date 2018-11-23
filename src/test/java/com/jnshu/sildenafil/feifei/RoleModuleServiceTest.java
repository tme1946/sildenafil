package com.jnshu.sildenafil.feifei;

import com.jnshu.sildenafil.system.service.RoleModuleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleModuleServiceTest {
    @Autowired
    private RoleModuleService roleModuleService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getModuleIdListByRoleId() {
    }

    @Test
    public void saveRoleModule() throws Exception{
    }

    @Test
    public void deleteRoleModuleByRoleId() {
    }

    @Test
    public void deleteRoleModuleByRMid() {
    }

    @Test
    public void deleteRoleModuleByUserName() {
    }

    @Test
    public void updateRoleModuleByRoleId() {
    }

    @Test
    public void saveRoleModuleListByRoleId() throws Exception{
        ArrayList<Long> moduleIdList =new ArrayList<>(40);
        long j;
        for (int i = 10; i < 30; i++) {
            j = i+20;
            moduleIdList.add(i-10, j);
        }
        System.out.println(moduleIdList);
        roleModuleService.updateRoleModuleByRoleId(2L,moduleIdList);
    }

    @Test
    public void saveRoleModuleByUserName() {
    }
}