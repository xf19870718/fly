package sample.test.bso;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.test.dao.TestDAO;
import sample.test.dto.User;

/**
 * Created by charwer on 2014/11/4 004.
 */
@Service
public class TestBSO {

    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    protected TestDAO dao;

    public void testConn() {
        System.out.println("service");
        dao.testConn();
    }

    public void testAdd() {
//    	User user = new User("user20141113", "1337");
        User user = new User("炭花20150318", "123456");
        dao.testAdd(user);
        logger.debug("test add");
    }

    public void testUpdate() {
        dao.testUpdate(new User());
        logger.info("test update");
    }

    @Transactional
    public void testTransactional() {
        this.testAdd();
//		long a = 1/0;
        this.testUpdate();
    }

}
