package com.alonelaval.controller;

import com.alonelaval.common.page.Page;
import com.alonelaval.entity.biz.WeekTotalityStatistics;
import com.alonelaval.entity.model.WeekTotalityStatisticsModel;
import com.alonelaval.service.IBaseService;
import com.alonelaval.service.user.WeekTotalityStatisticsService;
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
public class WeekTotalityStatisticsController extends AbstractController {

    @Autowired
    WeekTotalityStatisticsService weekTotalityStatisticsService;

    @PostMapping("add")
    public Object add(@Validated WeekTotalityStatisticsModel weekTotalityStatisticsModel) throws Exception {
       return  super.addBasic(weekTotalityStatisticsModel);
    }

    @PostMapping("update")
    public Object update(@Validated WeekTotalityStatisticsModel weekTotalityStatisticsModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(weekTotalityStatisticsModel,id);
    }

    @PostMapping("list")
    public Object list(WeekTotalityStatisticsModel model, Page<WeekTotalityStatistics> page) throws Exception {
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
        return weekTotalityStatisticsService;
    }

}
