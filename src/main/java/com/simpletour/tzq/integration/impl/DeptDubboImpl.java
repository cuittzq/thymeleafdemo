package com.simpletour.tzq.integration.impl;

import cn.tzq.facade.DeptInfoService;
import cn.tzq.model.DeptVo;
import com.github.pagehelper.PageInfo;
import com.simpletour.tzq.integration.DeptIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/21.
 */
@Service("deptIntegration")
public class DeptDubboImpl implements DeptIntegration {

    /**
     * DeptInfoService
     */
    private DeptInfoService deptInfoService;

    /**
     * 构造函数
     *
     * @param deptInfoService
     */
    @Autowired
    public DeptDubboImpl(DeptInfoService deptInfoService) {
        this.deptInfoService = deptInfoService;
    }

    /**
     * 分页获取部门信息
     *
     * @param pageNumber 当前页
     * @param pageSize   页大小
     * @return 部门信息
     */
    @Override
    public PageInfo<DeptVo> getDeptInfobypage(Integer pageNumber, Integer pageSize) {

        return this.deptInfoService.getDeptInfoByPage(pageNumber, pageSize);
    }

    /**
     * 获取所有部门信息
     *
     * @return 部门信息
     */
    @Override
    public List<DeptVo> getDeptInfoall() {
        return this.deptInfoService.getDpetAll();
    }

    /**
     * 获取指定部门信息
     *
     * @param deptid 部门ID
     * @return 部门信息
     */
    @Override
    public DeptVo getDeptInfoByID(Integer deptid) {
        return this.deptInfoService.getDeptInfo(deptid);
    }

    /**
     * @param dept
     * @return
     */
    @Override
    public boolean deleteDept(DeptVo dept) {
        this.deptInfoService.deleteDept(dept);
        return true;
    }
}
