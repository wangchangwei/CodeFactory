package cn.afterturn.gen.modular.system.dao;

import cn.afterturn.gen.modular.system.model.ErrorCodeModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ErrorCodeDao
 *
 * @author David
 * @Date 2023-01-30 10:26
 */
@Repository
public interface ErrorCodeDao extends BaseMapper<ErrorCodeModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e") ErrorCodeModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<ErrorCodeModel> selectList(@Param("e") ErrorCodeModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<ErrorCodeModel> selectPage(@Param("p") Pagination pagination, @Param("e") ErrorCodeModel model, @Param("w") Wrapper<ErrorCodeModel> wrapper);

    Integer selectMax(Integer codeType);
}
