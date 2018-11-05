package com.my.sample.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.sample.mybatis.entity.po.User;
import com.my.sample.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Slf4j
@SpringBootTest
public class SampleMybatisApplicationTests {

    @Autowired
    UserService userService;

    private static Long userId;

    @BeforeAll
    public static void beforeAll() {
        log.info("开始单元测试");
    }


    @Test
    public void userAddTest() {
        User u = new User();
        u.setAge(RandomUtils.nextInt(18, 50));
        u.setName("测试" + RandomStringUtils.randomNumeric(5));
        u.setAddress("北京");
        u.setEmail("cs@163.com");
        u.setMobileNum("12377777778");
        u.setUid(RandomStringUtils.randomAlphanumeric(10));

        userService.save(u);

        userId = u.getId();

        log.info("创建用户测试结果：{}", u);
    }

    @Test
    public void userRemoveTest() {
        boolean r = userService.removeById(userId);
        log.info("删除用户结果：{}", r);
        assertThat(r, is(true));
    }

    @Test
    public void userGetTest() {
        User u = userService.getById(2);
        log.info("查询结果：{}", u);
    }

    @Test
    public void userListTest() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 40);
        List<User> list = userService.list(wrapper);
        log.info("查询结果：{}", list);

    }

    @Test
    public void contextLoads() {
        assertThat(4 * 25, is(4 * 5 * 5));
    }

    @AfterAll
    public static void afterAll() {
        log.info("结束单元测试");
    }

}
