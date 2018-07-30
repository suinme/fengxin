package me.zurex.fengxin.domain.forum;

import me.zurex.fengxin.domain.user.entity.UserModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@Table(name = "comment")
@Entity
public class CommentModel {
    @Id
    @GeneratedValue
    private long id;
    /**
     * @see PostModel#id
     */
    private String tid;
    private String author;
    /**
     * @see UserModel#id
     */
    private long uid;
    private String content;
    private String avatar;
    private long createTime;
    private int likeCount;

    public CommentModel(String tid, String author, long uid, String content, String avatar) {
        this.tid = tid;
        this.author = author;
        this.uid = uid;
        this.content = content;
        this.avatar = avatar;
        this.createTime = System.currentTimeMillis() / 1000;
        this.likeCount = 0;
    }


    public long getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public String getAuthor() {
        return author;
    }

    public long getUid() {
        return uid;
    }

    public String getContent() {
        return content;
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
}
