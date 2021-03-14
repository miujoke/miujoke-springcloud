package com.miujoke.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:43
 */
@Data
@AllArgsConstructor // 全参
@NoArgsConstructor  // 空参
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
