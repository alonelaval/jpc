package com.alonelaval.servce.impl.com.alonelaval;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.dao.inter.IBaseDao;
import com.alonelaval.dao.inter.WeekTotalityStatisticsDao;
import com.alonelaval.entity.biz.User;
import com.alonelaval.servce.impl.AbstractBaseService;
import com.alonelavalservice.WeekTotalityStatisticsService;
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
@Service("weekTotalityStatisticsService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class WeekTotalityStatisticsServiceImpl extends AbstractBaseService<WeekTotalityStatistics,Integer>  implements WeekTotalityStatisticsService {
    @Autowired
    WeekTotalityStatisticsDao weekTotalityStatisticsDao;
    


  	@Override
    public Page<WeekTotalityStatistics> findByModelAndPage(Model model, Page<WeekTotalityStatistics> page) throws Exception {
        WeekTotalityStatisticsModel weekTotalityStatisticsModel = (WeekTotalityStatisticsModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return weekTotalityStatisticsDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<WeekTotalityStatistics,Integer> getBaseDao() {
        return weekTotalityStatisticsDao;
    }
}
