package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门数据访问组件
 *
 * @author 李洪文
 * @date 2019/11/14 10:38
 */
@Mapper
public interface DepartmentMapper {
    //新增记录和更新记录都是对数据库表中所有字段操作，因此入口参数为department的实例

    /**
     * 新增记录
     *
     * @param record
     * @return
     */
    int insert( Department record );

    /**
     * 根据主键更新记录
     *
     * @param record 是department的实例，包括数据库表里面所有的字段
     * @return
     */
    int updateByPrimaryKey( Department record );

    /**
     * 根据部门编码获取部门信息详情，入口参数只需要部门编码和租户代码即可
     *
     * @param departmentCode 部门编码
     * @param tenantCode     租户代码
     * @return 部门信息详情
     */

    Department getByCode(
            @Param("departmentCode") String departmentCode ,
            @Param("tenantCode") String tenantCode );


    /**
     * 根据查询条件获取命中个数，入口参数为查询的实例以及租户代码
     *
     * @param queryDTO   查询条件
     * @param tenantCode 租户代码
     * @return 命中数量
     */
    Integer count(
            @Param("queryDTO") DepartmentQueryDTO queryDTO ,
            @Param("tenantCode") String tenantCode );

    /**
     * 根据查询条件获取部门列表
     *
     * @param queryDTO   查询条件
     * @param offset     开始位置
     * @param limit      记录数量
     * @param tenantCode 租户代码
     * @return 部门列表
     */
    List<Department> list(
            @Param("queryDTO") DepartmentQueryDTO queryDTO ,
            @Param("offset") Integer offset ,
            @Param("limit") Integer limit ,
            @Param("tenantCode") String tenantCode );

    /**
     * 根据代码列表批量删除部门
     *
     * @param codeList    代码列表
     * @param teacherCode 操作人
     * @param tenantCode  租户代码
     */
    void deleteByCodes(
            @Param("codeList") List<String> codeList ,
            @Param("teacherCode") String teacherCode ,
            @Param("tenantCode") String tenantCode );

    /**
     * 根据部门代码列表获取部门信息列表
     *
     * @param codeList   部门代码列表
     * @param tenantCode 租户代码
     * @return 部门列表
     */
    List<Department> listByCodes(
            @Param("codeList") List<String> codeList ,
            @Param("tenantCode") String tenantCode );

    /**
     * 根据部门名称查询部门列表
     *
     * @param departmentName 部门名称，模糊匹配
     * @param tenantCode     租户代码
     * @return 部门列表
     */
    List<Department> listByName(
            @Param("departmentName") String departmentName ,
            @Param("tenantCode") String tenantCode );
}