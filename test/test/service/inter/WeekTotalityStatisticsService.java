package com.alonelaval.service;

import com.alonelaval.entity.WeekTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface WeekTotalityStatisticsService  extends IBaseService<WeekTotalityStatistics,Integer> {
    default WeekTotalityStatistics addWeekTotalityStatistics(WeekTotalityStatistics weekTotalityStatistics) throws Exception{
    	return this.add(weekTotalityStatistics);
    }

}