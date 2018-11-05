package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.DailyOrgTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.DailyOrgTotalityStatisticsService;
import lombok.extern.slf4j.Slf4j;
import com.alonelaval.common.page.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("dailyOrgTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class DailyOrgTotalityStatisticsServiceImpl extends AbstractBaseService<DailyOrgTotalityStatistics,Integer>  implements DailyOrgTotalityStatisticsService {
    @Autowired
    DailyOrgTotalityStatisticsDao dailyOrgTotalityStatisticsDao;
    


  	@Override
    public Page<DailyOrgTotalityStatistics> findByModelAndPage(Model model, Page<DailyOrgTotalityStatistics> page) throws Exception {
        DailyOrgTotalityStatisticsModel dailyOrgTotalityStatisticsModel = (DailyOrgTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return dailyOrgTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<DailyOrgTotalityStatistics,Integer> getBaseDao() {
        return dailyOrgTotalityStatisticsDao;
    }
}
