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
		
		Map<String, Object> params = new HashMap<>();
		
		String userName ="";
		
		String userAccountingName="";
		params.put(userName, userName);
		params.put(userAccountingName, userAccountingName);
		PagerBean users = accountingQueryServiceImpl.findAccountingByParams(params);
		
		System.out.println(99999);
		System.out.println(users);
	}
}
