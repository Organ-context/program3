package authorityTest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppxia.billing.authortymag.service.IAuthorityQueryService;
import com.ppxia.billing.authortymag.service.IAuthoryHandleService;
import com.ppxia.billing.beans.AuthorityBean;
import com.ppxia.billing.beans.TreeNode;
import com.ppxia.billing.utils.TreeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AuthorityTest {
	
	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;
	
	@Resource
	private IAuthoryHandleService authorityHandleServiceImpl;
	
	@Test
	public void queryAuthorityTest() {
//		List<AuthorityBean> datas = authorityQueryServiceImpl.findAuthorityBySuperAuthority(101);
//		System.out.println(datas);
		
//		AuthorityBean authority = authorityQueryServiceImpl.findLastAuthorityBySuperAuthority(101);
//		System.out.println(authority);
	}
	
	@Test
	public void handleAuthorityTest() {
		AuthorityBean authority = new AuthorityBean();
		authority.setAuthorityName("发发发");
		authority.setAuthorityNum(104+"");
		authorityHandleServiceImpl.saveAuthority(authority);
		
		//删除
//		authorityHandleServiceImpl.deleteAuthority(5l);
	}
	
	@Test
	public void getAuthoritys() {
		List<AuthorityBean> datas = authorityQueryServiceImpl.findAllAuthority();
		System.out.println(TreeUtil.tree(TreeUtil.toListNode(datas)));
	}
}
