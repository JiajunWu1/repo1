package com.itheima.domain;

import java.util.List;

/**
 * created  with Intellij  IDEA.
 *
 * @Auther:WJJ
 * @Date:2020/03/15/23:16
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
