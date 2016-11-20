package yoko.repository;

import yoko.model.Student;

import java.util.List;

/**
 * Created by Yoko on 20.11.2016.
 */
public interface StudentRepository {

    List<Student> findAll();

    Student find(Long id);

    boolean add(Student student);

    boolean remove(Long id);

    List<Student> findByStudentId(Long student_id);
}
