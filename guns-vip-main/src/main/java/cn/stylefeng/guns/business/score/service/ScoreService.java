package cn.stylefeng.guns.business.score.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.Score;
import cn.stylefeng.guns.business.score.model.params.ScoreParam;
import cn.stylefeng.guns.business.score.model.result.ScoreResult;
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
public interface ScoreService extends IService<Score> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void add(ScoreParam param);

    /**
     * eve+1
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void eveplus(Long id);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void delete(ScoreParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void update(ScoreParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    ScoreResult findBySpec(ScoreParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreResult> findListBySpec(ScoreParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
     LayuiPageInfo findPageBySpec(ScoreParam param);

}
