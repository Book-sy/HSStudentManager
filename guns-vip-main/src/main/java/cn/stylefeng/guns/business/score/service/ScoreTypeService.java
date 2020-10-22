package cn.stylefeng.guns.business.score.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.ScoreType;
import cn.stylefeng.guns.business.score.model.params.ScoreTypeParam;
import cn.stylefeng.guns.business.score.model.result.ScoreTypeResult;
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
public interface ScoreTypeService extends IService<ScoreType> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void add(ScoreTypeParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void delete(ScoreTypeParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    void update(ScoreTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    ScoreTypeResult findBySpec(ScoreTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    List<ScoreTypeResult> findListBySpec(ScoreTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
     LayuiPageInfo findPageBySpec(ScoreTypeParam param);

}
