package telran.ashkelon2018.student.service;

import telran.ashkelon2018.student.domain.Group;
import telran.ashkelon2018.student.domain.GroupeUpdateDto;
import telran.ashkelon2018.student.domain.Student;

public interface StudentService {
	
	boolean addStudent(Student student);
	
	Student removeStudent(int id);
	
	Student findStudent(int id);
	
	Iterable<Student> getStudentsByGroupId(int id);
	
	boolean removeGroupe (int id);
	
	Group updateGroup (int id, GroupeUpdateDto groupeUpdateDto);

}
