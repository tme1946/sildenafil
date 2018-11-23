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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private org.springframework.web.context.WebApplicationContext webApplicationContext;
    @Before // 在测试开始前初始化工作
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getModuleList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/module/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userName","admin")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getModule() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("moduleId","34")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteModule() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("moduleId","44")
                .param("userName","admin")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void saveModule() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userName","admin")
                .param("name", "测试模块")
                .param("permission", "null:null")
                .param("url", "aaaaaafdfe")
                .param("type", "1")
                .param("parentId", "9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateModuleByModuleId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id","44")
                .param("name", "测试更新模块")
                .param("permission", "null:null")
                .param("url", "aaaaaafdfe")
                .param("type", "1")
                .param("parentId", "9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}