package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Course.FIND_ALL, query = "select c from Course c")
})

@Entity
public class Course {

    public static final String FIND_ALL = "Course.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Student> students = new ArrayList<Student>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        return startDate != null ? startDate.equals(course.startDate) : course.startDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
