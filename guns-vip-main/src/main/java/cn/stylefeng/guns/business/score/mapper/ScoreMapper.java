package cn.stylefeng.guns.business.score.mapper;

import cn.stylefeng.guns.business.score.entity.Score;
import cn.stylefeng.guns.business.score.model.params.ScoreParam;
import cn.stylefeng.guns.business.score.model.result.ScoreResult;
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
public interface ScoreMapper extends BaseMapper<Score> {


    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void eveplus(@Param("appId") Long id);

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreResult> customList(@Param("paramCondition") ScoreParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ScoreParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<ScoreResult> customPageList(@Param("page") Page page, @Param("paramCondition") ScoreParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ScoreParam paramCondition);

}
