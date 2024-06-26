package com.kaseya.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "kaseyatraining.employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = -4215379438393452763L;
    public Employee(UUID employeeID, String firstName, String lastName, Date DOB, String email, boolean active, int age, SkillLevel skillLevel) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.active = active;
        this.age = age;
        this.skillLevel = skillLevel;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "BINARY(16)")
    private UUID employeeID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "DOB")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy") // test using postman
    private Date DOB;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean active;
    @Column(name = "age")
    private int age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skilllevel_skillLevelID", updatable = true)
    private SkillLevel skillLevel;

    public Employee() {
    }

    public Employee(String firstName) {
        this.employeeID = UUID.randomUUID();
        this.firstName = firstName;
        this.age = 0;
        this.DOB = new Date();
        this.email = "";
        this.active = false;
        this.lastName = "";
        this.skillLevel = new SkillLevel();
    }

    public Employee(String firstName, SkillLevel skillLevel) {
        this.firstName = firstName;
        this.age = 0;
        this.DOB = new Date();
        this.email = "";
        this.active = false;
        this.lastName = "";
        this.skillLevel = skillLevel;
    }

    public UUID getEmployeeID() {
        return employeeID;
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", age=" + age +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
