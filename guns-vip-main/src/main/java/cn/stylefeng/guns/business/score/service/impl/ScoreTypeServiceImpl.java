package cn.stylefeng.guns.business.score.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.ScoreType;
import cn.stylefeng.guns.business.score.mapper.ScoreTypeMapper;
import cn.stylefeng.guns.business.score.model.params.ScoreTypeParam;
import cn.stylefeng.guns.business.score.model.result.ScoreTypeResult;
import  cn.stylefeng.guns.business.score.service.ScoreTypeService;
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
 * @since 2020-09-27
 */
@Service
public class ScoreTypeServiceImpl extends ServiceImpl<ScoreTypeMapper, ScoreType> implements ScoreTypeService {

    @Override
    public void add(ScoreTypeParam param){
        ScoreType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ScoreTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ScoreTypeParam param){
        ScoreType oldEntity = getOldEntity(param);
        ScoreType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ScoreTypeResult findBySpec(ScoreTypeParam param){
        return null;
    }

    @Override
    public List<ScoreTypeResult> findListBySpec(ScoreTypeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ScoreTypeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ScoreTypeParam param){
        return null;
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private ScoreType getOldEntity(ScoreTypeParam param) {
        return this.getById(param.getId());
    }

    private ScoreType getEntity(ScoreTypeParam param) {
        ScoreType entity = new ScoreType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
