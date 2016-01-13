/*package sample.ssm.bso;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linktech.mybatis.model.BeEnterprise;
import com.linktech.mybatis.template.TemplateDao;

import sample.test.bso.SpringJunitTest;

@Repository
@SpringJunitTest
@RunWith(value = SpringJUnit4ClassRunner.class)
public class SSMBSO2{
	
	@Autowired
	protected TemplateDao templateDao;
	
	@Test
    public void testConn(){
		System.out.println(templateDao);
    }
	
    public BeEnterprise findOne(String id) throws Exception{
		BeEnterprise enterprise = (BeEnterprise) templateDao.queryOne("BeEnterpriseDao.find", id);
		System.out.println(enterprise);
		return enterprise;
    }
	
	@SuppressWarnings("unchecked")
	@Test
    public List<BeEnterprise> findAll() throws Exception{
		List<BeEnterprise> list = (List<BeEnterprise>) templateDao.queryAll("BeEnterpriseDao.get");
//		for (BeEnterprise beEnterprise : list) {
//			System.out.println(beEnterprise.getId());
//			System.out.println(beEnterprise.getName());
//			System.out.println(beEnterprise.getAddress());
//		}
		return list;
	}
	
    public void update(BeEnterprise enterprise) throws Exception{
		System.out.println(templateDao.update("BeEnterpriseDao.update", enterprise));
    }
	
    public void insert(BeEnterprise enterprise) throws Exception{
		System.out.println(templateDao.add("BeEnterpriseDao.insert", enterprise));
    }
	
    public void delete(String id) throws Exception{
		System.out.println(templateDao.delete("BeEnterpriseDao.delete", id));
    }
	
    @Test
	public void test() throws Exception{
    	findOne("44");
	}
    
}
*/