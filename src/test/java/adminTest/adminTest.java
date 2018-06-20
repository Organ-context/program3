package adminTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.rolemag.dao.IRoleQueryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class adminTest {
	
	@Resource
	private IRoleQueryDao roleQueryDaoImpl;
	@Test
	public void testFind() {
		System.out.println(roleQueryDaoImpl.findRoleByRoleName("用户管理员"));;
	}
}
