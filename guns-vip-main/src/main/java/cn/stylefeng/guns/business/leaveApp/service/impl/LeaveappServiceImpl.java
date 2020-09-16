package cn.stylefeng.guns.business.leaveApp.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.leaveApp.entity.Leaveapp;
import cn.stylefeng.guns.business.leaveApp.mapper.LeaveappMapper;
import cn.stylefeng.guns.business.leaveApp.model.params.LeaveappParam;
import cn.stylefeng.guns.business.leaveApp.model.params.SpQxParam;
import cn.stylefeng.guns.business.leaveApp.model.result.LeaveappResult;
import cn.stylefeng.guns.business.leaveApp.model.result.SpQxResult;
import  cn.stylefeng.guns.business.leaveApp.service.LeaveappService;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-02
 */
@Service
public class LeaveappServiceImpl extends ServiceImpl<LeaveappMapper, Leaveapp> implements LeaveappService {

    @Override
    public void add(LeaveappParam param){
        Leaveapp entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(LeaveappParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(LeaveappParam param){
        Leaveapp oldEntity = getOldEntity(param);
        Leaveapp newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public LeaveappResult findBySpec(LeaveappParam param){
        return null;
    }

    @Override
    public List<LeaveappResult> findListBySpec(LeaveappParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(LeaveappParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public SpQxResult lookSpQx(SpQxParam param){
        SpQxResult map = this.baseMapper.spQx(param);
        return map;
    }

    @Override
    public SpQxResult getCount(){
        SpQxResult map = this.baseMapper.getCount();
        return map;
    }

    private Serializable getKey(LeaveappParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Leaveapp getOldEntity(LeaveappParam param) {
        return this.getById(getKey(param));
    }

    private Leaveapp getEntity(LeaveappParam param) {
        Leaveapp entity = new Leaveapp();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
