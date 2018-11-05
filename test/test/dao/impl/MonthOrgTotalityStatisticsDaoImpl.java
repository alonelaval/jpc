package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.MonthOrgTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.MonthOrgTotalityStatisticsRepository;
import com.alonelaval.entity.MonthOrgTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="monthOrgTotalityStatisticsDao")
public class MonthOrgTotalityStatisticsDaoImpl  extends AbstractBaseDao<MonthOrgTotalityStatistics,Integer> implements MonthOrgTotalityStatisticsDao{

    @Autowired
    MonthOrgTotalityStatisticsRepository monthOrgTotalityStatisticsRepository;

    @Override
    protected BaseRepository<MonthOrgTotalityStatistics, Integer> getBaseRepository() {
        return monthOrgTotalityStatisticsRepository;
    }
}
