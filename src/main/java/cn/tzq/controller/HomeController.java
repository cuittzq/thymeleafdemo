package cn.tzq.controller;

import cn.tzq.integration.DeptIntegration;
import cn.tzq.integration.impl.DeptIntegrationImpl;
import cn.tzq.model.DeptVo;
import cn.tzq.model.BaseRespones;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Autowired
    public HomeController(DeptIntegrationImpl deptIntegration) {
        this.deptIntegration = deptIntegration;
    }

    @GetMapping("/")
    String index(Model model) {
        List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
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
        List<DeptVo> deptVoList = this.deptIntegration.getDeptInfobypage(pageNumber, pageSize);
        model.addAttribute("deptInfos", deptVoList);
        return "deptinfo";
    }

    @GetMapping("/getDeptInfo/{id}")
    @ResponseBody
    public String getDeptInfoByID(@PathVariable Integer id, Model model) {
        DeptVo deptVo = this.deptIntegration.getDeptInfoByID(id);
        BaseRespones<DeptVo> deptRespones = new BaseRespones(deptVo);
        String resultstr = new Gson().toJson(deptRespones);
        return resultstr;
    }

    @GetMapping("/getDeptInfo/all")
    @ResponseBody
    public String getDeptInfoAll(Model model) {
        List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
        BaseRespones<List<DeptVo>> deptRespones = new BaseRespones(deptVoList);
        String resultstr = new Gson().toJson(deptRespones);
        return resultstr;
    }

    @GetMapping("/getDeptInfo/all1")
    @ResponseBody
    public List<DeptVo> getDeptInfoAll1(Model model) {
        List<DeptVo> deptVoList = this.deptIntegration.getDeptInfoall();
        return deptVoList;
    }

    @PostMapping("/deleteDept")
    @ResponseBody
    public boolean deleteDept(@RequestBody DeptVo deptVo) {
        this.deptIntegration.deleteDept(deptVo);
        return true;
    }
}
