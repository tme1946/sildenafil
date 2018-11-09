package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.Sign;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-02
 */
@SuppressWarnings("unused")
public interface SignService extends IService<Sign> {

    /**
     * 学生签到
     *
     * @param studentId 实体对象
     * @return 签到是否成功
     */
    boolean addSign(Long studentId);

    /**
     * 进入签到页面
     * 查询一个月（31天）签到记录
     * 根据签到记录判断当天是否签到
     * @param studentId 学生id
     * @return 该学生签到记录List
     */
    List getSignList(Long studentId);

}
