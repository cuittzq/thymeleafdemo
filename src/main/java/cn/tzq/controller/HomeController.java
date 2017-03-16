package cn.tzq.controller;

import cn.tzq.model.DeptVo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Detail;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/16.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("message", LocalDateTime.now() + " Hello!");
        return "index";
    }

//    @RequestMapping(value = "/getDeptInfo/page",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @GetMapping("/getDeptInfo/page")
    public String postForm(Integer pageNumber, Integer pageSize, Model model) {
        List<DeptVo> deptVoList = new ArrayList<>();
        DeptVo deptInfo = null;
        for (int i = 0; i < 10; i++) {
            deptInfo = new DeptVo();
            deptInfo.setName("测试部门");
            deptInfo.setId(i);
            deptVoList.add(deptInfo);
        }
        model.addAttribute("deptInfos", deptVoList);
        return "deptmgr";
    }
}
