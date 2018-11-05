package com.alonelaval.controller;

import com.alonelaval.common.page.Page;
import com.alonelaval.entity.biz.WeekOrgTotalityStatistics;
import com.alonelaval.entity.model.WeekOrgTotalityStatisticsModel;
import com.alonelaval.service.IBaseService;
import com.alonelaval.service.user.WeekOrgTotalityStatisticsService;
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
public class WeekOrgTotalityStatisticsController extends AbstractController {

    @Autowired
    WeekOrgTotalityStatisticsService weekOrgTotalityStatisticsService;

    @PostMapping("add")
    public Object add(@Validated WeekOrgTotalityStatisticsModel weekOrgTotalityStatisticsModel) throws Exception {
       return  super.addBasic(weekOrgTotalityStatisticsModel);
    }

    @PostMapping("update")
    public Object update(@Validated WeekOrgTotalityStatisticsModel weekOrgTotalityStatisticsModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(weekOrgTotalityStatisticsModel,id);
    }

    @PostMapping("list")
    public Object list(WeekOrgTotalityStatisticsModel model, Page<WeekOrgTotalityStatistics> page) throws Exception {
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
        return weekOrgTotalityStatisticsService;
    }

}
