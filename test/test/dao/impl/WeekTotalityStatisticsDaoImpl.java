package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.WeekTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.WeekTotalityStatisticsRepository;
import com.alonelaval.entity.WeekTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="weekTotalityStatisticsDao")
public class WeekTotalityStatisticsDaoImpl  extends AbstractBaseDao<WeekTotalityStatistics,Integer> implements WeekTotalityStatisticsDao{

    @Autowired
    WeekTotalityStatisticsRepository weekTotalityStatisticsRepository;

    @Override
    protected BaseRepository<WeekTotalityStatistics, Integer> getBaseRepository() {
        return weekTotalityStatisticsRepository;
    }
}
