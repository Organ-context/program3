package osaccountingTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.accountingmag.service.IServerQuerySevice;
import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.osAccountingmag.service.IOsaccountingQueryService;
import com.ppxia.billing.osmag.service.IOsBeanHandleService;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;
import com.ppxia.billing.usermag.service.IUserQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class osAccountingmagTest {
	@Resource
	private IOsaccountingQueryService osaccountingQueryServiceImpl;

	@Resource
	private IOsBeanHandleService osBeanHandleServiceImpl;

	@Resource
	private IUserQueryService userQueryServiceImpl;

	@Resource
	private ITariffQueryService tariffQueryServiceImpl;

	@Resource
	private IServerQuerySevice serverQuerySeviceImpl;

	@Test
	public void testSaveOsBean() {
		OsBean newOs = new OsBean();
		newOs.setOsAccount("324");
		UserBean nowUser = userQueryServiceImpl.getUser(2l);
		newOs.setUserBean(nowUser);
		newOs.setTariffBean(tariffQueryServiceImpl.findTariffById(2l));
		newOs.setServerBean(serverQuerySeviceImpl.findServerById(2l));
		newOs.setOsState(1);
		osBeanHandleServiceImpl.saveOsBean(newOs);
	}

	@Test
	public void testFindOsYearAccountingByParams() {

		Map map = new HashMap();
		map.put("osAccount", "");
		map.put("IP", "");
		map.put("Year", "");
		PagerBean page = new PagerBean(1, 10);
		map.put("index", page.getIndex());
		map.put("page", page.getPage());

		PagerBean bean = osaccountingQueryServiceImpl.findOsYearAccountingByParams(page, map);
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

		PagerBean bean = osaccountingQueryServiceImpl.findOsMonthAccountingByParams(page, map);
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

		PagerBean bean = osaccountingQueryServiceImpl.findOsDayAccountingByParams(page, map);
		System.out.println(bean);

	}
}
