package cn.tzq.integration.impl;

import cn.tzq.integration.DeptIntegration;
import cn.tzq.model.DeptVo;
import cn.tzq.util.HttpUtil;
import cn.tzq.util.JsonUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/17.
 */
@Service("deptIntegration")
public class DeptIntegrationImpl implements DeptIntegration {

    /**
     * 域名
     */
    final String domain = "http://localhost:8080/Dept/";

    /**
     * 分页获取部门信息
     *
     * @param pageNumber 当前页
     * @param pageSize   页大小
     * @return 部门信息
     */
    public List<DeptVo> getDeptInfobypage(Integer pageNumber, Integer pageSize) {
        String actionurl = String.format("getdeptInfo/page?pageNumber=%d&pageSize=%d", pageNumber, pageSize);
        List<DeptVo> deptVos = null;
        try {
            String response = HttpUtil.get(String.format("%s/%s", domain, actionurl));
            deptVos = JsonUtil.jsonToList(response, DeptVo.class);
        } catch (Exception ex) {
            // 反序列化失败。记录日志
            ex.printStackTrace();
        }

        return deptVos;
    }

    /**
     * 获取所有部门信息
     *
     * @return 部门信息
     */
    public List<DeptVo> getDeptInfoall() {
        String actionurl = String.format("getdeptInfo/all");
        List<DeptVo> deptVos = null;
        try {
            String response = HttpUtil.get(String.format("%s/%s", domain, actionurl));
            deptVos = JsonUtil.jsonToList(response, DeptVo.class);
        } catch (Exception ex) {
            // 反序列化失败。记录日志
            ex.printStackTrace();
        }

        return deptVos;
    }

    /**
     * 获取指定部门信息
     *
     * @param deptid 部门ID
     * @return 部门信息
     */
    public DeptVo getDeptInfoByID(Integer deptid) {
        String actionurl = String.format("getdeptInfo/%d", deptid);
        DeptVo deptVo = null;
        try {
            String response = HttpUtil.get(String.format("%s/%s", domain, actionurl));
            deptVo = new Gson().fromJson(response, DeptVo.class);
        } catch (Exception ex) {
            // 反序列化失败。记录日志
            ex.printStackTrace();
        }
        return deptVo;
    }

    public boolean deleteDept(DeptVo dept) {
        String actionurl = String.format("deleteDept");
        boolean isdeleted = false;
        try {
            String response = HttpUtil.post(String.format("%s/%s", domain, actionurl), new Gson().toJson(dept));
            isdeleted = response == "true";
        } catch (Exception ex) {
            // 反序列化失败。记录日志
            ex.printStackTrace();
        }

        return isdeleted;
    }
}
