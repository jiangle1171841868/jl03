package cn.itcast.pojo;

import java.util.Arrays;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-19 21:37
 **/
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private Boolean isMarry;
    private Float income;
    private String [] interests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarry() {
        return isMarry;
    }

    public void setMarry(Boolean marry) {
        isMarry = marry;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMarry=" + isMarry +
                ", income=" + income +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }
}
