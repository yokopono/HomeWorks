package yoko;

import yoko.model.Student;
import yoko.repository.StudentRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yoko on 20.11.2016.
 */
public class MainClass {

    @PersistenceContext
    EntityManager em;

    public static void main(String[] args) {

        showSumScoreStudent("Соловьев");
        showAvgScoreStudent("Соловьев");
        showScoreStudent("Соловьев","Информатика");

    }

    public  String showSumScoreStudent(String surname) {
        Query query = em.createQuery("SELECT COUNT(score.score) FROM Score score, Student student WHERE " +
                "student.surname LIKE :surname");
        query.setParameter("surname", surname);
        String s = "";
        return s.valueOf(query.getSingleResult());
    }

    public String showAvgScoreStudent(String surname) {
        Query query = em.createQuery("SELECT AVG(score.score) FROM Score score, Student student WHERE " +
                "student.surname LIKE :surname", Student.class);
        query.setParameter("surname", surname);
        return String.valueOf(query.getResultList());
    }
    public String showScoreStudent(String surname, String subject_type) {
        Query query = em.createQuery("SELECT score.score FROM Score score, Student student WHERE " +
                "student.surname LIKE :surname AND score.subject_type LIKE :subject_type", Student.class);
        query.setParameter("surname", surname);
        query.setParameter("subject_type", subject_type);
        return String.valueOf(query.getResultList());
    }

}

