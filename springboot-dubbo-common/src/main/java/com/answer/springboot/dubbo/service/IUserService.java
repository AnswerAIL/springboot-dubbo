package com.answer.springboot.dubbo.service;

/**
 * @author Answer.AI.L
 * @date 2019-04-03
 */
public interface IUserService {

    /**
     * 查询用户
     *
     * @param name 用户名
     *
     * @return string
     * */
    String findUser(String name);

    /**
     * 新增用户
     *
     * @param name 用户名
     *
     * @return int
     *
     * @throws Exception e
     * */
    int insertUser(String name) throws Exception;

}