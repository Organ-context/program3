package com.ppxia.billing.accountingMonthmag.service;

import com.ppxia.billing.beans.OsDayBean;

public interface IAccouningHandleService {

	/**
	 * 在添加了日账单之后调用该方法,修改账务账号下的总费用
	 * @param osDayBean  传入一个日账单
	 */
	public void updateMothMony(OsDayBean osDayBean);
}
