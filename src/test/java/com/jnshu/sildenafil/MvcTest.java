package com.jnshu.sildenafil;

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MvcTest {
//    @Test
//    public void contextLoads(){}
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext wac;
//    @Before // 在测试开始前初始化工作
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//    @Test
//    public void testQ1()throws Exception{
//        Integer type;
//        Long typeId;
//        MvcResult result = mockMvc.perform(post("/q1?address=合肥").content(JSONObject.toJSONString(map)))
//                .andExpect(status().isOk())
//    }
//
//}
