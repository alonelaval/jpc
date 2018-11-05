package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.DailyTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.DailyTotalityStatisticsRepository;
import com.alonelaval.entity.DailyTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="dailyTotalityStatisticsDao")
public class DailyTotalityStatisticsDaoImpl  extends AbstractBaseDao<DailyTotalityStatistics,Integer> implements DailyTotalityStatisticsDao{

    @Autowired
    DailyTotalityStatisticsRepository dailyTotalityStatisticsRepository;

    @Override
    protected BaseRepository<DailyTotalityStatistics, Integer> getBaseRepository() {
        return dailyTotalityStatisticsRepository;
    }
}
