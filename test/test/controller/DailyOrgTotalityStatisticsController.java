package com.alonelaval.controller;

import com.alonelaval.common.page.Page;
import com.alonelaval.entity.biz.DailyOrgTotalityStatistics;
import com.alonelaval.entity.model.DailyOrgTotalityStatisticsModel;
import com.alonelaval.service.IBaseService;
import com.alonelaval.service.user.DailyOrgTotalityStatisticsService;
import com.alonelaval.controller.AbstarctController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("invoice")
public class DailyOrgTotalityStatisticsController extends AbstractController {

    @Autowired
    DailyOrgTotalityStatisticsService dailyOrgTotalityStatisticsService;

    @PostMapping("add")
    public Object add(@Validated DailyOrgTotalityStatisticsModel dailyOrgTotalityStatisticsModel) throws Exception {
       return  super.addBasic(dailyOrgTotalityStatisticsModel);
    }

    @PostMapping("update")
    public Object update(@Validated DailyOrgTotalityStatisticsModel dailyOrgTotalityStatisticsModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(dailyOrgTotalityStatisticsModel,id);
    }

    @PostMapping("list")
    public Object list(DailyOrgTotalityStatisticsModel model, Page<DailyOrgTotalityStatistics> page) throws Exception {
        return  super.listBasic(model,page);
    }

    @PostMapping("/disable")
    public Object disable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.disableBasic(ids);
    }
    @PostMapping("/enable")
    public Object enable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.enableBasic(ids);
    }
    @PostMapping("/delete")
    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.deleteBasic(ids);
    }

    @Override
    protected IBaseService getBaseService() {
        return dailyOrgTotalityStatisticsService;
    }

}
