package com.alonelaval.service;

import com.alonelaval.entity.MonthTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface MonthTotalityStatisticsService  extends IBaseService<MonthTotalityStatistics,Integer> {
    default MonthTotalityStatistics addMonthTotalityStatistics(MonthTotalityStatistics monthTotalityStatistics) throws Exception{
    	return this.add(monthTotalityStatistics);
    }

}