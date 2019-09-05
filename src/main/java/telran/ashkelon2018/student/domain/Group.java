package telran.ashkelon2018.student.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@Table(name = "studentGroup")
public class Group {
	@Id
	int id;
	String name;
	@OneToMany (mappedBy="group", cascade=CascadeType.ALL)
	@JsonIgnore // for Jackson - not to seriolize this field;
	Set<Student> students;
	

}
