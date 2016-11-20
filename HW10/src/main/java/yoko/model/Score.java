package yoko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Yoko on 19.11.2016.
 */
@Entity
@SequenceGenerator(name = "serialNumScore", sequenceName = "seq_id")
public class Score {

    public Score() {};

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialNumScore")
    @Column
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private String subject_type;

    @NotNull
    @Column
    private int score;

    @NotNull
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private int student_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }
}
