package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;
	private String name;
	private Date dateOfBirth;
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(mappedBy="users", cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Training> trainings;

}
