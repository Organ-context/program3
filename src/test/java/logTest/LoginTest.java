package logTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.service.ILoginlogHandleService;
import com.ppxia.billing.logmag.service.ILoginlogQueryService;
import com.ppxia.billing.logmag.service.IOperateLogQueryService;
import com.ppxia.billing.logmag.service.IOperatelogHandleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LoginTest {

	@Resource
	private ILoginlogHandleService loginlogHandleServiceImpl;
	
	@Resource
	private IOperatelogHandleService operatelogHandleServiceImpl;
	
	@Resource
	private ILoginlogQueryService loginlogQueryServiceImpl;
	@Resource
	private IOperateLogQueryService OperateLogQueryServiceImpl;
	@Test
	public void testQueryOperateLog() {
		Map<String, Object> map = new HashMap<>();
		map.put("OperateManagerName", "张");
		map.put("startingtime", null);
		map.put("endtime", null);
		map.put("index", 1);
		map.put("rows", 10);
		System.out.println("123456789");
		PagerBean pager = new PagerBean();
		pager.setIndex(1);
		pager.setRows(10);
		System.out.println(OperateLogQueryServiceImpl.findPagerByOperateLogBean(pager, map));
	}
	
	@Test
	public void testQueryLoginlog() {
		Map<String, Object> map = new HashMap<>();
		map.put("LoginManagerName", "dfghj");
		map.put("startingtime", null);
		map.put("endtime", null);
		map.put("index", 1);
		map.put("rows", 10);
		System.out.println("123456789");
		PagerBean pager = new PagerBean();
		pager.setIndex(1);
		pager.setRows(10);
		System.out.println(loginlogQueryServiceImpl.findPagerByLoginlogBean(pager, map));;
	}
	
	
	@Test
	public void testAddLog() {
		LoginLogBean log = new LoginLogBean();
		log.setLoginManagerName("ss822");
		log.setLoginManagerType("发发发");
		System.out.println(log);
		loginlogHandleServiceImpl.addLoginLogBean(log);
	}
	
	@Test
	public void testAddOperationlog() {
		OperateLogBean operation = new OperateLogBean();
		operation.setOperateManagerName("hhaha");
		operatelogHandleServiceImpl.addOperateLogBean(operation);
	}
}
