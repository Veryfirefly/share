package cool.likeu.share.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cool.likeu.share.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import static org.junit.Assert.assertTrue;

@SpringBootTest
class TestShareUserMapper {

    @Autowired
    private ShareUserMapper shareUserMapper;

    @Test
    void testUserMapperAction() {
        User testUserBean = new User();
        testUserBean.setUsername("xiaoyu");
        testUserBean.setPassword(DigestUtils.md5DigestAsHex("xiaoyu123".getBytes()));
        testUserBean.setNickName("XiaoYu");

        int insertVal = shareUserMapper.insert(testUserBean);
        assertTrue(insertVal > 0);
    }

    @Test
    void testQueryUserMapperAction() {
        shareUserMapper.selectList(null)
                .forEach(System.out::println);
    }

    @Test
    void testQueryByConditionUserMapperAction() {
        shareUserMapper.selectList(
                Wrappers.<User>lambdaQuery().eq(User::getUsername, "xiaoyu"))
                .forEach(System.out::println);
    }
}
