package com.csandoval.consultorio.medical.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csandoval.consultorio.doctor.domain.Doctor;
import com.csandoval.consultorio.patient.domain.Patient;

@Entity
@Table(name = "medical_consultations")
public class MedicalConsultation
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private LocalDateTime consultationDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_medicalconsultation_doctor"))
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false, foreignKey = @ForeignKey(name = "FK_medicalconsultation_patient"))
	private Patient patient;
	
	@OneToMany(mappedBy = "consultation", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<DetailConsultation> detailConsultation;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public LocalDateTime getConsultationDate()
	{
		return consultationDate;
	}

	public void setConsultationDate(LocalDateTime consultationDate)
	{
		this.consultationDate = consultationDate;
	}

	public Doctor getDoctor()
	{
		return doctor;
	}

	public void setDoctor(Doctor doctor)
	{
		this.doctor = doctor;
	}

	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

}
