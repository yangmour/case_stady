package com.xiwen.mbg2.mapper;

import com.xiwen.mbg2.bean.Employees;
import com.xiwen.mbg2.bean.EmployeesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    long countByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int deleteByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int insert(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int insertSelective(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    List<Employees> selectByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    Employees selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int updateByExampleSelective(@Param("record") Employees record, @Param("example") EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int updateByExample(@Param("record") Employees record, @Param("example") EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int updateByPrimaryKeySelective(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbg.generated Thu Apr 06 17:57:12 CST 2023
     */
    int updateByPrimaryKey(Employees record);
}