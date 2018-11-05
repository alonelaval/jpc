package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.MonthTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.MonthTotalityStatisticsService;
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
@Service("monthTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MonthTotalityStatisticsServiceImpl extends AbstractBaseService<MonthTotalityStatistics,Integer>  implements MonthTotalityStatisticsService {
    @Autowired
    MonthTotalityStatisticsDao monthTotalityStatisticsDao;
    


  	@Override
    public Page<MonthTotalityStatistics> findByModelAndPage(Model model, Page<MonthTotalityStatistics> page) throws Exception {
        MonthTotalityStatisticsModel monthTotalityStatisticsModel = (MonthTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return monthTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<MonthTotalityStatistics,Integer> getBaseDao() {
        return monthTotalityStatisticsDao;
    }
}
