package cn.stylefeng.guns.business.outapplication.mapper;

import cn.stylefeng.guns.business.outapplication.entity.BusinessOutApplication;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.outapplication.model.result.BusinessOutApplicationResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
 * @since 2020-08-01
 */
public interface BusinessOutApplicationMapper extends BaseMapper<BusinessOutApplication> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<BusinessOutApplicationResult> customList(@Param("paramCondition") BusinessOutApplicationParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BusinessOutApplicationParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    Page<BusinessOutApplicationResult> customPageList(@Param("page") Page page, @Param("paramCondition") BusinessOutApplicationParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BusinessOutApplicationParam paramCondition);

}
