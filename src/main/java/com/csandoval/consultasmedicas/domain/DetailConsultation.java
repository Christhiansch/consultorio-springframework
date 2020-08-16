package com.csandoval.consultasmedicas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_consultations")
public class DetailConsultation
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "consultation_id", nullable = false, foreignKey = @ForeignKey(name = "FK_detail_consultation"))
	private MedicalConsultation consultation;

	@Column
	private String diagnostic;

	@Column
	private String treatment;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public MedicalConsultation getConsultation()
	{
		return consultation;
	}

	public void setConsultation(MedicalConsultation consultation)
	{
		this.consultation = consultation;
	}

	public String getDiagnostic()
	{
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic)
	{
		this.diagnostic = diagnostic;
	}

	public String getTreatment()
	{
		return treatment;
	}

	public void setTreatment(String treatment)
	{
		this.treatment = treatment;
	}

}
