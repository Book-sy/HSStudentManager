package cn.stylefeng.guns.business.score.mapper;

import cn.stylefeng.guns.business.score.entity.ScoreEvaluate;
import cn.stylefeng.guns.business.score.model.params.ScoreEvaluateParam;
import cn.stylefeng.guns.business.score.model.result.ScoreEvaluateResult;
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
public interface ScoreEvaluateMapper extends BaseMapper<ScoreEvaluate> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreEvaluateResult> customList(@Param("paramCondition") ScoreEvaluateParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ScoreEvaluateParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<ScoreEvaluateResult> customPageList(@Param("page") Page page, @Param("paramCondition") ScoreEvaluateParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ScoreEvaluateParam paramCondition);

}
