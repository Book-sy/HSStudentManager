package cn.stylefeng.guns.sys.modular.system.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.sys.modular.system.entity.Notice;
import cn.stylefeng.guns.sys.modular.system.mapper.NoticeMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> {

    /**
     * 获取通知列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:05 PM
     */
    public Page<Map<String, Object>> list(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page, condition);
    }
    /**
    *获取未读消息
    *@author 曹操
    *@date 2020-07-05 20:26
    *@version 1.0
    */
    public int getUnread()
    {
        return this.baseMapper.getUnread();
    }
    
    
    
    /**
     * 前端个人首页通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:05 PM
     */
    public List<Notice> ListIdentiFication(String condition, String identification) {
        return this.baseMapper.ListIdentification(condition,identification);
    }
}
