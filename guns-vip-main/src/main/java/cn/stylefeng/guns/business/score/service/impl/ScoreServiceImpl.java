package cn.stylefeng.guns.business.score.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.Score;
import cn.stylefeng.guns.business.score.mapper.ScoreMapper;
import cn.stylefeng.guns.business.score.model.params.ScoreParam;
import cn.stylefeng.guns.business.score.model.result.ScoreResult;
import  cn.stylefeng.guns.business.score.service.ScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Override
    public void add(ScoreParam param){
        Score entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void eveplus(Long id) {
        this.baseMapper.eveplus(id);
    }

    @Override
    public void delete(ScoreParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ScoreParam param){
        Score oldEntity = getOldEntity(param);
        Score newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ScoreResult findBySpec(ScoreParam param){
        return null;
    }

    @Override
    public List<ScoreResult> findListBySpec(ScoreParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ScoreParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ScoreParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Score getOldEntity(ScoreParam param) {
        return this.getById(getKey(param));
    }

    private Score getEntity(ScoreParam param) {
        Score entity = new Score();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
