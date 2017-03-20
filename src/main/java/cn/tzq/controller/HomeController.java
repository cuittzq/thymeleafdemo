package cn.tzq.controller;

import cn.tzq.integration.DeptIntegration;
import cn.tzq.integration.DeptDubboConsumerService;
import cn.tzq.integration.impl.DeptDubboConsumerServiceImpl;
import cn.tzq.integration.impl.DeptIntegrationImpl;
import cn.tzq.model.DeptVo;
import cn.tzq.model.BaseRespones;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/16.
 */
@Controller
public class HomeController {


    private DeptIntegration deptIntegration;

    /**
     *
     */
    private DeptDubboConsumerService deptDubboConsumerService;

    @Autowired
    public HomeController(DeptIntegrationImpl deptIntegration, DeptDubboConsumerServiceImpl deptDubboConsumerService) {
        this.deptIntegration = deptIntegration;
        this.deptDubboConsumerService = deptDubboConsumerService;
    }

    @GetMapping("/")
    String index(Model model) {
        // List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
        List<DeptVo> deptVoList = this.deptDubboConsumerService.getDpetAll();
        model.addAttribute("deptInfos", deptVoList);
        model.addAttribute("message", LocalDateTime.now() + " Hello!");
        return "index";
    }

    /**
     * @param pageNumber
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/getDeptInfo/page")
    public String getDeptInfoByPage(Integer pageNumber, Integer pageSize, Model model) {
        //PageInfo<DeptVo> deptVoList = this.deptIntegration.getDeptInfobypage(pageNumber, pageSize);
        PageInfo<DeptVo> deptVoList = this.deptDubboConsumerService.getdeptInfoByPage(pageNumber, pageSize);
        //获得当前页
        model.addAttribute("pageNum", deptVoList.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", deptVoList.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", deptVoList.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", deptVoList.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", deptVoList.isIsLastPage());

        model.addAttribute("deptInfos", deptVoList.getList());
        return "index";
    }

    @GetMapping("/getDeptInfo/{id}")
    @ResponseBody
    public String getDeptInfoByID(@PathVariable Integer id, Model model) {
        // DeptVo deptVo = this.deptIntegration.getDeptInfoByID(id);
        DeptVo deptVo = this.deptDubboConsumerService.getdeptInfo(id);
        BaseRespones<DeptVo> deptRespones = new BaseRespones(deptVo);
        String resultstr = new Gson().toJson(deptRespones);
        return resultstr;
    }

    @GetMapping("/getDeptInfo/all")
    @ResponseBody
    public String getDeptInfoAll(Model model) {
        //  List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
        List<DeptVo> deptVoList = this.deptDubboConsumerService.getDpetAll();
        BaseRespones<List<DeptVo>> deptRespones = new BaseRespones(deptVoList);
        String resultstr = new Gson().toJson(deptRespones);
        return resultstr;
    }

    @GetMapping("/getDeptInfo/all1")
    @ResponseBody
    public List<DeptVo> getDeptInfoAll1(Model model) {
        //   List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
        List<DeptVo> deptVoList = this.deptDubboConsumerService.getDpetAll();
        return deptVoList;
    }

    @PostMapping("/deleteDept")
    @ResponseBody
    public boolean deleteDept(@RequestBody DeptVo deptVo) {
        //  this.deptIntegration.deleteDept(deptVo);
        this.deptDubboConsumerService.deleteDept(deptVo);
        return true;
    }
}
