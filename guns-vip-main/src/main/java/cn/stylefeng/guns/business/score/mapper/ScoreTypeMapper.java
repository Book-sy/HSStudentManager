package cn.stylefeng.guns.business.score.mapper;

import cn.stylefeng.guns.business.score.entity.ScoreType;
import cn.stylefeng.guns.business.score.model.params.ScoreTypeParam;
import cn.stylefeng.guns.business.score.model.result.ScoreTypeResult;
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
 * @since 2020-09-27
 */
public interface ScoreTypeMapper extends BaseMapper<ScoreType> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreTypeResult> customList(@Param("paramCondition") ScoreTypeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ScoreTypeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<ScoreTypeResult> customPageList(@Param("page") Page page, @Param("paramCondition") ScoreTypeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ScoreTypeParam paramCondition);

}
