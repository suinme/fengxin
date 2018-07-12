package me.zurex.fengxin.service.forum;

import me.zurex.fengxin.dao.forum.CommentRepository;
import me.zurex.fengxin.domain.forum.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zurex
 * @date 2018/6/25
 * Make life more fun
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentModel> findByTid(String tid){
        return commentRepository.findByTid(tid);
    }
}
