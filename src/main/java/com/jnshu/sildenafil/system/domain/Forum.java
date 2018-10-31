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
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
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
     * 帖子题目
     */
    @TableField("title")
    private String title;

    /**
     * 帖子正文
     */
    @TableField("body")
    private String body;

    /**
     * 回帖数
     */
    @TableField("review_amount")
    private Integer reviewAmount;

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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public Integer getReviewAmount() {
        return reviewAmount;
    }

    public void setReviewAmount(Integer reviewAmount) {
        this.reviewAmount = reviewAmount;
    }

    @Override
    public String toString() {
        return "Forum{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", studentId=" + studentId +
        ", title=" + title +
        ", body=" + body +
        ", reviewAmount=" + reviewAmount +
        "}";
    }
}
