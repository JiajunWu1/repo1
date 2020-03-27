package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/15/21:00
 */
public class UserTest {
    private  InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init()throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() {
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println("————每个用户的信息：");
            System.out.println(user);
            System.out.println(user.getRoles());
        }

    }
    /*根据名称模糊查询用户信息*/
    @Test
    public void testFindByName(){
        List<User> users=userDao.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }


    /*根据queryVo中的条查询*/
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users=userDao.findUserByVo(vo);
        for (User u: users){
            System.out.println(u);
        }
    }

    //c测试查询所有
    @Test
    public void testFindByCondition(){
        User u=new User();
        u.setUsername("老王");
        u.setSex("女");
        List<User> users=userDao.findUserByCondition(u);
        for (User user :users){
            System.out.println(user);
        }
    }

    //c测试foreach标签的使用
    @Test
    public void testFindInIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setIds(list);

        List<User> users=userDao.findUserByVo(vo);
        for (User user :users){
            System.out.println(user);
        }
    }
 }
