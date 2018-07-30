package me.zurex.fengxin.dao.user;

import me.zurex.fengxin.domain.user.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findByPhoneNumberAndPhoneAreaCode(String phoneNumber, String areaCode);
}
