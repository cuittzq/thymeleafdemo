package cn.tzq.integration;

import cn.tzq.model.DeptVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/17.
 * dept信息整合类
 */
public interface DeptIntegration {


    /**
     * 分页获取部门信息
     *
     * @param pageNumber 当前页
     * @param pageSize   页大小
     * @return 部门信息
     */
    PageInfo<DeptVo> getDeptInfobypage(Integer pageNumber, Integer pageSize);

    /**
     * 获取所有部门信息
     *
     * @return 部门信息
     */
    List<DeptVo> getDeptInfoall();

    /**
     * 获取指定部门信息
     *
     * @param deptid 部门ID
     * @return 部门信息
     */
    DeptVo getDeptInfoByID(Integer deptid);

    boolean deleteDept(DeptVo dept);
}
