package com.my.sample.mybatis.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.sample.mybatis.entity.po.User;
import com.my.sample.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestRunner implements CommandLineRunner {

    private UserService userService;

    public TestRunner(UserService userService) {
        this.userService = userService;
    }

    @NewSpan
    @Override
    public void run(String... args) throws Exception {
        Wrapper<User> wrapper = new QueryWrapper<>();
        int c = userService.count(wrapper);
        log.info("当前用户数：{}", c);
    }
}
