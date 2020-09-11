package cn.stylefeng.guns.business.temperature.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.temperature.entity.Temperature;
import cn.stylefeng.guns.business.temperature.model.params.TemperatureParam;
import cn.stylefeng.guns.business.temperature.model.result.TemperatureResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-01
 */
public interface TemperatureService extends IService<Temperature> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    void add(TemperatureParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    void delete(TemperatureParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    void update(TemperatureParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    TemperatureResult findBySpec(TemperatureParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    List<TemperatureResult> findListBySpec(TemperatureParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
     LayuiPageInfo findPageBySpec(TemperatureParam param);

}
