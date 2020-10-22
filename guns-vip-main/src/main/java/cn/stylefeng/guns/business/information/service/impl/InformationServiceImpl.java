package cn.stylefeng.guns.business.information.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.mapper.InformationMapper;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.model.result.InformationResult;
import  cn.stylefeng.guns.business.information.service.InformationService;
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
 * @since 2020-09-30
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {

    @Override
    public void add(InformationParam param){
        Information entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(InformationParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(InformationParam param){
        Information oldEntity = getOldEntity(param);
        Information newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public InformationResult findBySpec(InformationParam param){
        return null;
    }

    @Override
    public List<InformationResult> findListBySpec(InformationParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(InformationParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(InformationParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Information getOldEntity(InformationParam param) {
        return this.getById(getKey(param));
    }

    private Information getEntity(InformationParam param) {
        Information entity = new Information();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
