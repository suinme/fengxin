package me.zurex.fengxin.dao.forum;

import me.zurex.fengxin.domain.forum.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zurex
 * @date 2018/6/19
 * Make life more fun
 */
public interface PostRepository extends MongoRepository<PostModel, String>{
    List<PostModel> findFirst10ByTidGreaterThan(String id);

    PostModel findOneByTid(String tid);
}
