package com.ppxia.billing.accountingmag.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingQueryService {

	
	public PagerBean findAccountingByParams(Map params);
}
