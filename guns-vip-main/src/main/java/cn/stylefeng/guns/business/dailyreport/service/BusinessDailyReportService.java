package cn.stylefeng.guns.business.dailyreport.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.dailyreport.entity.BusinessDailyReport;
import cn.stylefeng.guns.business.dailyreport.model.params.BusinessDailyReportParam;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
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
public interface BusinessDailyReportService extends IService<BusinessDailyReport> {

    /**
     * 新增
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void add(BusinessDailyReportParam param);

    /**
     * 删除
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void delete(BusinessDailyReportParam param);

    /**
     * 更新
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    void update(BusinessDailyReportParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    BusinessDailyReportResult findBySpec(BusinessDailyReportParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<BusinessDailyReportResult> findListBySpec(BusinessDailyReportParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
     LayuiPageInfo findPageBySpec(BusinessDailyReportParam param);
     LayuiPageInfo findAllPageBySpec(BusinessDailyReportParam param);

}
