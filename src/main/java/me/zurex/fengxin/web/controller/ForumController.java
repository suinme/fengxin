package me.zurex.fengxin.web.controller;

import me.zurex.fengxin.domain.forum.CommentModel;
import me.zurex.fengxin.domain.forum.PostModel;
import me.zurex.fengxin.domain.user.entity.UserModel;
import me.zurex.fengxin.service.exception.AuthException;
import me.zurex.fengxin.service.forum.CommentService;
import me.zurex.fengxin.service.forum.ExploreTopicService;
import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.base.BaseStatus;
import me.zurex.fengxin.web.util.ApiResponseBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
@RestController
@RequestMapping("/api/forum")
public class ForumController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForumController.class);
    @Autowired
    private ExploreTopicService exploreTopicService;

    @Autowired
    private CommentService commentService;

    private static int PAGE_SIZE = 15;

    @RequestMapping("/addPost")
    public ApiResponse addNewPost(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String tag,
            @RequestParam String token
    ){
        try {
            PostModel postModel = exploreTopicService.addPost(title, tag, content, token);
            return ApiResponseBuilder.buildSuccessResponse(postModel);
        } catch (AuthException e){
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, e.getMessage());
        }
    }

    @RequestMapping("/addComment")
    public ApiResponse addComment(
            @RequestParam String tid,
            @RequestParam String content,
            @RequestParam String token
    ){
        try {
            CommentModel commentModel = exploreTopicService.addComment(tid, content, token);
            return ApiResponseBuilder.buildSuccessResponse(commentModel);
        } catch (AuthException e){
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/topics")
    public ApiResponse listPosts(
            @RequestParam String tid,
            @RequestParam(required = false) UserModel userModel
    ){
        List<PostModel> postModels = exploreTopicService.getRecommendPost(tid, PAGE_SIZE);
        return ApiResponseBuilder.buildSuccessResponse(postModels);
    }

    @RequestMapping("/topics/{tid}")
    public ApiResponse fetchTopic(
            @PathVariable String tid,
            @RequestParam(required = false) UserModel userModel
    ){
        PostModel postModel = exploreTopicService.findPost(tid);
        return ApiResponseBuilder.buildSuccessResponse(postModel);
    }

    @RequestMapping("/topics/{tid}/comments")
    public ApiResponse fetchComments(
            @PathVariable String tid,
            @RequestParam(required = false) UserModel userModel
    ){
        List<CommentModel> commentModels = commentService.findByTid(tid);
        return ApiResponseBuilder.buildSuccessResponse(commentModels);
    }
}
