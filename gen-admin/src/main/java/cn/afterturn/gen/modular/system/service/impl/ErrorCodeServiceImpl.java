package cn.afterturn.gen.modular.system.service.impl;

import cn.afterturn.gen.modular.system.dao.ErrorCodeDao;
import cn.afterturn.gen.modular.system.model.ErrorCodeModel;
import cn.afterturn.gen.modular.system.service.IErrorCodeService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service
 *
 * @author David
 * @Date 2023-01-30 10:26
 */
@Service
public class ErrorCodeServiceImpl implements IErrorCodeService {

    @Autowired
    private ErrorCodeDao errorCodeDao;

    @Override
    public Integer insert(ErrorCodeModel entity) {
        return errorCodeDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return errorCodeDao.deleteById(id);
    }

    @Override
    public Integer updateById(ErrorCodeModel entity) {
        return errorCodeDao.updateById(entity);
    }

    @Override
    public ErrorCodeModel selectById(Integer id) {
        return errorCodeDao.selectById(id);
    }

    @Override
    public ErrorCodeModel selectOne(ErrorCodeModel entity) {
        return errorCodeDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(ErrorCodeModel model) {
        return errorCodeDao.selectCount(model);
    }

    @Override
    public List<ErrorCodeModel> selectList(ErrorCodeModel model) {
        return errorCodeDao.selectList(model);
    }

    @Override
    public List<ErrorCodeModel> selectPage(Pagination pagination, ErrorCodeModel model, Wrapper<ErrorCodeModel> wrapper) {
        return errorCodeDao.selectPage(pagination,model,wrapper);
    }

    @Override
    public Integer selectMax(Integer codeType) {
        return errorCodeDao.selectMax(codeType);
    }


}
