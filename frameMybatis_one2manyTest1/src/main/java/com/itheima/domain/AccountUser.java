package com.itheima.domain;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/17/23:12
 */
public class AccountUser extends Account{
      private  String username;
      private  String address;

    @Override
    public String toString() {
        return super.toString()+"AccountUser{" +//先调用父类的 toString方法在调用自己的
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
