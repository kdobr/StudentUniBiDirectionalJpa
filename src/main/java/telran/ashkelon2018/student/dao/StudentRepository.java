package telran.ashkelon2018.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2018.student.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Iterable<Student> findByGroupId (int id);

}
