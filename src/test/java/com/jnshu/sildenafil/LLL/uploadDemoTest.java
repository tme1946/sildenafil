package com.jnshu.sildenafil.LLL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * #Title: uploadDemoTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/15-19:08
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class uploadDemoTest {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 在每次测试执行前构建mvc环境
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    /**
     * 测试上传文件
     */
    @Test
    public void whenUploadFileSuccess() {
        try {
            String result =  mockMvc.perform(
                    MockMvcRequestBuilders
                            .multipart("/a/image/upload/")
//                            .fileUpload("/file")
                            .file(new MockMultipartFile(
                                    "file",
                                    "test.txt",
                                    ",multipart/form-data",
                                    "hello upload".getBytes("UTF-8"))
                            )
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void test() throws Exception {
//
//        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
//        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());
//        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
//
//        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload")
//                .file(firstFile)
//                .file(secondFile).file(jsonFile)
//                .param("some-random", "4"))
//                .andExpect(status().is(200))
//                .andExpect(content().string("success"));
//    }



}
