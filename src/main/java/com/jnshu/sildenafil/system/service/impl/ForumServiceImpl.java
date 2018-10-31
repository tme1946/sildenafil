package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.mapper.ForumDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.ForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Service
public class ForumServiceImpl extends ServiceImpl<ForumDao, Forum> implements ForumService {
    @Autowired
    ForumDao forumDao;
    @Autowired
    StudentDao studentDao;
    @Override
    public List<Forum> FormFuzzySelect(String title,String author,long start,long end){
        QueryWrapper<Forum> wrapper = new QueryWrapper<>();
        if(author!= null) {
            QueryWrapper<Student> studentWrapper = new QueryWrapper<>();
            studentWrapper.select("id").like("nickname", author);
            List<Student> stuList = studentDao.selectList(studentWrapper);
            List idList = stuList.stream().map(Student::getId).collect(Collectors.toList());
            wrapper.in("student_id",idList);
        }
        if(title != null){
            wrapper.like("title",title);
        }
        if(end == 0){
            wrapper.ge("create_at",start);
        }else if(start == 0){
            wrapper.le("create_at",end);
        }else{
            wrapper.between("create_at",start,end);
        }
        wrapper.select("title","body","student_id","create_at");
        return forumDao.selectList(wrapper);
    }
}
