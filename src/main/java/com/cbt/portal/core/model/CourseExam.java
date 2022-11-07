package com.cbt.portal.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course_exams")
@NamedQueries(
        {
                @NamedQuery(name = "CourseExam.findByQuesCourseId",query = "SELECT ce FROM CourseExam ce WHERE ce.course=:courseId")
        }
)
public class CourseExam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String exam_duration;
    private Date exam_date;
    private String venue;
    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private List<Courses> course;
    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private List<Questions> question;
//    private Integer question_id;
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

    public String getExam_duration() {
        return exam_duration;
    }

    public void setExam_duration(String exam_duration) {
        this.exam_duration = exam_duration;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
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

    public List<Courses> getCourse() {
        return course;
    }

    public void setCourse(List<Courses> course) {
        this.course = course;
    }

    public List<Questions> getQuestion() {
        return question;
    }

    public void setQuestion(List<Questions> question) {
        this.question = question;
    }
}
