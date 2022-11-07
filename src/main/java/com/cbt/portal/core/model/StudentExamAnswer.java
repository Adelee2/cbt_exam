package com.cbt.portal.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student_exam_answers")
@NamedQueries(
        {
                @NamedQuery(name = "StudentExamAnswer.findByAnswerByStudentId",query = "SELECT se from StudentExamAnswer se WHERE se.student_id=:studentId")
        }
)
public class StudentExamAnswer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer student_id;
    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private List<CourseExam> course_exams;
    private String student_answer;
    private String scorepoint;
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

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public List<CourseExam> getCourse_exams() {
        return course_exams;
    }

    public void setCourse_exams(List<CourseExam> course_exams) {
        this.course_exams = course_exams;
    }

    public String getStudent_answer() {
        return student_answer;
    }

    public void setStudent_answer(String student_answer) {
        this.student_answer = student_answer;
    }

    public String getScorepoint() {
        return scorepoint;
    }

    public void setScorepoint(String scorepoint) {
        this.scorepoint = scorepoint;
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
