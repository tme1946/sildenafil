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

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockAllTest {
    private MockMvc mockMvc;
    @Autowired
    private org.springframework.web.context.WebApplicationContext webApplicationContext;
    @Before // 在测试开始前初始化工作
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void articleGetTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/article")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("articleId", "2")
                .param("studentId", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void articleGetListTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/article/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("page", "2")
                .param("size", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void userGetTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userId", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void userSaveTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/a/u/admin/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userId", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void roleSaveTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/a/u/admin/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userId", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void userGetPageTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/user/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("page", "1")
                .param("size", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void moduleSaveTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name", "留言删除")
                .param("permission", "review:delete")
                .param("url", "/a/u/admin/review")
                .param("type", "1")
                .param("parentId", "9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void moduleUpdateTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/a/u/admin/module")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id","34")
                .param("name", "留言列表")
                .param("permission", "review:list")
                .param("url", "/a/u/admin/review/list")
                .param("type", "1")
                .param("parentId", "9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
