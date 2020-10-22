package cn.stylefeng.guns.business.score.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.ScoreEvaluate;
import cn.stylefeng.guns.business.score.model.params.ScoreEvaluateParam;
import cn.stylefeng.guns.business.score.model.result.ScoreEvaluateResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-27
 */
public interface ScoreEvaluateService extends IService<ScoreEvaluate> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void add(ScoreEvaluateParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void delete(ScoreEvaluateParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void update(ScoreEvaluateParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    ScoreEvaluateResult findBySpec(ScoreEvaluateParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreEvaluateResult> findListBySpec(ScoreEvaluateParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
     LayuiPageInfo findPageBySpec(ScoreEvaluateParam param);

}
