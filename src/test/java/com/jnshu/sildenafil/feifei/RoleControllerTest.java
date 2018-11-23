package com.jnshu.sildenafil.feifei;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private org.springframework.web.context.WebApplicationContext webApplicationContext;
    @Before // 在测试开始前初始化工作
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getRoleList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/role/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("page","1")
                .param("size","5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getRoleByRoleId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/role")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("roleId","2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteRoleByRoleId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/a/u/admin/role")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("roleId","1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void saveRole() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/a/u/admin/role")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("roleName","test222")
                .param("moduleIdList","5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateRoleModuleByRoleId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/role/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("roleId","2")
                .param("moduleIdList","{1,2,3,4,5,6,7,8,9,10,11}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}