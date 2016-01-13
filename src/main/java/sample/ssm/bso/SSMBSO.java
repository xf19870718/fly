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
public class SSMBSO{
	
	@Autowired
	protected TemplateDao templateDao;
	
	@SuppressWarnings("unchecked")
	@Test
    public void testConn() throws Exception{
		System.out.println(templateDao);
		
		
       List<BeEnterprise> list = (List<BeEnterprise>) templateDao.queryAll("BeEnterpriseDao.get");
        for(BeEnterprise e:list){
        	System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getAddress());
        }
    }
	
	@Test
    public void update() throws Exception{
		BeEnterprise beEnterprise = new BeEnterprise();
		beEnterprise.setId("36");
		beEnterprise.setName("我改了");
		System.out.println(templateDao.update("BeEnterpriseDao.update", beEnterprise));
    }
	
	@Test
    public void insert() throws Exception{
		BeEnterprise beEnterprise = new BeEnterprise();
		beEnterprise.setName("我新加的");
		beEnterprise.setAddress("新的");
		System.out.println(templateDao.add("BeEnterpriseDao.insert", beEnterprise));
    }
	
	@Test
    public void delete() throws Exception{
		System.out.println(templateDao.delete("BeEnterpriseDao.delete", "42"));
    }
    
}
*/