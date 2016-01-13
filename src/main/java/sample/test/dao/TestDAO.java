package sample.test.dao;

import org.charwer.cs.framework.jdbc.BaseSpringJDBCDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.test.bso.SpringJunitTest;
import sample.test.dto.Enterprise;
import sample.test.dto.User;

import java.util.List;

/**
 * Created by charwer on 2014/11/4 004.
 */
@Repository
@SpringJunitTest
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestDAO extends BaseSpringJDBCDAO {

    @Test
    public void testConn() {
//        System.out.println(jdbcTemplate);
        List<Enterprise> list = queryList("select id, name, address from be_enterprise", Enterprise.class);
        for (Enterprise u : list) {
            System.out.println(u.getName());
            System.out.println(u.getAddress());
        }
    }


    public void testAdd(User u) {
        String sql = "insert into users(id, username, password, createtime) values(null, :username, :password, now())";
        super.update(sql, u);
    }

    public void testUpdate(User user) {
        String sql = "update users set username='test20141120 1353' where id = 1";
        super.update(sql);
    }

}
