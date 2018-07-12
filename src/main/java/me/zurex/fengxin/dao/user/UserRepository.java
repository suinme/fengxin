package me.zurex.fengxin.dao.user;

import me.zurex.fengxin.domain.user.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public interface UserRepository extends MongoRepository<UserModel, String> {
    UserModel findByPhoneNumberAndPhoneAreaCode(String phoneNumber, String areaCode);
}
