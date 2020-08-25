package com.csandoval.consultorio.consultation.application.service;

import com.csandoval.consultorio.consultation.application.dto.ConsultationDTO;
import com.csandoval.consultorio.consultation.domain.Consultation;
import com.csandoval.consultorio.web.application.ICrud;

public interface IConsultationService extends ICrud<Consultation, Integer>
{
	Consultation registerDetailConsultation(Consultation consultation) throws Exception; 
}
