package com.jnshu.sildenafil;

import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil
 * @ClassName: MvcTest
 * @Description: java类作用描述
 * @Author: Taimur
 * @CreateDate: 2018/11/12 14:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcTest {
    private MockMvc mockMvc;
    @Autowired
    private org.springframework.web.context.WebApplicationContext webApplicationContext;
    @Before // 在测试开始前初始化工作
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testQ1()throws Exception{
     mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/reviews/type")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param("page", "1")
                    .param("size", "2")
                    .param("type","1")
                    .param("typeId","1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testVideo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/a/u/admin/video/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("page","1")
                .param("size","5")
                .param("title","t")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void uploadImg() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/a/image/upload/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("")

                );
    }
}
