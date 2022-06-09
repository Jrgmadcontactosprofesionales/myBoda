package com.jorgealvarez.myboda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="attendant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private String surname;

//	TODO: solucionar el parse del jason que llega en String a LocalDate
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	private String ph;

	private Status attendingStatus;

	private String specialRequirement;

	private Availability specialRequirementStatus;
}
