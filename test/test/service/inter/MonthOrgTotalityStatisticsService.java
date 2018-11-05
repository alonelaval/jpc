package com.alonelaval.service;

import com.alonelaval.entity.MonthOrgTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface MonthOrgTotalityStatisticsService  extends IBaseService<MonthOrgTotalityStatistics,Integer> {
    default MonthOrgTotalityStatistics addMonthOrgTotalityStatistics(MonthOrgTotalityStatistics monthOrgTotalityStatistics) throws Exception{
    	return this.add(monthOrgTotalityStatistics);
    }

}