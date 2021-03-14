package com.miujoke.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/14 15:33
 */
@Data
@AllArgsConstructor // 全参
@NoArgsConstructor  // 空参
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
