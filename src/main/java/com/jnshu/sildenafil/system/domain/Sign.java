package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Taimur
 * @since 2018-10-30
 */
public class Sign implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 签到id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("creat_at")
    private Long creatAt;

    /**
     * 学生id
     */
    @TableField("student_id")
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Long creatAt) {
        this.creatAt = creatAt;
    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Sign{" +
        "id=" + id +
        ", creatAt=" + creatAt +
        ", studentId=" + studentId +
        "}";
    }
}
