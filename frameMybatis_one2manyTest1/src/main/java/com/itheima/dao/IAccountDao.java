package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/17/21:36
 */
public interface IAccountDao {
    //查询所有账户
    List<Account>  findAll();

    //查询账户，并且带有用户名称和地址信息
    List<AccountUser> findAllAccount();
}
