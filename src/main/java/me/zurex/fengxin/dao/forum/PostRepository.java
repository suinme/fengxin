package me.zurex.fengxin.dao.forum;

import me.zurex.fengxin.domain.forum.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findFirst10ByTidGreaterThan(String id);

    List<PostModel> findFirst10ByIdGreaterThan(String id);

    PostModel findOneByTid(String tid);
}
