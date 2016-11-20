package yoko.repository;

import org.springframework.stereotype.Repository;
import yoko.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Yoko on 20.11.2016.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("select student from Student student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student find(Long id) {
        Student student = em.find(Student.class, id);
        return student;
    }

    @Override
    public boolean add(Student student) {
        em.persist(student);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        em.remove(em.find(Student.class, id));
        return true;
    }

    @Override
    public List<Student> findByStudentId(Long student_id) {
        TypedQuery<Student> query = em.createQuery(
                "SELECT student from Student student WHERE student.id LIKE :text", Student.class);
        query.setParameter("text", student_id);
        return query.getResultList();
    }
}
