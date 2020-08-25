package cn.stylefeng.guns.business.outapplication.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.outapplication.entity.BusinessOutApplication;
import cn.stylefeng.guns.business.outapplication.mapper.BusinessOutApplicationMapper;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.outapplication.model.result.BusinessOutApplicationResult;
import  cn.stylefeng.guns.business.outapplication.service.BusinessOutApplicationService;
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
public class BusinessOutApplicationServiceImpl extends ServiceImpl<BusinessOutApplicationMapper, BusinessOutApplication> implements BusinessOutApplicationService {

    @Override
    public void add(BusinessOutApplicationParam param){
        BusinessOutApplication entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BusinessOutApplicationParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BusinessOutApplicationParam param){
        BusinessOutApplication oldEntity = getOldEntity(param);
        BusinessOutApplication newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BusinessOutApplicationResult findBySpec(BusinessOutApplicationParam param){
        return null;
    }

    @Override
    public List<BusinessOutApplicationResult> findListBySpec(BusinessOutApplicationParam param){
        return baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(BusinessOutApplicationParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BusinessOutApplicationParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private BusinessOutApplication getOldEntity(BusinessOutApplicationParam param) {
        return this.getById(getKey(param));
    }

    private BusinessOutApplication getEntity(BusinessOutApplicationParam param) {
        BusinessOutApplication entity = new BusinessOutApplication();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
