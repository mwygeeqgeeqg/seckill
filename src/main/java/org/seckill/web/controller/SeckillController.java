package org.seckill.web.controller;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by liguotao on 17/9/17.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) { 
        List<Seckill> seckillList = seckillService.getSeckillList();
        model.addAttribute("list", seckillList);
        return "list";
    }

    @RequestMapping(value = "{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {

        return "detail";
    }

    @RequestMapping(value = "{seckillId}/exposer", method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public SeckillResult<Exposer> exposer(Long seckillId) {
        SeckillResult<Exposer> seckillResult = null;
        try{
        Exposer exposer=  seckillService.exportSeckillUrl(seckillId);
        seckillResult= new SeckillResult<Exposer>(true,exposer);

        }catch (Exception e){
            e.getMessage();
        }
        return seckillResult;
    }
    @RequestMapping(value = "/{seckillId}/{md5}/execution",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public SeckillResult<SeckillExecution>  execution(@PathVariable("seckillId") Long seckillId,
                                                      @PathVariable("md5") String md5,@CookieValue(value = "killPhone",required=false) Long phone){
        if (phone==null){

            return new SeckillResult<SeckillExecution>(true,"未注册");
        }
        SeckillExecution seckllExecution= null;
        try {
            seckllExecution = seckillService.executeSeckill(seckillId,phone,md5);
            return  new SeckillResult<SeckillExecution>(true,seckllExecution);

        }catch (RepeatKillException e1){
            SeckillExecution seckillExceution= new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false,seckillExceution);
        }catch (SeckillCloseException e2){
            SeckillExecution seckillExceution= new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS.END);
            return new SeckillResult<SeckillExecution>(false,seckillExceution);
        }catch (Exception e) {
            SeckillExecution seckillExceution = new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS.INSERT_ERROR);
            return new SeckillResult<SeckillExecution>(false, seckillExceution);
        }
    }

    @RequestMapping(value="/time/now",method = RequestMethod.GET)
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult<Long>(true,now.getTime());
    }

}

