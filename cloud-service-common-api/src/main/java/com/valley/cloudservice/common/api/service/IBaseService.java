package com.valley.cloudservice.common.api.service;

import com.github.pagehelper.PageInfo;
import com.valley.cloudservice.common.api.entity.BasePO;

import java.util.List;

/**
*
* @author:zhuhongmin
* @date:2020/4/9
* @description: service增删改查基类封装
**/
public interface IBaseService<T extends BasePO> {
    /**
     * 保存
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 删除
     * @param entity
     * @return
     */
    int deleteById(T entity);

    /**
     * 更新（通过主键id）
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 通过主键id查询对象
     * @param id
     * @return
     */
    T selectById(Long id);

    /**
     * 查询单一对象（条件查询）
     * @param entity
     * @return
     */
    T selectByEntity(T entity);

    /**
     * 条件列表查询
     * @param entity
     * @return
     */
    List<T> listByEntity(T entity);

    /**
     * 分页列表查询
     * @param pageNum
     * @param pageSize
     * @param entity
     * @return
     */
    PageInfo<T> page(Integer pageNum, Integer pageSize, T entity);


  /*  *//**
     * 条件列表分页查询
     * @param condition
     * @return
     *//*
    <C extends SearchCondition> PageInfo<T> page(C condition);
*/
    /**
     * 判断记录是否存在
     * @param entity
     * @return
     */
    Boolean exist(T entity);

    /**
     * 需要审核时，保存审核状态为待审核的数据
     * @param entity
     *  @return
     */
    int saveBeforeAudit(T entity);

    /**
     * 需要审核时，删除审核状态为待审核的数据
     * @param entity
     * @return
     */
    int deleteBeforeAudit(T entity);

    /**
     * 需要更新时，更新审核状态为待审核的数据
     * @param entity
     * @return
     */
    int updateBeforeAudit(T entity);

    /**
     * 审核通过时更新数据
     * @param entity
     * @return
     */
    int saveAuditPass(T entity);

    /**
     * 批量插入数据
     * @param entities
     */
    void batchSave(List<T> entities);

    void batchSaveAudit(List<T> entities);
}
