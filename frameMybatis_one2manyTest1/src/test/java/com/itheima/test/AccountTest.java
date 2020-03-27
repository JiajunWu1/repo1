package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/15/21:00
 */
public class AccountTest {
    private  InputStream in;
    private  SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init()throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        sqlSession=factory.openSession();
        accountDao=sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy()throws Exception{
        /*//提交事务
        sqlSession.commit();*/
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll() {

        List<Account> accounts=accountDao.findAll();
        for (Account account:accounts){
            System.out.println("----------每个account的信息:");
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }

    //查询所有账户以及名称和地址
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser>  aus=accountDao.findAllAccount();
        for (AccountUser au:aus){
            System.out.println(au);
        }
    }
 }
