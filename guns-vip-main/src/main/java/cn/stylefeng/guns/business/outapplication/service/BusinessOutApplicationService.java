package cn.stylefeng.guns.business.outapplication.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.outapplication.entity.BusinessOutApplication;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.outapplication.model.result.BusinessOutApplicationResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 韩硕
 * @since 2020-08-01
 */
public interface BusinessOutApplicationService extends IService<BusinessOutApplication> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void add(BusinessOutApplicationParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void delete(BusinessOutApplicationParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void update(BusinessOutApplicationParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    BusinessOutApplicationResult findBySpec(BusinessOutApplicationParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<BusinessOutApplicationResult> findListBySpec(BusinessOutApplicationParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
     LayuiPageInfo findPageBySpec(BusinessOutApplicationParam param);

}
