package cn.stylefeng.guns.business.leaveApp.mapper;

import cn.stylefeng.guns.business.leaveApp.entity.Leaveapp;
import cn.stylefeng.guns.business.leaveApp.model.params.LeaveappParam;
import cn.stylefeng.guns.business.leaveApp.model.params.SpQxParam;
import cn.stylefeng.guns.business.leaveApp.model.result.LeaveappResult;
import cn.stylefeng.guns.business.leaveApp.model.result.SpQxResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-02
 */
public interface LeaveappMapper extends BaseMapper<Leaveapp> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    List<LeaveappResult> customList(@Param("paramCondition") LeaveappParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") LeaveappParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    Page<LeaveappResult> customPageList(@Param("page") Page page, @Param("paramCondition") LeaveappParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    SpQxResult spQx(@Param("paramCondition") SpQxParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") LeaveappParam paramCondition);

}
