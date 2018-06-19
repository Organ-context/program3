package accountingMonthTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.accountingMonthmag.service.IAccountingMonthQueryService;
import com.ppxia.billing.beans.PagerBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountingMonthTest {

	  @Resource
	  private IAccountingMonthQueryService  accountingMonthQueryServiceimpl;
	  
	  @Test
	  public void testFindAccountingMonthByParams() {
			Map map = new HashMap();
			map.put("userName", "");
			map.put("accountName", "");
			map.put("idcard", "");
			map.put("time", "");
			PagerBean page = new PagerBean(1, 10);
			map.put("index", page.getIndex());
			map.put("page", page.getPage());
			PagerBean bean=accountingMonthQueryServiceimpl.findAccountingMonthByParams(page, map);
			System.out.println(bean);
		  
		  
	  }
}
