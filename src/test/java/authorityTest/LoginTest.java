package authorityTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.logmag.service.ILoginlogHandleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LoginTest {

	
	@Resource
	private ILoginlogHandleService iLoginlogHandleServiceImpl;
	
	@Test
	public void testAddLog() {
		LoginLogBean log = new LoginLogBean();
		log.setLoginManagerName("ereas");
		iLoginlogHandleServiceImpl.addLoginLogBean(log);
	}
}
