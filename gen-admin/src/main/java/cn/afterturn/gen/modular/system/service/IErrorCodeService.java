package cn.afterturn.gen.modular.system.service;

import cn.afterturn.gen.modular.system.model.ErrorCodeModel;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;


/**
 * Service
 *
 * @author David
 * @Date 2023-01-30 10:26
 */
public interface IErrorCodeService {

     /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer insert(ErrorCodeModel entity);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return int
     */
    Integer deleteById(Integer id);

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer updateById(ErrorCodeModel entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return ErrorCodeModel
     */
    ErrorCodeModel selectById(Integer id);

    /**
     * <p>
     * 根据 entity 条件，查询一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return ErrorCodeModel
     */
    ErrorCodeModel selectOne(ErrorCodeModel entity);

    /**
     * <p>
     * 根据 model 条件，查询总记录数
     * </p>
     *
     * @param model 实体对象
     * @return int
     */
    Integer selectCount(ErrorCodeModel model);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<ErrorCodeModel>
     */
    List<ErrorCodeModel> selectList(ErrorCodeModel model);


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model   实体对象封装操作可以为 null）
     * @param wrapper   SQL包装
     * @return List<ErrorCodeModel>
     */
    List<ErrorCodeModel> selectPage(Pagination pagination, ErrorCodeModel model, Wrapper<ErrorCodeModel> wrapper);

    /**
     * 获取当前最大值
     * @param codeType
     * @return
     */
    Integer selectMax(Integer codeType);

}
