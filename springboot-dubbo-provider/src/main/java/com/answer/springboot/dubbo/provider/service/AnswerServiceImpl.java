package com.answer.springboot.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.answer.springboot.dubbo.service.IAnswerService;
import org.springframework.stereotype.Component;

/**
 * @author Answer.AI.L
 * @date 2019-04-03
 *
 * 注意 @Service 是 dubbo 中的注释而不是spring中的
 */
@Service(interfaceClass = IAnswerService.class, retries = -1)
@Component
public class AnswerServiceImpl implements IAnswerService {
    @Override
    public String notice(String name) {
        return "Hello "+ name +", Hello Dubbo";
    }
}