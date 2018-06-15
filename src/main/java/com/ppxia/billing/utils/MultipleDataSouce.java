package com.ppxia.billing.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSouce extends AbstractRoutingDataSource{
	
	public static final String dataSource="dataSource";
	public static final String datasource2="dataSource2";
	
	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
	
	public static void setDataSouceKey(String dataSouce) {
		dataSourceKey.set(dataSouce);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return dataSourceKey.get();
	}
	
}
