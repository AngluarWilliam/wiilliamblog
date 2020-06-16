package com.example.service;

import com.example.common.lang.Result;
import com.example.entity.MUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shiro.AccountProfile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MUserService extends IService<MUser> {

    Result register(MUser user);

    AccountProfile login(String username, String password);
}
