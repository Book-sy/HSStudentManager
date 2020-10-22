package cn.stylefeng.guns.business.score.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-27
 */
@TableName("_score")
public class Score implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 学期类型
     */
    @TableField("type")
    private Long type;

    /**
     * 用户
     */
    @TableField("user")
    private Long user;

    /**
     * 分数
     */
    @TableField("score")
    private Double score;

    /**
     * 排名
     */
    @TableField("ranking")
    private Integer ranking;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Score{" +
        "id=" + id +
        ", type=" + type +
        ", user=" + user +
        ", score=" + score +
        ", ranking=" + ranking +
        "}";
    }
}
