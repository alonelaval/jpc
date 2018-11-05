package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.MonthOrgTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.MonthOrgTotalityStatisticsService;
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
@Service("monthOrgTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MonthOrgTotalityStatisticsServiceImpl extends AbstractBaseService<MonthOrgTotalityStatistics,Integer>  implements MonthOrgTotalityStatisticsService {
    @Autowired
    MonthOrgTotalityStatisticsDao monthOrgTotalityStatisticsDao;
    


  	@Override
    public Page<MonthOrgTotalityStatistics> findByModelAndPage(Model model, Page<MonthOrgTotalityStatistics> page) throws Exception {
        MonthOrgTotalityStatisticsModel monthOrgTotalityStatisticsModel = (MonthOrgTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return monthOrgTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<MonthOrgTotalityStatistics,Integer> getBaseDao() {
        return monthOrgTotalityStatisticsDao;
    }
}
