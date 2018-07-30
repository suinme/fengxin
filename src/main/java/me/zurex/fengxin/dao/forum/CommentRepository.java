package me.zurex.fengxin.dao.forum;

import me.zurex.fengxin.domain.forum.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByTid(String tid);
}
