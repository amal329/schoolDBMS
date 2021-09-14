package com.brillio.example.firstRestService;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sdetails")
//@RedisHash("sid")
public class StudentDTO implements Serializable{

    @Id
//    @GeneratedValue
    private String sid;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String dob;
    @Column
    private String address;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
