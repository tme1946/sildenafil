package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @NotNull(message = "{article.id.validation.error}")
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
     * 文章作者
     */
    @Max(value = 20,message = "{article.author.validation.maxError}")
    @NotBlank(message = "{article.author.validation.error}")
    @TableField("author")
    private String author;

    /**
     * 文章正文
     */
    @NotBlank(message = "{article.body.validation.error}")
    @TableField("body")
    private String body;

    /**
     * 类型（默认0正常，1banner）
     */
    @TableField("type")
    @NotNull(message = "{article.type.validation.error}")
    private Integer type;

    /**
     * 封面图片链接
     */
    @Max(value = 100,message = "{article.cover.validation.maxError}")
    @NotBlank(message = "{article.cover.validation.error}")
    @TableField("cover")
    private String cover;

    /**
     * 摘要
     */
    @Max(value = 100,message = "{article.digest.validation.maxError}")
    @NotBlank(message = "{article.digest.validation.error}")
    @TableField("digest")
    private String digest;

    /**
     * 标题
     */
    @Max(value = 50,message = "{article.title.validation.maxError}")
    @NotBlank(message = "{article.title.validation.error}")
    @TableField("title")
    private String title;

    /**
     * 点赞数
     */
    @TableField("like_amount")
    private Integer likeAmount;

    /**
     * 收藏数
     */
    @TableField("collection_amount")
    private Integer collectionAmount;

    /**
     * 状态（默认0下架，1上架）
     */
    @NotNull(message = "{article.status.validation.error}")
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
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return "Article{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", author=" + author +
        ", body=" + body +
        ", type=" + type +
        ", cover=" + cover +
        ", digest=" + digest +
        ", title=" + title +
        ", likeAmount=" + likeAmount +
        ", collectionAmount=" + collectionAmount +
        ", status=" + status +
        "}";
    }
}
