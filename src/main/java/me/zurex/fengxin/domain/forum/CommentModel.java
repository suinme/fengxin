package me.zurex.fengxin.domain.forum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@Document(collection = "comment")
public class CommentModel {
    @Id
    private String id;
    /**
     * @see PostModel#id
     */
    private String tid;
    private String author;
    /**
     * @see me.zurex.fengxin.domain.user.UserModel#id
     */
    private String uid;
    private String content;
    private String avatar;
    private String createTime;
    private int likeCount;

    public String getId() {
        return id;
    }

    public String getTid() {
        return tid;
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

    public String getAvatar() {
        return avatar;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getLikeCount() {
        return likeCount;
    }
}
