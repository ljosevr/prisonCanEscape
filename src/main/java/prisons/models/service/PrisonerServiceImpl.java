package prisons.models.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prisons.models.PositionInPrison;
import prisons.models.Prison;
import prisons.models.entity.PrisonerEntity;
import prisons.models.repository.PrisonerRepository;
import prisons.utils.PrisonActivity;


@Service
public class PrisonerServiceImpl implements PrisonerService{
	
	Logger logger = LoggerFactory.getLogger(PrisonerServiceImpl.class);
	
	@Autowired
	private PrisonerRepository prisonerRepository;
	
	/**
	 * Puede Un prisionero salir de una Prision.
	 */
	@Override
	public boolean canEscape(String[] prisonData) {
		
		Prison prison = new Prison(prisonData);
		
		PositionInPrison positionInPrisonPrisoner = PrisonActivity.whereIsPrisoner(prisonData); //Posicion del Prisionero
		PositionInPrison positionInPrisonExit = PrisonActivity.whereIsExit(prisonData); //Posicion de la Salida
		boolean prisonerCanEscape;
		
		if(positionInPrisonExit != null && positionInPrisonPrisoner != null) {
			prison.getPrison()[positionInPrisonExit.getRow()][positionInPrisonExit.getColumn()] = 'S';
			prisonerCanEscape = PrisonActivity.validatePrison(positionInPrisonPrisoner.getRow(), positionInPrisonPrisoner.getColumn(), prison);
		} else {
			logger.warn("Salida o Prisionero No encontrado");
			prisonerCanEscape = false;
		}
		PrisonerEntity p = prisonerRepository.save(new PrisonerEntity(prisonerCanEscape));
		logger.info(prison.toString());
		logger.info("Prisionero Creado: "+p.getId() + " - canEscape: "+prisonerCanEscape);
		return prisonerCanEscape;

	}
	
}
