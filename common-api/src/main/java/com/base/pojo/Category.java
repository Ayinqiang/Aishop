package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PPmaster
 * @since 2021/5/13 22:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer classCode;
    private String className;
    private String icon;
    private String color;
}
