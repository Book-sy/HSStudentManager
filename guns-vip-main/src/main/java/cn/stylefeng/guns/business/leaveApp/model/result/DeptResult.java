package cn.stylefeng.guns.business.leaveApp.model.result;

import lombok.Data;

/**
 * deptResult类
 * Git to： http://club.hsspace.com:3000/Qing_ning/HSLeaveSystem/
 *
 * @TIME 2020/9/16 12:09
 * @AUTHOR 韩硕~
 */
@Data
public class DeptResult {

    private static final long serialVersionUID = 1L;

    private Long deptId;

    private String simpleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeptResult)) return false;
        DeptResult that = (DeptResult) o;
        if(that.deptId.equals(deptId))
            return true;
        return false;
    }
}
