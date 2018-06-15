package accountingTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.accountingmag.service.IAccountingHandleService;
import com.ppxia.billing.beans.AccountingBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountingTest {
	
	@Resource
	private IAccountingHandleService accountingHandleServiceimpl;
	
	@Test
	public void testSaveAccounting() {
		AccountingBean accounting = new AccountingBean(1, 1, 1, null, null);
		accountingHandleServiceimpl.saveAndFlushAccounting(accounting);
	}
	
}
