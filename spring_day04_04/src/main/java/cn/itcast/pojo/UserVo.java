package cn.itcast.pojo;

import java.util.List;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-21 16:15
 **/
public class UserVo {

    private List<User>  users;

    @Override
    public String toString() {
        return "UserVo{" +
                "users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
