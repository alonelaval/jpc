package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.DailyTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.DailyTotalityStatisticsService;
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
@Service("dailyTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class DailyTotalityStatisticsServiceImpl extends AbstractBaseService<DailyTotalityStatistics,Integer>  implements DailyTotalityStatisticsService {
    @Autowired
    DailyTotalityStatisticsDao dailyTotalityStatisticsDao;
    


  	@Override
    public Page<DailyTotalityStatistics> findByModelAndPage(Model model, Page<DailyTotalityStatistics> page) throws Exception {
        DailyTotalityStatisticsModel dailyTotalityStatisticsModel = (DailyTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return dailyTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<DailyTotalityStatistics,Integer> getBaseDao() {
        return dailyTotalityStatisticsDao;
    }
}
