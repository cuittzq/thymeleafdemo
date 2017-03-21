package cn.tzq.facade;

import cn.tzq.model.DeptVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/21.
 */
@Service("deptInfoService")
public class DeptInfoService {

    /**
     * Dubbo服务接口
     */
    @Reference(version = "1.0.0")
    DeptDubboService deptDubboService;

    /**
     * 根据部门ID获取部门信息
     *
     * @param id 部门ID
     * @return
     */
    public DeptVo getDeptInfo(Integer id) {
        DeptVo city = deptDubboService.getDeptInfo(id);
        return city;
    }

    /**
     * @param dept 部门信息
     * @return
     */
    public Boolean saveDept(DeptVo dept) {
        return deptDubboService.saveDept(dept);
    }

    /**
     * @param dept 部门信息
     * @return
     */
    public void deleteDept(DeptVo dept) {
        deptDubboService.deleteDept(dept);
    }


    /**
     * 分页获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageInfo<DeptVo> getDeptInfoByPage(Integer pageNumber, Integer pageSize) {
        return deptDubboService.getDeptInfoByPage(pageNumber, pageSize);
    }

    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize) {
        return deptDubboService.findMaxDept(pageNumber, pageSize);
    }

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    public List<DeptVo> getDpetAll() {
        return deptDubboService.getDpetAll();
    }
}
