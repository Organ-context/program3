package adminTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.rolemag.dao.IRoleQueryDao;
import com.ppxia.billing.usermag.service.IUserQueryService;
import com.ppxia.billing.usermag.service.impl.UserQueryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class adminTest {
	
	@Resource
	private IRoleQueryDao roleQueryDaoImpl;
	
	@Resource
	private IUserQueryService userQueryServiceImpl;
	@Test
	public void testFind() {
		System.out.println(roleQueryDaoImpl.findRoleByRoleName("用户管理员"));;
	}
	
	
	@Test
	public void testGetadminById() {
		System.out.println(userQueryServiceImpl.getUser(14l));
	}
}
