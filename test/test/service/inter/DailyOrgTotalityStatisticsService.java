package com.alonelaval.service;

import com.alonelaval.entity.DailyOrgTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface DailyOrgTotalityStatisticsService  extends IBaseService<DailyOrgTotalityStatistics,Integer> {
    default DailyOrgTotalityStatistics addDailyOrgTotalityStatistics(DailyOrgTotalityStatistics dailyOrgTotalityStatistics) throws Exception{
    	return this.add(dailyOrgTotalityStatistics);
    }

}