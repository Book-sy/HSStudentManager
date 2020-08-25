package cn.stylefeng.guns.business.dailyreport.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.dailyreport.entity.BusinessDailyReport;
import cn.stylefeng.guns.business.dailyreport.mapper.BusinessDailyReportMapper;
import cn.stylefeng.guns.business.dailyreport.model.params.BusinessDailyReportParam;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
import  cn.stylefeng.guns.business.dailyreport.service.BusinessDailyReportService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 韩硕
 * @since 2020-08-01
 */
@Service
public class BusinessDailyReportServiceImpl extends ServiceImpl<BusinessDailyReportMapper, BusinessDailyReport> implements BusinessDailyReportService {

    @Override
    public void add(BusinessDailyReportParam param){
        BusinessDailyReport entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BusinessDailyReportParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BusinessDailyReportParam param){
        BusinessDailyReport oldEntity = getOldEntity(param);
        BusinessDailyReport newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BusinessDailyReportResult findBySpec(BusinessDailyReportParam param){
        return null;
    }

    @Override
    public List<BusinessDailyReportResult> findListBySpec(BusinessDailyReportParam param){
        return baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(BusinessDailyReportParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public LayuiPageInfo findAllPageBySpec(BusinessDailyReportParam param){
        Page pageContext = getPageContext();
        pageContext.setSize(Long.MAX_VALUE);
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BusinessDailyReportParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private BusinessDailyReport getOldEntity(BusinessDailyReportParam param) {
        return this.getById(getKey(param));
    }

    private BusinessDailyReport getEntity(BusinessDailyReportParam param) {
        BusinessDailyReport entity = new BusinessDailyReport();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
