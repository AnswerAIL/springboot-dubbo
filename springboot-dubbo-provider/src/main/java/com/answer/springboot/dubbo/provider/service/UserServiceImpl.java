package com.answer.springboot.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.answer.springboot.dubbo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author Answer.AI.L
 * @date 2019-04-03
 */
@Component
@Service(interfaceClass = IUserService.class, retries = -1)
@Slf4j
public class UserServiceImpl implements IUserService {
    @Override
    public String findUser(String name) {
        log.info("find user by name[{}].", name);
        return String.format("user %s is a boy.", name);
    }

    @Override
    public int insertUser(String name) throws Exception {
        log.info("ready to insert user %s.", name);
        Assert.notNull(name, "name is empty, insert failed.");

        Assert.isTrue(!"answer".equals(name), "name "+ name +" write rejection.");

        log.info("insert user userName[{}].", name);
        return 1;
    }
}