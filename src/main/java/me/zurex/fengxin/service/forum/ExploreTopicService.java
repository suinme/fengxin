package me.zurex.fengxin.service.forum;

import me.zurex.fengxin.dao.forum.CommentRepository;
import me.zurex.fengxin.dao.forum.PostRepository;
import me.zurex.fengxin.domain.forum.CommentModel;
import me.zurex.fengxin.domain.forum.PostModel;
import me.zurex.fengxin.domain.user.entity.UserModel;
import me.zurex.fengxin.service.exception.AuthException;
import me.zurex.fengxin.service.exception.TokenException;
import me.zurex.fengxin.service.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TokenService tokenService;

    public List<PostModel> getRecommendPost(String pid, int limit){
        return postRepository.findFirst10ByTidGreaterThan(pid);
    }

    public PostModel addPost(
            String title, String tag, String content, String token
    ) throws AuthException{
        try {
            UserModel userModel = tokenService.getUserByToken(token);
            PostModel postModel = new PostModel(
                    String.valueOf(System.currentTimeMillis()),
                    title,
                    userModel.getNickName(),
                    String.valueOf(userModel.getId()),
                    tag,
                    content,
                    "",
                    userModel.getAvatar() == null ? "": userModel.getAvatar(),
                    System.currentTimeMillis()/1000,
                    0,
                    0
            );
            postRepository.save(postModel);
            return postModel;
        }catch (TokenException e){
            throw new AuthException(e);
        }
    }

    public PostModel findPost(String tid){
        return postRepository.findOneByTid(tid);
    }

    public CommentModel addComment(String tid, String content, String token
    )throws AuthException{
        try {
            UserModel userModel = tokenService.getUserByToken(token);
            CommentModel commentModel = new CommentModel(
                    tid, userModel.getNickName(), userModel.getId(),
                    content, userModel.getAvatar());
            commentRepository.save(commentModel);
            return commentModel;
        }catch (TokenException e){
            throw new AuthException(e);
        }
    }
}
