package cn.stylefeng.guns.business.information.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.model.result.InformationResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-30
 */
public interface InformationService extends IService<Information> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    void add(InformationParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    void delete(InformationParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    void update(InformationParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    InformationResult findBySpec(InformationParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    List<InformationResult> findListBySpec(InformationParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
     LayuiPageInfo findPageBySpec(InformationParam param);

}
