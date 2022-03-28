package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="Training")
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Training implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTraining;
	private String trainingName;
	private Integer cost;

	
	@Enumerated(EnumType.STRING)
	private TrainingType trainingType;
	@Enumerated(EnumType.STRING)
	private CERTIFICAT certificat;
	private Date sessionStartDate;
	private Date sessionEndDate;
	private Integer maximumParticipantNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<Quiz> Quiz;
	
	@ManyToMany
	@JsonIgnore
	private Set<User> users;
	

}
