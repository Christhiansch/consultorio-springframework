package com.csandoval.consultorio.doctor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csandoval.consultorio.specialty.domain.Specialty;

@Entity
@Table(name = "doctors")
public class Doctor
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name ="first_name", nullable = false, length = 70)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 70)
	private String lastName;

	@Column(name = "dni", nullable = false, length = 11)
	private String DNI;

	@Column(name = "medical_code", nullable = false, length = 11)
	private String medicalCode;
	
	@ManyToOne
	@JoinColumn(name = "specialty_id", nullable = false, foreignKey = @ForeignKey(name = "FK_doctor_specialty"))
	private Specialty specialty;

	public Doctor()
	{
		super();
	}

	public Doctor(String firstName, String lastName, String dNI, String medicalCode, Specialty specialty)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DNI = dNI;
		this.medicalCode = medicalCode;
		this.specialty = specialty;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getDNI()
	{
		return DNI;
	}

	public void setDNI(String dNI)
	{
		DNI = dNI;
	}

	public String getMedicalCode()
	{
		return medicalCode;
	}

	public void setMedicalCode(String medicalCode)
	{
		this.medicalCode = medicalCode;
	}

	public Specialty getSpecialty()
	{
		return specialty;
	}

	public void setSpecialty(Specialty specialty)
	{
		this.specialty = specialty;
	}
	
	
	
}
