package com.answer.springboot.dubbo.consumer.controller;

import com.answer.springboot.dubbo.service.IAnswerService;
import com.answer.springboot.dubbo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Answer.AI.L
 * @date 2019-04-03
 */
@RestController
@RequestMapping("/")
@Slf4j
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IUserService userService;

    /**
     * http://127.0.0.1:9093/sdc/notice/answer
     * */
    @RequestMapping(value = "notice/{name}")
    public String notice(@PathVariable("name") String userName) {
        String msg = answerService.notice(userName);
        log.info("notice {} and response message: {}.", userName, msg);
        return msg;
    }


    /**
     * http://127.0.0.1:9093/sdc/insertUser/answer
     * */
    @RequestMapping(value = "insertUser/{name}")
    public String insert(@PathVariable("name") String userName) {
        int id;
        try {
            id = userService.insertUser(userName);
        } catch (Exception e) {
            return e.getMessage();
        }
        return String.format("user %s is insert successful, user id %d.", userName, id);
    }


    /**
     * http://127.0.0.1:9093/sdc/findUser/answer
     * */
    @RequestMapping(value = "findUser/{name}")
    public String findUser(@PathVariable("name") String userName) {
        String msg = userService.findUser(userName);
        log.info("find user[{}]response message: {}.", userName, msg);
        return msg;
    }


}