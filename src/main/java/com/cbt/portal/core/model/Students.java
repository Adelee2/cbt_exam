package com.cbt.portal.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@NamedQueries(
        {
                @NamedQuery(name = "Student.Login",query = "SELECT s from Students s WHERE s.matric_number=:matricNum and s.password=:encryptedPassword")
        }
)
public class Students implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matric_number;
    private String password;
    private String profile_pic;
    private String gender;
    private String which_level;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatric_number() {
        return matric_number;
    }

    public void setMatric_number(String matric_number) {
        this.matric_number = matric_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWhich_level() {
        return which_level;
    }

    public void setWhich_level(String which_level) {
        this.which_level = which_level;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
