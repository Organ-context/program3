package accountingTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.accountingmag.service.IAccountingHandleService;
import com.ppxia.billing.accountingmag.service.IAccountingQueryService;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountingTest {
	
	@Resource
	private IAccountingHandleService accountingHandleServiceImpl;
	
	@Resource
	private IAccountingQueryService accountingQueryServiceImpl;
	
	@Test
	public void accountingTest() {
		//添加测试
//		UserBean accounting = new UserBean();
//		accounting.setUserAccountingName("大幅度");
//		accounting.setUserAccountingState(0);
//		accountingHandleServiceImpl.saveAndFlushAccounting(accounting);
		
		//查询测试
		Map<String, Object> params = new HashMap<>();
		
		PagerBean pager = new PagerBean();
		pager.setPage(1);
		pager.setRows(3);
		
		String userName ="";
		String userAccountingName="";
		params.put("userName", userName);
		params.put("userAccountingName", userAccountingName);
		PagerBean users = accountingQueryServiceImpl.findAccountingByParams(pager, params);
		System.out.println(users);
		
		//修改测试
		UserBean user = new UserBean();
		UserBean user1 = (UserBean) users.getDatas().get(0);
		Long id = user1.getId();
		user.setId(id);
		user.setUserAccountingState(999);
		accountingHandleServiceImpl.updateAccountingState(user);
	}
}
