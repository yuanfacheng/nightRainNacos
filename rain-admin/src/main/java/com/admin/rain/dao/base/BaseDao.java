package com.admin.rain.dao.base;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author MJP
 * @Date 2023/11/28 15:05
 */
public interface BaseDao<T, M extends BaseMapper<T>> {

    /**
     * 获取dao
     *
     * @return dao
     */
    M getDao();

    /**
     * 新增数据
     *
     * @param t 数据
     * @return 新增量
     */
    default int insert(T t) {
        return getDao().insert(t);
    }

    /**
     * 按条件统计
     *
     * @param wrapper 查询条件
     * @return 统计数据
     */
    default Long count(LambdaQueryWrapper<T> wrapper) {
        return getDao().selectCount(wrapper);
    }

    /**
     * 按条件查询list
     *
     * @param wrapper 查询条件
     * @return list
     */
    default List<T> selectList(LambdaQueryWrapper<T> wrapper) {
        return getDao().selectList(wrapper);
    }

    /**
     * 根据id修改数据
     *
     * @param t 修改对象
     * @return 修改数据量
     */

    default int updateById(T t) {

        return getDao().updateById(t);
    }

    /**
     * 按id查询
     *
     * @param id id
     * @return 数据
     */
    default T selectById(Serializable id) {
        return getDao().selectById(id);
    }

    default T selectOne(LambdaQueryWrapper<T> queryWrapper) {
        return getDao().selectOne(queryWrapper);
    }

    /**
     * 分页查询
     *
     * @param wrapper 查询条件
     * @param q       分页数据
     * @return 数据
     */
//    default <Q extends PageReq> Page<T> selectPage(Q q, LambdaQueryWrapper<T> wrapper) {
//        Page<T> page = new Page<>();
//        page.setSize(q.getSize());
//        page.setCurrent(q.getCurrent());
//        return getDao().selectPage(page, wrapper);
//    }

    /**
     * 根据条件修改数据
     *
     * @param t       修改对象
     * @param wrapper 条件
     * @return 修改数据量
     */

    default int update(T t, LambdaUpdateWrapper<T> wrapper) {
        return getDao().update(t, wrapper);
    }

    /**
     * 根据条件删除数据
     *
     * @param wrapper 条件
     * @return 修改数据量
     */

    default int delete(LambdaQueryWrapper<T> wrapper) {
        return getDao().delete(wrapper);
    }


}
