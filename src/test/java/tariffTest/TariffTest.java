package tariffTest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.tariffmag.service.ITariffHandleService;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TariffTest {
	
	@Resource
	private ITariffHandleService tariffHandleServiceImpl;
	
	@Resource
	private ITariffQueryService tariffHandleQueryImpl;
	
	@Test
	public void tariffTest() {
		
		TariffBean tariff = new TariffBean();
		tariff.setPerCost(22);
		tariff.setTariffName("包月");
		tariffHandleServiceImpl.saveTariff(tariff);
		
//		tariffHandleServiceImpl.deleteTariff(1l);
//		
//		tariffHandleServiceImpl.updateTariff(tariff);
	}
	
	@Test
	public void updateTest() {
		int datas = tariffHandleQueryImpl.findIdByName("包月");
		System.out.println(datas);
//		TariffBean tariff =datas.get(0);
//		tariff.setTariffName("ushdh");
//		tariffHandleServiceImpl.updateTariff(tariff);
	}
}
