package com.github.iyboklee.model;

import java.io.Serializable;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class User implements Serializable {

    @QuerySqlField(index = true)
    private Long seq;

    @QuerySqlField
    private String name;

    @QuerySqlField
    private int salary;

    protected User() {}

}
