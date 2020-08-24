package com.csandoval.consultorio.patient.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient
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
	private String numberClinicalHistory;

	public Patient()
	{
		
	}
	
	public Patient(String firstName, String lastName, String dNI, String numberClinicalHistory)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DNI = dNI;
		this.numberClinicalHistory = numberClinicalHistory;
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

	public String getNumberClinicalHistory()
	{
		return numberClinicalHistory;
	}

	public void setNumberClinicalHistory(String numberClinicalHistory)
	{
		this.numberClinicalHistory = numberClinicalHistory;
	}

	@Override
	public String toString()
	{
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", DNI=" + DNI
				+ ", numberClinicalHistory=" + numberClinicalHistory + "]";
	}
	
	

}
