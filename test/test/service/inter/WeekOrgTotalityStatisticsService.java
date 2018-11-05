package com.alonelaval.service;

import com.alonelaval.entity.WeekOrgTotalityStatistics;
import com.alonelaval.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface WeekOrgTotalityStatisticsService  extends IBaseService<WeekOrgTotalityStatistics,Integer> {
    default WeekOrgTotalityStatistics addWeekOrgTotalityStatistics(WeekOrgTotalityStatistics weekOrgTotalityStatistics) throws Exception{
    	return this.add(weekOrgTotalityStatistics);
    }

}