package com.miujoke.auth9001.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键ID
    private long id;
    /**
     * 用户ID
     */
    private Long parentId;

    /**
     * 权限名字
     */
    private String name;

    /**
     * 权限名字
     */
    private String ename;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
