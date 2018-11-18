package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.common.exception.ParamIsNullException;
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
     *  学生签到
     * @param studentId 学生id
     * @return 签到是否成功
     * @throws ParamIsNullException 空参
     */
    boolean addSign(Long studentId) throws ParamIsNullException;

    /**
     * 进入签到页面
     * 查询一个月（31天）签到记录
     * 根据签到记录判断当天是否签到
     * @param studentId 学生id
     * @return 该学生签到记录List
     * @throws ParamIsNullException 空参
     */
    List getSignList(Long studentId) throws ParamIsNullException;

}
