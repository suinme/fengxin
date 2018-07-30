package me.zurex.fengxin.service.forum;

import me.zurex.fengxin.dao.forum.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zurex
 * @date 2018/6/25
 * Make life more fun
 */
@RestController
@RequestMapping("/api/forum")
public class PostService {
    @Autowired
    private CommentRepository commentRepository;
}
