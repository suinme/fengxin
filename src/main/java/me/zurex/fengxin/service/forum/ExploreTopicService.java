package me.zurex.fengxin.service.forum;

import me.zurex.fengxin.dao.forum.CommentRepository;
import me.zurex.fengxin.dao.forum.PostRepository;
import me.zurex.fengxin.domain.forum.PostModel;
import me.zurex.fengxin.domain.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@Service
public class ExploreTopicService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<PostModel> getRecommendPost(String pid, int limit){
        return postRepository.findFirst10ByTidGreaterThan(pid);
    }

    public PostModel addPost(String title, String content, UserModel userModel){
        PostModel postModel = new PostModel(
                "", title, userModel.getNickName(), userModel.getId(), content,
                "", userModel.getAvatar(), new Date().toString(), 0, 0);
        postRepository.save(postModel);
        return postModel;
    }

    public PostModel findPost(String tid){
        return postRepository.findOneByTid(tid);
    }
}
