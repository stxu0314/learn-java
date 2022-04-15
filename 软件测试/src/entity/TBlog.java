package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TBlog)实体类
 *
 * @author makejava
 * @since 2022-04-10 21:05:05
 */
public class TBlog implements Serializable {
    private static final long serialVersionUID = -19161891689568588L;
    
    private Long id;
    
    private String appreciation;
    
    private String commentabled;
    
    private String content;
    
    private Date createTime;
    
    private String description;
    
    private String firstPicture;
    
    private String flag;
    
    private String published;
    
    private String recommend;
    
    private String shareStatement;
    
    private String title;
    
    private Date updateTime;
    
    private Integer views;
    
    private Long typeId;
    
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(String commentabled) {
        this.commentabled = commentabled;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(String shareStatement) {
        this.shareStatement = shareStatement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

