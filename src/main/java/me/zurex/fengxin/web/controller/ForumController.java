package me.zurex.fengxin.web.controller;

import me.zurex.fengxin.domain.forum.CommentModel;
import me.zurex.fengxin.domain.forum.PostModel;
import me.zurex.fengxin.domain.user.UserModel;
import me.zurex.fengxin.service.forum.CommentService;
import me.zurex.fengxin.service.forum.ExploreTopicService;
import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.util.ApiResponseBuilder;
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
    @Autowired
    private ExploreTopicService exploreTopicService;

    @Autowired
    private CommentService commentService;

    private static int PAGE_SIZE = 15;

    @RequestMapping("/addPost")
    public ApiResponse addNewPost(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam UserModel userModel
    ){
        PostModel postModel = exploreTopicService.addPost(title, content, userModel);
        return ApiResponseBuilder.buildSuccessResponse(postModel);
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
