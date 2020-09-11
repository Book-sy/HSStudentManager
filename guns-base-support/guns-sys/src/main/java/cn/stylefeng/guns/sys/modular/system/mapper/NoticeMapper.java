package cn.stylefeng.guns.sys.modular.system.mapper;

import cn.stylefeng.guns.sys.modular.system.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取通知列表
     */
    Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition);
    
    /**
     * 获取未读消息
     */
    int getUnread();
    
    
    /**
     * 前端个人首页通知
     */
    List<Notice> ListIdentification(@Param("condition") String condition,@Param("identification") String identification);
}
