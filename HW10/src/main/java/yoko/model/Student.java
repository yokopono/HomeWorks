package yoko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Yoko on 19.11.2016.
 */
@Entity
@SequenceGenerator(name = "serialNumStudent", sequenceName = "student_id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialNumStudent")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private String id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "surName")
    private String surName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "studGroup")
    private long studGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(long studGroup) {
        this.studGroup = studGroup;
    }
}
