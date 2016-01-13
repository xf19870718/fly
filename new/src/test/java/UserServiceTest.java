import com.linktech.demo.service.UserService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.AppConfig;

/**
 * name: UserService测试类
 * User: 飞
 * Date: 2015/12/17
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class UserServiceTest extends TestCase {
    @Autowired
    public UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetUserInfo() throws Exception {
        assertEquals("大飞", userService.getUserInfo("1").getName());
        assertEquals(28, userService.getUserInfo("").getAge());
        assertEquals("xufei0718@163.com", userService.getUserInfo("").getEmail());
    }
}
