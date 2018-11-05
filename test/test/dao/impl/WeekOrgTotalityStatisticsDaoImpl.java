package com.alonelaval.dao.impl;

import com.alonelaval.dao.AbstractBaseDao;
import com.alonelaval.dao.WeekOrgTotalityStatisticsDao;
import com.alonelaval.repository.BaseRepository;
import com.alonelaval.repository.WeekOrgTotalityStatisticsRepository;
import com.alonelaval.entity.WeekOrgTotalityStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="weekOrgTotalityStatisticsDao")
public class WeekOrgTotalityStatisticsDaoImpl  extends AbstractBaseDao<WeekOrgTotalityStatistics,Integer> implements WeekOrgTotalityStatisticsDao{

    @Autowired
    WeekOrgTotalityStatisticsRepository weekOrgTotalityStatisticsRepository;

    @Override
    protected BaseRepository<WeekOrgTotalityStatistics, Integer> getBaseRepository() {
        return weekOrgTotalityStatisticsRepository;
    }
}
