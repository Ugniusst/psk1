package com.example.psk1.mybatis.dao;

import com.example.psk1.mybatis.model.Worker;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    int insert(Worker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    Worker selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    List<Worker> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    int updateByPrimaryKey(Worker record);
}