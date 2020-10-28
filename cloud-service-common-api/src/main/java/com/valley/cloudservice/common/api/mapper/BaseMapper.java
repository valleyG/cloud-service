package com.valley.cloudservice.common.api.mapper;

import com.valley.cloudservice.common.api.entity.BasePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
*
* @author:zhuhongmin
* @date:2020/4/9
* @description:
**/
public interface BaseMapper<T extends BasePO> {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 根据id删除（逻辑删除）
     * @param entity
     */
    int deleteById(T entity);

    /**
     * 更新（通过主键id）
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 根据主键id查询
     * @param id
     * @return
     */
    T selectById(@Param("id") Long id);

    /**
     * 根据对象查询个体对象
     * @param entity
     * @return
     */
    T selectByEntity(T entity);

    /**
     * 根据对象列表查询
     * @param entity
     * @return
     */
    List<T> listByEntity(T entity);

    /**
     * 批量插入数据
     * @param entities
     */
    void batchInsert(List<T> entities);

/*    *//**
     * 条件查询
     * @param condition
     * @param <C>
     * @return
     *//*
    <C extends SearchCondition> List<T> listByCondition(C condition);*/


    /**
     * 判断记录是否存在
     * @param entity
     * @return
     */
    Optional<Integer> exist(T entity);
}
