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
 * @since 2018-10-31
 */
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 学生id
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 类型(无默认，1forum/2article/3video
     */
    @TableField("type")
    private Integer type;

    /**
     * 类型id
     */
    @TableField("type_id")
    private Long typeId;

    /**
     * 正文
     */
    @TableField("body")
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Review{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", studentId=" + studentId +
        ", type=" + type +
        ", typeId=" + typeId +
        ", body=" + body +
        "}";
    }
}
