package com.linktech.portal.count.controller;

import com.linktech.mybatis.model.BeAuthStatistics;
import com.linktech.mybatis.model.BeEnterprise;
import com.linktech.portal.count.model.CountEntity;
import com.linktech.portal.count.service.AuthStatisticsService;
import com.linktech.portal.count.service.EnterpriseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.common.DTO;
import project.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Scope("prototype")
@RequestMapping("/count")
public class AuthStatisticsController {

    private Logger log = Logger.getLogger(AuthStatisticsController.class);

    @Autowired
    protected AuthStatisticsService authStatisticsService;
    @Autowired
    protected EnterpriseService enterpriseService;

    /**
     * 场所数据量统计
     */
    @RequestMapping("/enterprise")
    public DTO enterprise(HttpServletRequest req) {
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        Integer pagination = ServletRequestUtils.getIntParameter(req, "pagination", 1);
        String startTime = "";
        String endTime = "";
        if (day != null && !day.equals("") && !day.equals("0")) {
            startTime = year + "-" + month + "-" + day;
            endTime = year + "-" + month + "-" + day;
        } else if (month != null && !month.equals("") && !month.equals("0")) {
            startTime = year + "-" + month + "-" + "01";
            endTime = DateUtil.getLastDay(Integer.valueOf(year), Integer.valueOf(month));
        } else {
            startTime = year + "-" + "01" + "-" + "01";
            endTime = year + "-" + "12" + "-" + "31";
        }
        DTO dto = new DTO();
        log.info("startTime=" + startTime + "  endTime=" + endTime + "  pagination=" + pagination + "  ");
        try {
            List<BeAuthStatistics> list = authStatisticsService.findForEnterprise(startTime, endTime, pagination, 10);
            System.out.println(list);
            if (list == null || list.size() == 0) {
                dto.setMsg("没有数据");
            }
            dto.setDataRows(list);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatus("error");
        }
        return dto;
    }

    /**
     * 昨日关键数据统计
     */
    @RequestMapping("/yesterday")
    public DTO yesterday() {
        Calendar now = Calendar.getInstance();
//		String today = date2str(now.getTime(), "yyyy-MM-dd");//今天
        String yesterday = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -1), "yyyy-MM-dd");//昨天
        String yesterday_1 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -2), "yyyy-MM-dd");//前天
        String yesterday_7 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -7), "yyyy-MM-dd");//上星期
        String yesterday_8 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -8), "yyyy-MM-dd");//大上星期结束
        String yesterday_14 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -14), "yyyy-MM-dd");//大上星期开始
        String yesterday_30 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -30), "yyyy-MM-dd");//上个月
        String yesterday_31 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -31), "yyyy-MM-dd");//大上个月结束
        String yesterday_60 = DateUtil.date2str(DateUtil.dateOperation(now.getTime(), -60), "yyyy-MM-dd");//大上个月开始

        System.out.println(yesterday);
        System.out.println(yesterday_1);
        System.out.println(yesterday_7);
        System.out.println(yesterday_8);
        System.out.println(yesterday_14);
        System.out.println(yesterday_30);
        System.out.println(yesterday_31);
        System.out.println(yesterday_60);

        DTO dto = new DTO();
//		log.info("startTime="+startTime+"  endTime="+endTime+"  pagination="+pagination+"  ");
        try {
            BeAuthStatistics yesterdayData = authStatisticsService.findForDate(yesterday, yesterday);//昨天数据
            BeAuthStatistics yesterday_1Data = authStatisticsService.findForDate(yesterday_1, yesterday_1);//前台数据
            BeAuthStatistics yesterday_7Data = authStatisticsService.findForDate(yesterday_7, yesterday);//上星期数据
            BeAuthStatistics yesterday_14Data = authStatisticsService.findForDate(yesterday_14, yesterday_8);//大上星期数据
            BeAuthStatistics yesterday_30Data = authStatisticsService.findForDate(yesterday_30, yesterday);//上个月
            BeAuthStatistics yesterday_60Data = authStatisticsService.findForDate(yesterday_60, yesterday_31);//大上个月
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            Map<String, String> auth = new HashMap<String, String>();
            auth.put("title", "Portal认证数");
            auth.put("sum", yesterdayData.getAuthSum() + "");
            if (yesterday_1Data.getAuthSum() == null || yesterday_1Data.getAuthSum() == 0) {
                auth.put("day", "-");
            } else {
                auth.put("day", (yesterdayData.getAuthSum() - yesterday_1Data.getAuthSum()) / (yesterday_1Data.getAuthSum().doubleValue()) + "");
            }
            if (yesterday_14Data.getAuthSum() == null || yesterday_14Data.getAuthSum() == 0) {
                auth.put("week", "-");
            } else {
                auth.put("week", (yesterday_7Data.getAuthSum() - yesterday_14Data.getAuthSum()) / (yesterday_14Data.getAuthSum().doubleValue()) + "");
            }
            if (yesterday_60Data.getAuthSum() == null || yesterday_60Data.getAuthSum() == 0) {
                auth.put("month", "-");
            } else {
                auth.put("month", (yesterday_30Data.getAuthSum() - yesterday_60Data.getAuthSum()) / (yesterday_60Data.getAuthSum().doubleValue()) + "");
            }

            Map<String, String> show = new HashMap<String, String>();
            show.put("title", "广告展示量");
            show.put("sum", yesterdayData.getShowSum() + "");
            if (yesterday_1Data.getShowSum() == null || yesterday_1Data.getShowSum() == 0) {
                show.put("day", "-");
            } else {
                show.put("day", (yesterdayData.getShowSum() - yesterday_1Data.getShowSum()) / (yesterday_1Data.getShowSum().doubleValue()) + "");
            }
            if (yesterday_14Data.getShowSum() == null || yesterday_14Data.getShowSum() == 0) {
                show.put("week", "-");
            } else {
                show.put("week", (yesterday_7Data.getShowSum() - yesterday_14Data.getShowSum()) / (yesterday_14Data.getShowSum().doubleValue()) + "");
            }
            if (yesterday_60Data.getShowSum() == null || yesterday_60Data.getShowSum() == 0) {
                show.put("month", "-");
            } else {
                show.put("month", (yesterday_30Data.getShowSum() - yesterday_60Data.getShowSum()) / (yesterday_60Data.getShowSum().doubleValue()) + "");
            }

            Map<String, String> click = new HashMap<String, String>();
            click.put("title", "广告点击量");
            click.put("sum", yesterdayData.getClickSum() + "");
            if (yesterday_1Data.getClickSum() == null || yesterday_1Data.getClickSum() == 0) {
                click.put("day", "-");
            } else {
                click.put("day", (yesterdayData.getClickSum() - yesterday_1Data.getClickSum()) / (yesterday_1Data.getClickSum().doubleValue()) + "");
            }
            if (yesterday_14Data.getClickSum() == null || yesterday_14Data.getClickSum() == 0) {
                click.put("week", "-");
            } else {
                click.put("week", (yesterday_7Data.getClickSum() - yesterday_14Data.getClickSum()) / (yesterday_14Data.getClickSum().doubleValue()) + "");
            }
            if (yesterday_60Data.getClickSum() == null || yesterday_60Data.getClickSum() == 0) {
                click.put("month", "-");
            } else {
                click.put("month", (yesterday_30Data.getClickSum() - yesterday_60Data.getClickSum()) / (yesterday_60Data.getClickSum().doubleValue()) + "");
            }

            list.add(auth);
            list.add(show);
            list.add(click);
            dto.setDataRows(list);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatus("error");
        }
        return dto;
    }

    /**
     * 用户数据量统计

     @RequestMapping("/user") public DTO user(HttpServletRequest req) {
     String unit = req.getParameter("unit");
     String startTime = req.getParameter("startTime");
     String endTime = req.getParameter("endTime");
     DTO dto = new DTO();
     if(startTime==null||startTime.equals("")||endTime==null||endTime.equals("")){
     dto.setStatus(DTO.ERROR);
     dto.setMsg("时间不可以为空");
     return dto;
     }
     try {
     List<Map<String,Object>> retu = new ArrayList<Map<String,Object>>();
     if("1".equals(unit)){//日
     List<BeAuthStatistics> list = authStatisticsService.findForDay(startTime, endTime);
     if(list!=null){
     for (BeAuthStatistics authStatistics : list) {
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("title", DateUtil.date2str(authStatistics.getCountDate(), "yyyy-MM-dd"));
     map.put("authSum", authStatistics.getAuthSum());
     map.put("showSum", authStatistics.getShowSum());
     map.put("clickSum", authStatistics.getClickSum());
     retu.add(map);
     }
     }
     }else if("2".equals(unit)){//月
     startTime = startTime.substring(0, 8) + "01";
     endTime = DateUtil.getLastDay(Integer.valueOf(endTime.split("-")[0]), Integer.valueOf(endTime.split("-")[1]));
     List<CountEntity> list = authStatisticsService.findForMonth(startTime, endTime);
     for (CountEntity count : list) {
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("title", count.getMonth());
     map.put("authSum", count.getAuthSum());
     map.put("showSum", count.getShowSum());
     map.put("clickSum", count.getClickSum());
     retu.add(map);
     }
     }else if("4".equals(unit)){//周
     startTime = DateUtil.date2str(DateUtil.getFirstDayOfWeek(Integer.valueOf(startTime.split("-")[0]), DateUtil.getWeekOfYear(startTime, "yyyy-MM-dd")), "yyyy-MM-dd");
     endTime = DateUtil.date2str(DateUtil.getLastDayOfWeek(Integer.valueOf(endTime.split("-")[0]), DateUtil.getWeekOfYear(endTime, "yyyy-MM-dd")), "yyyy-MM-dd");
     List<CountEntity> list = authStatisticsService.findForWeek(startTime, endTime);
     if(list!=null){
     for (CountEntity count : list) {
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("title", count.getYear()+"年 第"+count.getWeek()+"周");
     map.put("authSum", count.getAuthSum());
     map.put("showSum", count.getShowSum());
     map.put("clickSum", count.getClickSum());
     retu.add(map);
     }
     }
     }else{//年
     startTime = startTime.substring(0, 4) + "-01-01";
     endTime = endTime.substring(0, 4) + "-12-31";
     List<CountEntity> list = authStatisticsService.findForYear(startTime, endTime);
     if(list!=null){
     for (CountEntity count : list) {
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("title", count.getYear());
     map.put("authSum", count.getAuthSum());
     map.put("showSum", count.getShowSum());
     map.put("clickSum", count.getClickSum());
     retu.add(map);
     }
     }
     }
     System.out.println("startTime="+startTime);
     System.out.println("endTime="+endTime);
     dto.setDataRows(retu);
     } catch (Exception e) {
     e.printStackTrace();
     dto.setStatus("error");
     }
     //		log.info("startTime="+startTime+"  endTime="+endTime+"  pagination="+pagination+"  ");
     return dto;
     }
     */


    /**
     * 用户数据量统计
     */
    @RequestMapping("/getEnterpriseAll")
    public DTO getEnterpriseAll() {
        DTO dto = new DTO();
        try {
            List<BeEnterprise> list = enterpriseService.findAll();
            dto.setDataRows(list);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setMsg("查询异常");
            dto.setStatus("error");
        }
        return dto;
    }

    /**
     * 用户数据量统计
     */
    @RequestMapping("/user")
    public DTO user(String unit, String startTime, String endTime, Integer enterpriseId) {
        DTO dto = new DTO();
        if (startTime == null || startTime.equals("") || endTime == null || endTime.equals("")) {
            dto.setStatus(DTO.ERROR);
            dto.setMsg("时间不可以为空");
            return dto;
        }
        try {
            List<CountEntity> list = null;
            if ("1".equals(unit)) {//日
                list = authStatisticsService.findForEnterpriseTime(enterpriseId, startTime, endTime, "%Y-%m-%d");
            } else if ("2".equals(unit)) {//月
                startTime = startTime.substring(0, 8) + "01";
                endTime = DateUtil.getLastDay(Integer.valueOf(endTime.split("-")[0]), Integer.valueOf(endTime.split("-")[1]));
                list = authStatisticsService.findForEnterpriseTime(enterpriseId, startTime, endTime, "%Y-%m");
            } else {//年
                startTime = startTime.substring(0, 4) + "-01-01";
                endTime = endTime.substring(0, 4) + "-12-31";
                list = authStatisticsService.findForEnterpriseTime(enterpriseId, startTime, endTime, "%Y");
            }
            System.out.println("startTime=" + startTime);
            System.out.println("endTime=" + endTime);
            if (list == null || list.size() == 0) {
                dto.setMsg("暂无数据");
            }
            dto.setDataRows(list);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setMsg("查询异常");
            dto.setStatus("error");
        }
//		log.info("startTime="+startTime+"  endTime="+endTime+"  pagination="+pagination+"  ");
        return dto;
    }

}
