package cn.stylefeng.guns.business.temperature.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.temperature.entity.Temperature;
import cn.stylefeng.guns.business.temperature.mapper.TemperatureMapper;
import cn.stylefeng.guns.business.temperature.model.params.TemperatureParam;
import cn.stylefeng.guns.business.temperature.model.result.TemperatureResult;
import  cn.stylefeng.guns.business.temperature.service.TemperatureService;
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
 * @since 2020-09-01
 */
@Service
public class TemperatureServiceImpl extends ServiceImpl<TemperatureMapper, Temperature> implements TemperatureService {

    @Override
    public void add(TemperatureParam param){
        Temperature entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TemperatureParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TemperatureParam param){
        Temperature oldEntity = getOldEntity(param);
        Temperature newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TemperatureResult findBySpec(TemperatureParam param){
        return null;
    }

    @Override
    public List<TemperatureResult> findListBySpec(TemperatureParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(TemperatureParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(TemperatureParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Temperature getOldEntity(TemperatureParam param) {
        return this.getById(getKey(param));
    }

    private Temperature getEntity(TemperatureParam param) {
        Temperature entity = new Temperature();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
