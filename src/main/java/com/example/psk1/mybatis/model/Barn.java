package com.example.psk1.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Barn {

    private List<Animal> animals;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BARN.ID
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BARN.NAME
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BARN.ID
     *
     * @return the value of PUBLIC.BARN.ID
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BARN.ID
     *
     * @param id the value for PUBLIC.BARN.ID
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BARN.NAME
     *
     * @return the value of PUBLIC.BARN.NAME
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BARN.NAME
     *
     * @param name the value for PUBLIC.BARN.NAME
     *
     * @mbg.generated Fri Apr 01 14:19:59 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}