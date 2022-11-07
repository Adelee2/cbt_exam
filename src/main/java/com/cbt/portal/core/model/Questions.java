package com.cbt.portal.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "questions")
public class Questions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questiontype;
    @Column(columnDefinition = "TEXT")
    private String question;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "ques")
    private Answers answer;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ques")
    private List<Options> option;
    private String createdby;
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

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answers getAnswer() {
        return answer;
    }

    public void setAnswer(Answers answer) {
        this.answer = answer;
    }

    public List<Options> getOption() {
        return option;
    }

    public void setOption(List<Options> option) {
        this.option = option;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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
