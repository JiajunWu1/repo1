package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/18/0:22
 */
public interface IRoleDao  {
    //查询所有角色
    List<Role> findAll();
}
