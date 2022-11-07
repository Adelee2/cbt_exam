package com.cbt.portal.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "answers")
public class Answers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal scorepoint;
    private String answer;
    @OneToOne
    private Questions ques;
    private BigDecimal degree_of_correctness;
    private String description;
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

    public BigDecimal getScorepoint() {
        return scorepoint;
    }

    public void setScorepoint(BigDecimal scorepoint) {
        this.scorepoint = scorepoint;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions getQues() {
        return ques;
    }

    public void setQues(Questions ques) {
        this.ques = ques;
    }

    public BigDecimal getDegree_of_correctness() {
        return degree_of_correctness;
    }

    public void setDegree_of_correctness(BigDecimal degree_of_correctness) {
        this.degree_of_correctness = degree_of_correctness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
