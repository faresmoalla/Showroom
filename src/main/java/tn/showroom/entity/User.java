package tn.showroom.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idUser;
	
	private String Nom ;
	private String Prenom ;
	private String password;
	
	
	private Long NumeroTelephone;
	private Long Cin;
	
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Role role;

	
	
	
}
