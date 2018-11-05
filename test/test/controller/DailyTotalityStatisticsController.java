package com.alonelaval.controller;

import com.alonelaval.common.page.Page;
import com.alonelaval.entity.biz.DailyTotalityStatistics;
import com.alonelaval.entity.model.DailyTotalityStatisticsModel;
import com.alonelaval.service.IBaseService;
import com.alonelaval.service.user.DailyTotalityStatisticsService;
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
public class DailyTotalityStatisticsController extends AbstractController {

    @Autowired
    DailyTotalityStatisticsService dailyTotalityStatisticsService;

    @PostMapping("add")
    public Object add(@Validated DailyTotalityStatisticsModel dailyTotalityStatisticsModel) throws Exception {
       return  super.addBasic(dailyTotalityStatisticsModel);
    }

    @PostMapping("update")
    public Object update(@Validated DailyTotalityStatisticsModel dailyTotalityStatisticsModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(dailyTotalityStatisticsModel,id);
    }

    @PostMapping("list")
    public Object list(DailyTotalityStatisticsModel model, Page<DailyTotalityStatistics> page) throws Exception {
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
        return dailyTotalityStatisticsService;
    }

}
