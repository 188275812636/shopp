package com.rgy.shopp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * \* User: rgy
 * \* Date: 2019/8/27 16:43
 * \
 */
@Entity
@Table(name = "sp", schema = "", catalog = "")
public class SpEntity {

    private String id;
    private String spmc;
    private String spmk;
    private String spfl;
    private String spms;
    private Date tjsj;
    private String yxbz;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "spmc", nullable = false, length = 255)
    public String getSpmc() {
        return spmc;
    }


    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    @Basic
    @Column(name = "spmk", nullable = false, length = 255)
    public String getSpmk() {
        return spmk;
    }

    public void setSpmk(String spmk) {
        this.spmk = spmk;
    }

    @Basic
    @Column(name = "spfl", nullable = false, length = 255)
    public String getSpfl() {
        return spfl;
    }

    public void setSpfl(String spfl) {
        this.spfl = spfl;
    }

    @Basic
    @Column(name = "spms", nullable = false, length = 255)
    public String getSpms() {
        return spms;
    }

    public void setSpms(String spms) {
        this.spms = spms;
    }

    @Basic
    @Column(name = "tjsj", nullable = false, length = 0)
    public Date getTjsj() {
        return tjsj;
    }

    public void setTjsj(Date tjsj) {
        this.tjsj = tjsj;
    }

    @Basic
    @Column(name = "yxbz", nullable = false, length = 1)
    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }
}