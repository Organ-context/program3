package com.ppxia.billing.aspects;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ppxia.billing.annotation.operlog;
import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperationlogHandleDao;
@Component
@Aspect
public class OperationLogAspect {
	@Resource
	private IOperationlogHandleDao iOperationlogDaohandle;

//	@Pointcut(value="execution(* com.project.telecom.logmag.dao*.impl.*DaoImpl.*(..))")
//	public void pointcut() {}
	@Pointcut(value="@annotation(com.ppxia.billing.annotation.operlog)")
	public void annotation() {}
	
	@Before(value="annotation() && @annotation(operlog) ")
	public void beforeAdvice(JoinPoint jp,operlog operlog) { 		
        OperateLogBean  bean = new OperateLogBean();
//        bean.setOperateManagerName(operateManagerName);//操作者名称
//        bean.setOperateManagerType(operateManagerType);//操作类型
//        bean.setOperateTime(operateTime);//操作时间
       
		Object target = jp.getTarget();//目标对象
		String method = jp.getSignature().getName();//目标方法
		Object[] objs = jp.getArgs();//目标方法中，接收的参数
        String Model = operlog.module();//操作模板--操作模块
//        int systemModel=Integer.parseInt(Model);
        bean.setSystemModel(Model);
		int type = operlog.type();
		if (type==1) {
			bean.setOperateOperation("增加");
		}else if (type==2) {
			bean.setOperateOperation("删除");
		}else if (type==3) {
			bean.setOperateOperation("修改");
		}else if (type==0) {
			bean.setOperateOperation("0");
		}
		
		
//		
//		String string = Arrays.deepToString(objs);
//		bean.setOperateOperation(string);
      
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		bean.setOperateTime(date);
		iOperationlogDaohandle.save(bean);
		
	
	}
	
	
	
	
	
}
