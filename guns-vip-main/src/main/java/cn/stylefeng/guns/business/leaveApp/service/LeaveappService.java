package cn.stylefeng.guns.business.leaveApp.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.leaveApp.entity.Leaveapp;
import cn.stylefeng.guns.business.leaveApp.model.params.LeaveappParam;
import cn.stylefeng.guns.business.leaveApp.model.params.SpQxParam;
import cn.stylefeng.guns.business.leaveApp.model.result.LeaveappResult;
import cn.stylefeng.guns.business.leaveApp.model.result.SpQxResult;
import cn.stylefeng.guns.business.leaveApp.model.result.DeptResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-02
 */
public interface LeaveappService extends IService<Leaveapp> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    void add(LeaveappParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    void delete(LeaveappParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    void update(LeaveappParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    LeaveappResult findBySpec(LeaveappParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    List<LeaveappResult> findListBySpec(LeaveappParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
     LayuiPageInfo findPageBySpec(LeaveappParam param);

    SpQxResult lookSpQx(SpQxParam param);

    List<DeptResult> getDept(SpQxParam spQxParam);

    SpQxResult getCount();
}
