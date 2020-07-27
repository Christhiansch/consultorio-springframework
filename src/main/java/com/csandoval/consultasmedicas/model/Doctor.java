package com.csandoval.consultasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Doctor
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 70)
	private String firstName;

	@Column(nullable = false, length = 70)
	private String lastName;

	@Column(nullable = false, length = 11)
	private String DNI;

	@Column(nullable = false, length = 11)
	private String medicalCode;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_doctor_specialty"))
	private Specialty specialty;

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
