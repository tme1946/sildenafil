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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 更新时间
     */
    @TableField("update_at")
    private Long updateAt;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * openId
     */
    @TableField("openid")
    private String openid;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 年级
     */
    @TableField("grade")
    private String grade;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 电话
     */
    @TableField("phone")
    private Long phone;

    /**
     * 逆袭豆
     */
    @TableField("bean")
    private Integer bean;

    /**
     * 状态（默认0正常，1为冻结）
     */
    @TableField("status")
    private Integer status;

    /**
     * 头像图像链接
     */
    @TableField("img")
    private String img;

    /**
     * 最高连续签到
     */
    @TableField("max_cont_sign")
    private Integer maxContSign;

    /**
     * 连续签到
     */
    @TableField("cont_sign")
    private Integer contSign;

    /**
     * 累计签到
     */
    @TableField("total_sign")
    private Integer totalSign;

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
    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public Integer getBean() {
        return bean;
    }

    public void setBean(Integer bean) {
        this.bean = bean;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public Integer getMaxContSign() {
        return maxContSign;
    }

    public void setMaxContSign(Integer maxContSign) {
        this.maxContSign = maxContSign;
    }
    public Integer getContSign() {
        return contSign;
    }

    public void setContSign(Integer contSign) {
        this.contSign = contSign;
    }
    public Integer getTotalSign() {
        return totalSign;
    }

    public void setTotalSign(Integer totalSign) {
        this.totalSign = totalSign;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", updateBy=" + updateBy +
        ", openid=" + openid +
        ", nickname=" + nickname +
        ", grade=" + grade +
        ", email=" + email +
        ", phone=" + phone +
        ", bean=" + bean +
        ", status=" + status +
        ", img=" + img +
        ", maxContSign=" + maxContSign +
        ", contSign=" + contSign +
        ", totalSign=" + totalSign +
        "}";
    }
}
