package com.ppxia.billing.Echarts.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.Echarts.service.IEchartsService;
import com.ppxia.billing.beans.AccountingMonthBean;
import com.ppxia.billing.beans.EchartData;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.Series;

@Controller
@RequestMapping("/echartsJSP")
public class EchartAction {

	@Resource
	 private IEchartsService echartsServiceImpl;
	
	 @RequestMapping("/showEchartPie")
	    @ResponseBody
	    public EchartData PieData(String accountingName,String Month) throws UnsupportedEncodingException {
	        List<String> legend = new ArrayList<String>();
	        List<Map> serisData=new ArrayList<Map>();
          System.out.println(accountingName);
          System.out.println(Month);
  		Map params = new HashMap<>();
  		params.put("accountingName",new String(accountingName .getBytes("iso8859-1"),"utf-8") );
  		params.put("Month", Month);
          
	        List<OsMonthBean> list = (List<OsMonthBean>) echartsServiceImpl.findOsMonthEcharts(params);
	        System.out.println(list);
//	        for (OsMonthBean visit : list) {
//	            Map map =new HashMap();
//	            legend.add(visit.getMonth());
//	            map.put("value", visit.getValue());
//	            map.put("name",visit.getName());
//	            serisData.add(map);
//	        }
//	        List<Series> series = new ArrayList<Series>();// 纵坐标
//	        series.add(new Series("总数比较", "pie",serisData));
//	        EchartData data = new EchartData(legend,null, series);
	        return null;
	    }
	 
}
