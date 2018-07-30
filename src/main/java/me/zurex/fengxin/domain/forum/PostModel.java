package me.zurex.fengxin.domain.forum;

import javafx.geometry.Pos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@Table(name = "topic")
@Entity
public class PostModel {
    @Id
    @GeneratedValue
    private long id;
    private String tid;
    private String title;
    private String tag;
    private String author;
    private String uid;
    private String content;
    private String image;
    private String avatar;
    private long createTime;
    private int likeCount;
    private int replyCount;

    public PostModel(){

    }

    public PostModel(
            String tid,
            String title,
            String author,
            String uid,
            String tag,
            String content,
            String image,
            String avatar,
            long createTime,
            int likeCount,
            int replyCount
    ) {
        this.tid = tid;
        this.title = title;
        this.author = author;
        this.uid = uid;
        this.tag = tag;
        this.content = content;
        this.image = image;
        this.avatar = avatar;
        this.createTime = createTime;
        this.likeCount = likeCount;
        this.replyCount = replyCount;
    }

    public String getTid() {
        return tid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUid() {
        return uid;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public String getAvatar() {
        return avatar;
    }

    public long getCreateTime() {
        return createTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
