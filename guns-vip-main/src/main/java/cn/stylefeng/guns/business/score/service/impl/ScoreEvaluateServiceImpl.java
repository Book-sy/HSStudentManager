package cn.stylefeng.guns.business.score.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.ScoreEvaluate;
import cn.stylefeng.guns.business.score.mapper.ScoreEvaluateMapper;
import cn.stylefeng.guns.business.score.model.params.ScoreEvaluateParam;
import cn.stylefeng.guns.business.score.model.result.ScoreEvaluateResult;
import  cn.stylefeng.guns.business.score.service.ScoreEvaluateService;
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
public class ScoreEvaluateServiceImpl extends ServiceImpl<ScoreEvaluateMapper, ScoreEvaluate> implements ScoreEvaluateService {

    @Override
    public void add(ScoreEvaluateParam param){
        ScoreEvaluate entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ScoreEvaluateParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ScoreEvaluateParam param){
        ScoreEvaluate oldEntity = getOldEntity(param);
        ScoreEvaluate newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ScoreEvaluateResult findBySpec(ScoreEvaluateParam param){
        return null;
    }

    @Override
    public List<ScoreEvaluateResult> findListBySpec(ScoreEvaluateParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ScoreEvaluateParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ScoreEvaluateParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private ScoreEvaluate getOldEntity(ScoreEvaluateParam param) {
        return this.getById(getKey(param));
    }

    private ScoreEvaluate getEntity(ScoreEvaluateParam param) {
        ScoreEvaluate entity = new ScoreEvaluate();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
