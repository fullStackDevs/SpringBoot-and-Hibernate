package com.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Course.FIND_ALL, query = "select c from Course c"),
        @NamedQuery(name = Course.FIND_BY_ID, query = "select c from Course c where c.id = ?1")

})

@Entity
public class Course {

    public static final String FIND_ALL = "Course.findAll";
    public static final String FIND_BY_ID = "Course.findById";
    public static final String FIND_ENROLLED_STUDENTS = "Course.findEnrolledStudents";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

  //   @JsonBackReference ---> Daca las adnotarea asta cand folosesc DTO da eroare (ceva de JSON...UTF8...not supported). Daca scot adnotarea insa merge
    //@JsonIdentityInfo ---> merge pt relatii One to One insa nu si pt Many to Many
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id", scope = Course.class)

    //###***###
        //Putem sa nu folosim deloc DTO si sa folosim doar "@JsonIgnore" si "CascadeType.MERGE" si vor functiona ok toate operatiunile
        // (nu vom avea bucla infinita la parsarea JSON-ului, va merge sa facem POST, GET, DELETE)
    //###***###
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "courses")
    @JsonIgnore // ---> chiar daca folosim DTO trebuie sa punem si adnotarea "@JsonIgnore" pentru a nu intra in bucla infinita cand se sederializeaza raspunsul in fornt end
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
