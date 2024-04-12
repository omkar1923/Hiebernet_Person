package hibernet_student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="person_info")
public class Person {
	@Id
	@Column(name="person_id")
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String address;
	private String password;

}
