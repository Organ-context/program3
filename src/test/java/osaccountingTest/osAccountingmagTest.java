package osaccountingTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osAccountingmag.service.IOsaccountingQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class osAccountingmagTest {
	  @Resource
	  private IOsaccountingQueryService osaccountingQueryServiceImpl;
	  
	  
	  @Test
	  public void testFindOsYearAccountingByParams() {
		  
		  Map map = new HashMap();
			map.put("osAccount", "");
			map.put("IP", "");
			map.put("Year", "");
			PagerBean page = new PagerBean(1, 10);
			map.put("index", page.getIndex());
			map.put("page", page.getPage());
		  
			PagerBean bean=osaccountingQueryServiceImpl.findOsYearAccountingByParams(page, map);
			System.out.println(bean);
		  
	  }
	  
	  
	  @Test
	  public void testFindOsMonthAccountingByParams() {
		  
		  Map map = new HashMap();
			map.put("osAccount", "");
			map.put("IP", "");
			map.put("month", "");
			PagerBean page = new PagerBean(1, 10);
			map.put("index", page.getIndex());
			map.put("page", page.getPage());
		  
			PagerBean bean=osaccountingQueryServiceImpl.findOsMonthAccountingByParams(page, map);
			System.out.println(bean);
		  
	  }
	  
	  
	  @Test
	  public void testFindOsDayAccountingByParams() {
		  
		  Map map = new HashMap();
			map.put("osAccount", "");
			map.put("IP", "");
			PagerBean page = new PagerBean(1, 10);
			map.put("index", page.getIndex());
			map.put("page", page.getPage());
		  
			PagerBean bean=osaccountingQueryServiceImpl.findOsDayAccountingByParams(page, map);
			System.out.println(bean);
		  
	  }
}
