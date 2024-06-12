package cn.afterturn.gen.modular.code.service;

import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;


/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:24
 */
public interface ITableFieldVerifyService extends IService<TableFieldVerifyModel> {


    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return TableFieldVerifyModel
     */
    TableFieldVerifyModel selectById(Integer id);



    /**
     * <p>
     * 根据 model 条件，查询总记录数
     * </p>
     *
     * @param model 实体对象
     * @return int
     */

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<TableFieldVerifyModel>
     */
    List<TableFieldVerifyModel> selectList(TableFieldVerifyModel model);


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model   实体对象封装操作可以为 null）
     * @param wrapper   SQL包装
     * @return List<TableFieldVerifyModel>
     */
    List<TableFieldVerifyModel> selectPage(Pagination pagination, TableFieldVerifyModel model,Wrapper<TableFieldVerifyModel> wrapper);

    /**
     * 批量删除,根据字段的数据
     * @param fieldIds
     */
    Integer deleteByFieldIds(List<Integer> fieldIds);

    /**
     * 批量插入
     * @param verifyModelList
     * @return
     */
    Integer batchInsert(List<TableFieldVerifyModel> verifyModelList);
}
