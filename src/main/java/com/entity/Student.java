package com.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Student.FIND_ALL, query = "select s from Student s order by s.firstName"),
        @NamedQuery(name = Student.FIND_BY_ID, query = "select s from Student s where s.id = ?1")
})

@Entity
public class Student {

    public static final String FIND_ALL = "Student.findAll";
    public static final String FIND_BY_ID = "Student.getById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;



    @ManyToMany(cascade = CascadeType.MERGE) // -- cu CascadeType.MERGE functioneaza sa adaug studenti noi insa cu ALL sau PERSIST nu functioneaza
    //@JsonManagedReference  ---> Elimina bucla insa nu pot trimite JSON corect pt creare de obiecte noi sau update
//    @JsonManagedReference  ---> Daca las adnotarea asta cand folosesc DTO da eroare (ceva de JSON...UTF8...not supported). Daca scot adnotarea insa merge
    //@JsonIdentityInfo merge pt relatii One to One insa nu si pt Many to Many
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id", scope = Student.class)
//    @JsonIgnore
    private List<Course> courses = new ArrayList<Course>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        return lastName != null ? lastName.equals(student.lastName) : student.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
