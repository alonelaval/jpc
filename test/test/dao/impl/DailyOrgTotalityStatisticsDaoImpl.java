package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.DailyOrgTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.DailyOrgTotalityStatisticsRepository;
import com.alonelaval.entity.DailyOrgTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="dailyOrgTotalityStatisticsDao")
public class DailyOrgTotalityStatisticsDaoImpl  extends AbstractBaseDao<DailyOrgTotalityStatistics,Integer> implements DailyOrgTotalityStatisticsDao{

    @Autowired
    DailyOrgTotalityStatisticsRepository dailyOrgTotalityStatisticsRepository;

    @Override
    protected BaseRepository<DailyOrgTotalityStatistics, Integer> getBaseRepository() {
        return dailyOrgTotalityStatisticsRepository;
    }
}
