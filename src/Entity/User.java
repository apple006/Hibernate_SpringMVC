package Entity;

import javax.persistence.*;

/**
 * 普通实体类
 */
@Entity
@Table(name = "user",schema = "xinli")
public class User {

    private Long id;
    //登录名
    private String login_name;
    //密码
    private String password;
    //头像
    private String profile;
    //昵称
    private String username;
    //性别
    private String gender;
    //简介
    private String introduction;
    //学校名称
    private String school_name;
    //学院
    private String college;
    //邮箱
    private String email;
    //电话号码
    private String phone_number;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String login_name) {
        this.login_name = login_name;
    }

    public User(String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }

    public User(String login_name, String password,Long id) {
        this.id = id;
        this.login_name = login_name;
        this.password = password;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "login_name",nullable = false)
    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "school_name")
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number",nullable = false)
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
