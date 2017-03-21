package cn.tzq.facade.impl;

import cn.tzq.facade.DeptDubboConsumerService;
import cn.tzq.facade.DeptDubboService;
import cn.tzq.model.DeptVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/20.
 */
@Service("deptDubboConsumerService")
public class DeptDubboConsumerServiceImpl implements DeptDubboConsumerService {

    @Reference(version = "1.0.0")
    DeptDubboService deptDubboService;

    /**
     * @param dept 部门信息
     * @return
     */
    @Override
    public String saveDept(DeptVo dept) {
        return deptDubboService.saveDept(dept);
    }

    /**
     * @param dept 部门信息
     * @return
     */
    @Override
    public boolean deleteDept(DeptVo dept) {
        return deptDubboService.deleteDept(dept);
    }

    /**
     * @param id 部门ID
     * @return
     */
    @Override
    public DeptVo getdeptInfo(Integer id) {
        return deptDubboService.getDeptInfo(id);
    }

    /**
     * 分页获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<DeptVo> getdeptInfoByPage(Integer pageNumber, Integer pageSize) {
        return deptDubboService.getDeptInfoByPage(pageNumber, pageSize);
    }

    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize) {
        return deptDubboService.findMaxDept(pageNumber, pageSize);
    }

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    @Override
    public List<DeptVo> getDpetAll() {
        return deptDubboService.getDpetAll();
    }
}
