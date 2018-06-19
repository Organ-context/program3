package osmagTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osmag.service.IOsQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OsmagTest {
   
	@Resource
	  private IOsQueryService osQueryServiceImpl;
	
	@Test
	public void testfindOsDayBeansByParams() {
		Map map = new HashMap();
		map.put("accountingName", "账务");
		map.put("osaccount", "账单账号");
		map.put("serverip", "192.168.1.1");
		map.put("time", "2018-06");
		PagerBean page = new PagerBean(1, 10);
		map.put("index", page.getIndex());
		map.put("page", page.getPage());
		PagerBean bean=osQueryServiceImpl.findOsDayBeansByParams(page, map);
		System.out.println(bean);
		
		
	}
	@Test
	public void testFindOsMonthBeansByAccountingAndMonth() {
		Map map = new HashMap();
		map.put("accountingName", "账务");
		map.put("Month", "2018-12");
		PagerBean page = new PagerBean(1, 10);
		map.put("index", page.getIndex());
		map.put("page", page.getPage());
		PagerBean bean=osQueryServiceImpl.findOsMonthBeansByAccountingAndMonth(page, map);
		System.out.println(bean);
	}
}
