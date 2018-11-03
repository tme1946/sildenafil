package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.mapper.SignDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * #Title: SignTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/2-16:53
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SignTest {
    @Autowired
    private SignService signService;

    @Test
    public void testSign() {
        boolean a = signService.sign(1L);
        log.info("boolean is: {}", a);
    }

}
