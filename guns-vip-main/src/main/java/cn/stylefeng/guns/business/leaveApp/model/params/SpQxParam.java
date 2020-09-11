package cn.stylefeng.guns.business.leaveApp.model.params;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import lombok.Data;

import java.io.Serializable;

/**
 * spQxParam类
 * Git to： http://club.hsspace.com:3000/Qing_ning/HSLeaveSystem/
 *
 * @TIME 2020/9/11 14:15
 * @AUTHOR 韩硕~
 */

@Data
public class SpQxParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;

    private Long appId;

    private Long deptId;

    @Override
    public String checkParam() {
        return null;
    }

}
