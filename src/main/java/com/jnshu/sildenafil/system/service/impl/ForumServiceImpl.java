package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.mapper.ForumDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.ForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
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
    public IPage forumFuzzySelect(Integer page, Integer size, String title, String author, Long start, Long end){
        IPage myPage = new MyPage(page,size).setDesc("create_at");
        QueryWrapper<Forum> wrapper = new QueryWrapper<>();
        if(author!= null) {
            QueryWrapper<Student> studentWrapper = new QueryWrapper<>();
            studentWrapper.select("id").like("nickname", author);
            List<Student> stuList = studentDao.selectList(studentWrapper);
            List idList = stuList.stream().map(Student::getId).collect(Collectors.toList());
            wrapper.in("student_id",idList);
        }
        wrapper.like(null != title,"title",title)
                .ge(null != start,"create_at",start)
                .le(null != end,"create_at",end)
                .select("title","body","student_id","create_at")
                .orderByDesc("create_at");
        return forumDao.selectPage(myPage,wrapper);
    }
}
