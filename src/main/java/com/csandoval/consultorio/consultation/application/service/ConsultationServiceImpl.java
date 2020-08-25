package com.csandoval.consultorio.consultation.application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csandoval.consultorio.consultation.domain.Consultation;
import com.csandoval.consultorio.consultation.infraestructure.repository.IConsultationRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

@Service
public class ConsultationServiceImpl extends CrudImpl<Consultation, Integer> implements IConsultationService
{
	
	@Autowired
	private IConsultationRepository consultationRepository;

	@Override
	protected IGenericRepository<Consultation, Integer> getRepository()
	{
		return consultationRepository;
	}

	@Transactional
	@Override
	public Consultation registerDetailConsultation(Consultation consultation) throws Exception
	{
		consultation.getDetailConsultation().forEach(detail -> detail.setConsultation(consultation));		
		return consultationRepository.save(consultation);
	}

}
