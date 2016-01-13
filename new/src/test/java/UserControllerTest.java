import com.linktech.demo.controller.UserController;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.AppConfig;
import project.WebConfig;

/**
 * User: 飞
 * Date: 2015/12/17
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
public class UserControllerTest extends TestCase {

    MockMvc mockMvc;
    @Autowired
    public UserController userController;


    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetUserInfo() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/user/getUserInfo")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        String resultJson = mvcResult.getResponse().getContentAsString();
        Assert.assertNotNull(resultJson);
        System.out.println("结果为：" + resultJson);

    }
}
