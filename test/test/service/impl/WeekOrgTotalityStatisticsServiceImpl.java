package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.WeekOrgTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.WeekOrgTotalityStatisticsService;
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
@Service("weekOrgTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class WeekOrgTotalityStatisticsServiceImpl extends AbstractBaseService<WeekOrgTotalityStatistics,Integer>  implements WeekOrgTotalityStatisticsService {
    @Autowired
    WeekOrgTotalityStatisticsDao weekOrgTotalityStatisticsDao;
    


  	@Override
    public Page<WeekOrgTotalityStatistics> findByModelAndPage(Model model, Page<WeekOrgTotalityStatistics> page) throws Exception {
        WeekOrgTotalityStatisticsModel weekOrgTotalityStatisticsModel = (WeekOrgTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return weekOrgTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<WeekOrgTotalityStatistics,Integer> getBaseDao() {
        return weekOrgTotalityStatisticsDao;
    }
}
