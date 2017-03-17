package cn.tzq.model;

import java.io.Serializable;

/**
 * Created by zhiqiang on 2017/3/16.
 */
public class DeptVo implements Serializable {

    private static final long serialVersionUID = -8459755922288527580L;

    /**
     * 部门编号
     */
    Integer id;

    /**
     * 部门名称
     */
    String name;

    /**
     * 部门描述
     */
    String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
