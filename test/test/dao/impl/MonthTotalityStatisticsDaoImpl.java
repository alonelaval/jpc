package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.MonthTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.MonthTotalityStatisticsRepository;
import com.alonelaval.entity.MonthTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="monthTotalityStatisticsDao")
public class MonthTotalityStatisticsDaoImpl  extends AbstractBaseDao<MonthTotalityStatistics,Integer> implements MonthTotalityStatisticsDao{

    @Autowired
    MonthTotalityStatisticsRepository monthTotalityStatisticsRepository;

    @Override
    protected BaseRepository<MonthTotalityStatistics, Integer> getBaseRepository() {
        return monthTotalityStatisticsRepository;
    }
}
