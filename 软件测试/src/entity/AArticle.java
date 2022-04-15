package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AArticle)实体类
 *
 * @author makejava
 * @since 2022-04-10 19:47:07
 */
public class AArticle implements Serializable {
    private static final long serialVersionUID = -58163758507729075L;
    /**
     * 文章id值
     */
    private Integer articleId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章作者id
     */
    private String author;
    /**
     * 文章发表的时间
     */
    private Date publishedTime;
    /**
     * 文章的内容（HTML）
     */
    private String content;
    
    private String img;
    /**
     * 文章收藏数
     */
    private Integer collection;
    /**
     * 文章转发数
     */
    private Integer share;
    /**
     * 文章评论数
     */
    private Integer comment;
    /**
     * 文章点赞数
     */
    private Integer star;
    /**
     * 浏览量
     */
    private Integer pageView;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

}

