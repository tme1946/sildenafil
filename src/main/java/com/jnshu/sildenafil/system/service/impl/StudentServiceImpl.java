package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jnshu.sildenafil.common.annotation.UseLog;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public Student login(String openId){
        return getOne(new QueryWrapper<Student>().eq("openid",openId));
    }
    @Override
    @UseLog("学生列表模糊查询")
    public IPage studentFuzzySelect(Integer page, Integer size,Long id,String nickname,Integer grade
            ,String email,Long phone,Integer status
            ,Integer minBean,Integer maxBean){
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        MyPage myPage = new MyPage(page,size);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like(null != id,"id",id);
        wrapper.like(null != nickname,"nickname",nickname);
        wrapper.like(null != grade,"grade",grade);
        wrapper.like(null != email,"email",email);
        wrapper.like(null != phone,"phone",phone);
        wrapper.like(null != status,"status",status);
        wrapper.ge(null != minBean ,"bean",minBean);
        wrapper.le(null != maxBean ,"bean",maxBean);
        return studentDao.selectPage(myPage,wrapper);
    }

}
