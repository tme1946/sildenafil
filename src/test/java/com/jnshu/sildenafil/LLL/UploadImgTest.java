package com.jnshu.sildenafil.LLL;

import com.jnshu.sildenafil.system.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * #Title: UploadImgTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/15-11:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UploadImgTest {

    @Test
    public void uploadImg() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpput = new HttpGet("https://lihoo.oss-cn-beijing.aliyuncs.com/800.jpg?Expires=1542269522&OSSAccessKeyId=TMP.AQHgH59Zuk51mcX_ugPDIxdS3XAvufol9a7gSSFXH_zv0w_AA04p8VWKSviBAAAwLAIUclxoYxaHhH2I8jqEFEH_vSW6bUsCFHHHkf9HxxmSoG4QLHevK3Y0alVI&Signature=b7yj8vfXMRGUZWh64qkNLnFG2o8%3D");
        HttpPut httpput = new HttpPut("https://lihoo.oss-cn-beijing.aliyuncs.com/900.jpg");

        InputStream inputStream = new FileInputStream("C:\\Users\\lihoo\\Desktop\\456.png");
        InputStreamEntity in = new InputStreamEntity(inputStream);
        httpput.setEntity(in);

//        File file = new File("G:\\maven_work\\Tiles\\src\\main\\webapp\\imges\\687.png");
//        HttpPut httpput = new HttpPut("https://lihoo.oss-cn-beijing.aliyuncs.com/789.jpg");
//        FileEntity in = new FileEntity(file);

        CloseableHttpResponse response = httpclient.execute(httpput);
//        InputStream inputStream = response.getEntity().getContent();
//        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\lihoo\\Desktop\\123.png");
//        byte[] buf = new byte[1024 * 8];
//        int read;
//        while ((read = inputStream.read(buf)) > 0) {
//            fileOut.write(buf, 0, read);
//        }
        System.out.println(response);
    }

    @Autowired
    private VideoService videoService;

    @Test
    public void upImgById() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut("https://lihoo.oss-cn-beijing.aliyuncs.com/911.jpg");
        File file = new File("C:\\Users\\lihoo\\Desktop\\456.png");
        FileEntity in = new FileEntity(file);
        httpput.setEntity(in);
        CloseableHttpResponse response = httpclient.execute(httpput);
        System.out.println(response);

//        uploadFileService.uploadFile( "", 1);

    }
}
