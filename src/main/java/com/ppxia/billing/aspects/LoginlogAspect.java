package com.ppxia.billing.aspects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ppxia.billing.annotation.Loginlog;
import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.logmag.service.ILoginlogHandleService;

@Component
@Aspect
public class LoginlogAspect {
	
	@Resource
	private ILoginlogHandleService loginlogHandleServiceimpl;
	
	@Pointcut(value="@annotation(com.ppxia.billing.annotation.Loginlog)")
	public void annotation(){}
	
	@AfterReturning(value="annotation() && @annotation(mylog)")
	public void afterAdvice(JoinPoint jp,Loginlog mylog) {
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LoginLogBean loginLogBean=new LoginLogBean();
		HttpSession session=request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		LoginLogBean log = new LoginLogBean();
		log.setLoginManagerName(user.getUserName());
		loginlogHandleServiceimpl.addLoginLogBean(log);
		System.out.println("---------------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Resource
//	private ILoginlogHandleDao OperateLogHandleDao;
//   
//	@Pointcut(value="@annotation(com.ppxia.billing.annotation.operlog)")
//	public void annotation() {}

//	@Before(value="annotation() && @annotation(operlog) ")
//	public void beforeAdvice(JoinPoint jp,operlog operlog) { 		
//        OperateLogBean  bean = new OperateLogBean();
////        bean.setOperateManagerName(operateManagerName);//操作者名称
////        bean.setOperateManagerType(operateManagerType);//操作类型
////        bean.setOperateTime(operateTime);//操作时间
//       
//		Object target = jp.getTarget();//目标对象
//		String method = jp.getSignature().getName();//目标方法
//		Object[] objs = jp.getArgs();//目标方法中，接收的参数
//        String Model = operlog.module();//操作模板--操作模块
////        int systemModel=Integer.parseInt(Model);
//        bean.setSystemModel(Model);
//		int type = operlog.type();
//		if (type==1) {
//			bean.setOperateOperation("增加");
//		}else if (type==2) {
//			bean.setOperateOperation("删除");
//		}else if (type==3) {
//			bean.setOperateOperation("修改");
//		}else if (type==0) {
//			bean.setOperateOperation("0");
//		}
//		
//		
////		
////		String string = Arrays.deepToString(objs);
////		bean.setOperateOperation(string);
//      
//		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		bean.setOperateTime(date);
//		OperateLogHandleDao.save(bean);
//		
	
	
	
	
	
	
}
