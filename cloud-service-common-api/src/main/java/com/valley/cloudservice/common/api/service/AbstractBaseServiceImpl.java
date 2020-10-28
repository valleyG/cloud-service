/*
package com.valley.cloudservice.common.api.service;

import com.github.pagehelper.PageHelper;
import com.valley.cloudservice.common.api.entity.BasePO;
import com.valley.cloudservice.common.api.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

*/
/**
 * @author:zhuhongmin
 * @date:2020/4/9
 * @description:
 **//*

public abstract class AbstractBaseServiceImpl<T extends BasePO, D extends BaseMapper<T>> implements IBaseService<T> {
    @Autowired
    protected D mapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final int MAX_BATCH_NUM = 500;

    @Override
    public int save(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        entity.preSave();
        return mapper.insert(entity);
    }

    @Override
    public int deleteById(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        if (ObjectUtil.isNull(entity.getId())) {
            throw new MessageException("业务主键为空，无法删除，请检查参数.");
        }
        entity.preUpdate();
        return mapper.deleteById(entity);
    }

    @Override
    public int update(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        entity.preUpdate();
        return mapper.update(entity);
    }

    @Override
    public T selectById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public T selectByEntity(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        return mapper.selectByEntity(entity);
    }

    @Override
    public List<T> listByEntity(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");

        return mapper.listByEntity(entity);
    }

    @Override
    public NewPageInfo<T> page(Integer pageNum, Integer pageSize, T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        if (ObjectUtil.isNull(pageNum)) {
            pageNum = 1;
        }
        if (ObjectUtil.isNull(pageSize)) {
            pageSize = 20;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<T> entities = mapper.listByEntity(entity);
        return new NewPageInfo<>(entities);
    }

    @Override
    public <C extends SearchCondition> NewPageInfo<T> page(C condition) {
        Assert.notNull(condition,"基类service，基本对象entity不能为空");
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
    List<T> entities = mapper.listByCondition(condition);
        return new NewPageInfo<>(entities);
}

    @Override
    public Boolean exist(T entity) {
        Assert.notNull(entity,"基类service，基本对象entity不能为空");
        Optional<Integer> optional = mapper.exist(entity);
        return optional.orElse(2).equals(1);
    }

    */
/**
     * 开启审核时，新增数据并置为待审核状态
     *
     * @param entity
     * @return
     *//*

    @Override
    public int saveBeforeAudit(T entity) {
        entity.preSave();
        entity.preAudit();
        return mapper.insert(entity);
    }

    */
/**
     * 开启审核时，将需要删除的数据置为待审核状态
     *
     * @param entity
     * @return
     *//*

    @Override
    public int deleteBeforeAudit(T entity) {
        if (ObjectUtil.isNull(entity.getId())) {
            throw new MessageException("业务主键为空，无法删除，请检查参数.");
        }
        entity.preUpdate();
        entity.preAudit();
        return mapper.update(entity);
    }

    */
/**
     * 开启审核时，将需要修改的数据copy一份，同时更换主键id，置为待审核状态
     *
     * @param entity
     * @return
     *//*

    @Override
    public int updateBeforeAudit(T entity) {
        entity.setId(PrimaryKeyUtil.generateId());
        entity.preUpdate();
        entity.preAudit();
        return mapper.insert(entity);
    }

    */
/**
     * 开启审核时，新增或修改的操作，将数据状态置为审核通过
     *
     * @param entity
     * @return
     *//*

    @Override
    public int saveAuditPass(T entity) {
        entity.audit();
        return mapper.update(entity);
    }

    @Override
    public void batchSave(List<T> entities) {
        entities.forEach(BasePO::preSave);
        //如果批量插入数据大过阀值，切分list，批量插入
        if (entities.size() > MAX_BATCH_NUM) {
            List<List<T>> lists = CollectionUtil.dividedList(entities, MAX_BATCH_NUM);
            lists.forEach(list->mapper.batchInsert(list));
        }else {
            mapper.batchInsert(entities);
        }

    }

    @Override
    public void batchSaveAudit(List<T> entities) {
        entities.forEach(BasePO::preSaveAudit);
        //如果批量插入数据大过阀值，切分list，批量插入
        if (entities.size() > MAX_BATCH_NUM) {
            List<List<T>> lists = CollectionUtil.dividedList(entities, MAX_BATCH_NUM);
            lists.forEach(list->mapper.batchInsert(list));
        }else {
            mapper.batchInsert(entities);
        }

    }

    */
/**
     * 单对象操作记录，日志类型默认为普通日志
     * @param businessId 业务id
     * @param operationType 操作类型
     * @param data 数据对象
     *//*

    protected void recodeBusinessLog(String businessId, BusinessOperationTypeEnum operationType, Object data) {
        this.recordLog(businessId, LogTypeEnum.NORMAL, operationType, Collections.singletonList(data));
    }

    */
/**
     * 多对象操作记录，日志类型默认为普通日志
     * @param businessId 业务id
     * @param operationType 操作类型
     * @param data 数据对象
     *//*

    protected void recodeBusinessLog(String businessId, BusinessOperationTypeEnum operationType, List data) {
        this.recordLog(businessId, LogTypeEnum.NORMAL, operationType, data);
    }

    */
/**
     * 单对象操作记录，可以指定日志类型
     * @param businessId 业务id
     * @param operationType 操作类型
     * @param data 数据对象
     * @param logTypeEnum 日志类型
     *//*

    protected void recodeBusinessLog(String businessId,LogTypeEnum logTypeEnum, BusinessOperationTypeEnum operationType, Object data) {
        this.recordLog(businessId, logTypeEnum, operationType, Collections.singletonList(data));
    }

    */
/**
     * 多对象操作记录，可以指定日志类型
     * @param businessId 业务id
     * @param operationType 操作类型
     * @param data 数据对象
     * @param logTypeEnum 日志类型
     *//*

    protected void recodeBusinessLog(String businessId,LogTypeEnum logTypeEnum, BusinessOperationTypeEnum operationType, List data) {
        this.recordLog(businessId, logTypeEnum, operationType, data);
    }


    */
/**
     * 业务日志通用记录方法
     *
     * @param businessId    业务id（用于之后追溯修改日志）
     * @param operationType （操作类型）
     * @param data          记录的数据对象（同一业务最好统一对象，方便日志对比修改）
     * @see BusinessOperationTypeEnum
     *//*

    protected void recordLog(String businessId, LogTypeEnum logTypeEnum, BusinessOperationTypeEnum operationType, List data) {
 */
/*       String className = this.logMapper.selectParamClassName(businessId);
        if (StringUtil.isNotEmpty(className) && !className.equals(data.getClass().getName())) {
            throw new MessageException("该业务日志与上条日志记录的参数ClassName不同，请核实。ClassName:{" + className + "}");
        }*//*

        if (StringUtils.isEmpty(businessId)) {
            throw new MessageException("业务id为空，无法记录业务日志，请补充参数");
        }
        Assert.notNull(logTypeEnum,"日志类型为空，无效日志，请补充参数");
        Assert.notNull(operationType,"操作类型为空，无效日志，请补充参数");
        Assert.notEmpty(data,"日志数据为空，无效日志，请补充参数");

        BusinessLogDTO businessLog = new BusinessLogDTO();
        businessLog.setBusinessId(businessId)
                .setLogType(logTypeEnum.getType())
                .setOperationUser(RequestUtil.getUserCode())
                .setOperationRole(RequestUtil.getRole())
                .setOperationType(operationType.getType())
                .setOperationTime(DateUtil.date())
                .setMenuId(RequestUtil.getReqMenuId())
                .setMacPath(RequestUtil.getMac())
                .setLogInfos(data);

        rabbitTemplate.convertAndSend(MqConstants.BUSINESS_LOG_KEY, businessLog);
    }

    */
/**
     * 日志对比
     * @param businessId
     * @return
     *//*

*/
/*
    @Deprecated
    protected BusinessLogCompareResult compareLogInfo(String businessId) {
        BusinessLogCompareResult result = new BusinessLogCompareResult();
        BusinessLogPo param = new BusinessLogPo();
        param.setBusinessId(businessId);
        List<BusinessLogPo> businessLogPos = this.logMapper.listByEntity(param);

        if (CollectionUtil.isEmpty(businessLogPos)) {
            throw new MessageException("系统未记录相关业务日志，无法对比日志");
        }

        if (businessLogPos.size() == 1) {
            result.setOldObj(null)
                    .setNowObj(businessLogPos.get(0));
            return result;
        } else {
            BusinessLogPo oldLog = businessLogPos.get(1);
            BusinessLogPo nowLog = businessLogPos.get(0);
            if (BusinessOperationTypeEnum.DELETE.getType().equals(nowLog.getOperationType())) {
                //如果最后是删除操作，直接返回上一次的业务对象。
                result.setOldObj(oldLog)
                        .setNowObj(null);
                return result;
            }
            try {
                result.setOldObj(JSONObject.parseObject(oldLog.getOperationLog(), Class.forName(oldLog.getParamClassName())))
                        .setNowObj(JSONObject.parseObject(nowLog.getOperationLog(), Class.forName(nowLog.getParamClassName())))
                        .setChangeFieldList(ObjectUtilExtends.compareObject(result.getOldObj(), result.getNowObj(), null));
            } catch (ClassNotFoundException e) {
                throw new MessageException("未找到类：" + oldLog.getParamClassName());
            }
            return result;
        }

    }
*//*



}
*/
