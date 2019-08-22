package com.rgy.shopp.entity;


import javax.persistence.*;

/**
 * \* User: rgy
 * \* Date: 2019/8/22 11:20
 * \
 */
@Entity
@Table(name = "portal_user", schema = "", catalog = "")
public class UserEntity {
    private static final long serialVersionUID = -2242664293223677212L;

    private String id;
    private String username;
    private String password;
    private String usertype;
    private String truename;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertype", nullable = false, length = 1)
    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "truename", nullable = false, length = 32)
    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", truename='" + truename + '\'' +
                '}';
    }


}