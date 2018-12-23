package telran.ashkelon2018.student.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.student.dao.GroupRepository;
import telran.ashkelon2018.student.dao.StudentRepository;
import telran.ashkelon2018.student.domain.Group;
import telran.ashkelon2018.student.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GroupRepository groupRepository;

	@Override
	@Transactional
	public boolean addStudent(Student student) {
		if (studentRepository.existsById(student.getId())) {
			return false;
		}
		Group group = student.getGroup();
		if (!groupRepository.existsById(group.getId())) {
			groupRepository.save(group);
		}
		studentRepository.save(student);
		return true;
	}

	@Override
	public Student removeStudent(int id) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			studentRepository.deleteById(id);
		}
		return student;
	}

	@Override
	public Student findStudent(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Student> getStudentsByGroupId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
