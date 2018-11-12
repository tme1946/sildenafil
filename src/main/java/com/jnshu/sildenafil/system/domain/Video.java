package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jnshu.sildenafil.common.validation.ArticleSave;
import com.jnshu.sildenafil.common.validation.ArticleUpdate;
import com.jnshu.sildenafil.common.validation.VideoSave;
import com.jnshu.sildenafil.common.validation.VideoUpdate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 视频id
     */
    @NotNull(message = "{video.id.validation.error}", groups = { VideoUpdate.class})
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
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 老师id
     */
    @NotNull(message = "{video.teacherId.validation.error}", groups = { VideoSave.class, VideoUpdate.class })
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 视频外链
     */
    @NotBlank(message = "{video.url.validation.error}", groups = {VideoSave.class, VideoUpdate.class })
    @TableField("url")
    private String url;

    /**
     * 正文
     */
    @NotBlank(message = "{video.body.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("body")
    private String body;

    /**
     * 类型（默认0card，1banner）
     */
    @NotNull(message = "{video.type.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("type")
    private Integer type;

    /**
     * 封面
     */
    @Max(value = 100, message = "{video.cover.validation.maxError}", groups = {VideoSave.class, VideoUpdate.class })
    @NotBlank(message = "{video.cover.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("cover")
    private String cover;

    /**
     * 年级（默认为全部0，初一1，初二2，初二3，高一4，高二5，高三6）
     */
    @NotNull(message = "{video.grade.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("grade")
    private Integer grade;

    /**
     * 科目（默认为全部0，数学1，语文2，英语3，物理4，化学5，生物6，政治7，历史8，地理9）
     */
    @NotNull(message = "{video.subject.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("subject")
    private Integer subject;

    /**
     * 摘要
     */
    @Max(value = 100,message = "{video.digest.validation.maxError}",groups = {VideoSave.class, VideoUpdate.class })
    @NotBlank(message = "{video.digest.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("digest")
    private String digest;

    /**
     * 标题
     */
    @Max(value = 50,message = "{video.title.validation.maxError}",groups = {VideoSave.class, VideoUpdate.class })
    @NotBlank(message = "{video.title.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("title")
    private String title;

    /**
     * 视频时长
     */
    @NotBlank(message = "{video.timeLength.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("time_length")
    private String timeLength;

    /**
     * 点赞数，默认0
     */
    @TableField("like_amount")
    private Integer likeAmount;

    /**
     * 收藏数，默认0
     */
    @TableField("collection_amount")
    private Integer collectionAmount;

    /**
     * 状态（默认0下架，1上架）
     */
    @NotNull(message = "{video.status.validation.error}",groups = {VideoSave.class, VideoUpdate.class })
    @TableField("status")
    private Integer status;

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
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getLikeAmount() {
        return likeAmount;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public void setLikeAmount(Integer likeAmount) {
        this.likeAmount = likeAmount;
    }
    public Integer getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(Integer collectionAmount) {
        this.collectionAmount = collectionAmount;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Video{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", teacherId=" + teacherId +
        ", url=" + url +
        ", body=" + body +
        ", type=" + type +
        ", cover=" + cover +
        ", grade=" + grade +
        ", subject=" + subject +
        ", digest=" + digest +
        ", title=" + title +
        ", timeLength=" + timeLength +
        ", likeAmount=" + likeAmount +
        ", collectionAmount=" + collectionAmount +
        ", status=" + status +
        "}";
    }
}
