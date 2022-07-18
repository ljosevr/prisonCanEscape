package prisons.models.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prisons.models.dto.StatsPrisonDto;
import prisons.models.entity.PrisonerEntity;
import prisons.models.repository.PrisonerRepository;

@Service
public class PrisonServiceImpl implements PrisonService{
	
	Logger logger = LoggerFactory.getLogger(PrisonServiceImpl.class);
	
	@Autowired
	private PrisonerRepository prisonerRepository;
	
	/**
	 * Metodo para consultar las estadisticas de la Prision.
	 */
	@Override
	public StatsPrisonDto stats() {
		
		List<PrisonerEntity> allPrisoners = prisonerRepository.findAll();
		
		StatsPrisonDto stat = new StatsPrisonDto();
		stat.setCountSuccessfulEscape((int) allPrisoners.stream()
				.filter(PrisonerEntity::isEscape)
				.count());
		stat.setCountUnsuccessfulEscape(allPrisoners.size() - stat.getCountSuccessfulEscape());
		
		if(stat.getCountUnsuccessfulEscape() > 0) {
			stat.setRatio((stat.getCountSuccessfulEscape()/(double)stat.getCountUnsuccessfulEscape()));
		} else { 
			stat.setRatio(0d);
		}
		
		return stat;
	}

}
