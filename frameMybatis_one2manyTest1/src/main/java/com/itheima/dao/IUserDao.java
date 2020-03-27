package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/15/20:40
 *用户的持久层接口
 */

public interface IUserDao {
    /*
    查询所有操作
     */
  List<User> findAll();

   //根据ID查询用户信息
   User findById(Integer userId);

   //根据名称模糊查询用户信息
   List<User> findByName(String username);


   //根据queryVo中的条件查询用户
  List<User> findUserByVo(QueryVo vo);

  //根据传入的参数条件  查询的条件：可能是用户名  性别  地址 可能都有

  List<User> findUserByCondition(User user);

  //根据queryvo中提供的ID集合，查询用户信息
  List<User> findUserInIds(QueryVo vo);
}
