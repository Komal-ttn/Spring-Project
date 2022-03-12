package com.learn.Jpql.JpqlDemo.student.repository;

import com.learn.Jpql.JpqlDemo.student.entity.Student;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstName,st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    //Named query param
    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>:min and score<=:max")
    List<Student> findStudentsForGivenScores(@Param("min") int min,@Param("max") int max);

    @Modifying  //modifying and not select query
    @Query("delete from Student where firstName=:firstName")
    void deleteStudentByFirstName(@Param("firstName") String firstName);

    //NativeQuery

    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudentNQ();

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Student> findAllStudentsByFirstNameNQ(@Param("firstName") String firstName);
}
