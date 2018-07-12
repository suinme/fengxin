package me.zurex.fengxin.domain.forum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@Document(collection = "post")
public class PostModel {
    @Id
    private String id;
    private String tid;
    private String title;
    private String author;
    private String uid;
    private String content;
    private String image;
    private String avatar;
    private String createTime;
    private int likeCount;
    private int replyCount;

    public PostModel(
            String tid,
            String title,
            String author,
            String uid,
            String content,
            String image,
            String avatar,
            String createTime,
            int likeCount,
            int replyCount
    ) {
        this.tid = tid;
        this.title = title;
        this.author = author;
        this.uid = uid;
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

    public String getCreateTime() {
        return createTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }
}
