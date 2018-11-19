package com.jnshu.sildenafil.feifei;

import com.jnshu.sildenafil.common.security.MyUserDetails;
import com.jnshu.sildenafil.common.security.TaUserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaUserDetailsServiceImplTest {
    @Autowired
    private TaUserDetailsServiceImpl taUserDetailsService;
    @Test
    public void loadUserByUsername() {
//        System.out.println(taUserDetailsService.loadUserByUsername("admin"));
//        MyUserDetails myUserDetails=
//                new MyUserDetails("","",AuthorityUtils.commaSeparatedStringToAuthorityList(""));
//        myUserDetails.get
    }
}