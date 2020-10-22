package cn.stylefeng.guns.business.information.mapper;

import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.model.result.InformationResult;
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
 * @since 2020-09-30
 */
public interface InformationMapper extends BaseMapper<Information> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    List<InformationResult> customList(@Param("paramCondition") InformationParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") InformationParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    Page<InformationResult> customPageList(@Param("page") Page page, @Param("paramCondition") InformationParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") InformationParam paramCondition);

}
