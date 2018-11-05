package com.alonelaval.service;

import com.alonelaval.entity.DailyTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface DailyTotalityStatisticsService  extends IBaseService<DailyTotalityStatistics,Integer> {
    default DailyTotalityStatistics addDailyTotalityStatistics(DailyTotalityStatistics dailyTotalityStatistics) throws Exception{
    	return this.add(dailyTotalityStatistics);
    }

}