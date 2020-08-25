package cn.stylefeng.guns.business.dailyreport.mapper;

import cn.stylefeng.guns.business.dailyreport.entity.BusinessDailyReport;
import cn.stylefeng.guns.business.dailyreport.model.params.BusinessDailyReportParam;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
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
 * @since 2020-08-01
 */
public interface BusinessDailyReportMapper extends BaseMapper<BusinessDailyReport> {

    /**
     * 获取列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<BusinessDailyReportResult> customList(@Param("paramCondition") BusinessDailyReportParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BusinessDailyReportParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    Page<BusinessDailyReportResult> customPageList(@Param("page") Page page, @Param("paramCondition") BusinessDailyReportParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BusinessDailyReportParam paramCondition);

}
