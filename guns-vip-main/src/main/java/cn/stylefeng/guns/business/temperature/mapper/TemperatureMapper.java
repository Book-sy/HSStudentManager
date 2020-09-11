package cn.stylefeng.guns.business.temperature.mapper;

import cn.stylefeng.guns.business.temperature.entity.Temperature;
import cn.stylefeng.guns.business.temperature.model.params.TemperatureParam;
import cn.stylefeng.guns.business.temperature.model.result.TemperatureResult;
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
 * @since 2020-09-01
 */
public interface TemperatureMapper extends BaseMapper<Temperature> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    List<TemperatureResult> customList(@Param("paramCondition") TemperatureParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") TemperatureParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    Page<TemperatureResult> customPageList(@Param("page") Page page, @Param("paramCondition") TemperatureParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") TemperatureParam paramCondition);

}
