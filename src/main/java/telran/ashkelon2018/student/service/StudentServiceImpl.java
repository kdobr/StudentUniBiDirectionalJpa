package telran.ashkelon2018.student.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.student.dao.GroupRepository;
import telran.ashkelon2018.student.dao.StudentRepository;
import telran.ashkelon2018.student.domain.Group;
import telran.ashkelon2018.student.domain.GroupeUpdateDto;
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
		Group group = groupRepository.findById(id).orElse(null);
		if( group== null) {
			return null;
		}
		//return studentRepository.findByGroupId(id);
		return group.getStudents();
	}

	@Override
	@Transactional
	public boolean removeGroupe(int id) {
		if(groupRepository.existsById(id)) {
			groupRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Group updateGroup(int id, GroupeUpdateDto groupeUpdateDto) {
		Group group = groupRepository.findById(id).get();
		if (group!=null) {
			group.setId(groupeUpdateDto.getId());
			group.setName(groupeUpdateDto.getName());
			return group;
		}
		return null;
	}

}
