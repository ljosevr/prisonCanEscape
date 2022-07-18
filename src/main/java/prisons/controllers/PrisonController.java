package prisons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import prisons.exceptions.ForbiddenException;
import prisons.models.dto.PrisonDto;
import prisons.models.dto.StatsPrisonDto;
import prisons.models.service.PrisonService;
import prisons.models.service.PrisonerService;

@RestController
public class PrisonController {
	
	@Autowired
	private PrisonService prisonService;
	
	/**
	 * Metodo para consultar las estadisticas de la Prision.
	 */
	@GetMapping("/stats")
	public StatsPrisonDto stats() {
		return prisonService.stats();
	}
	
	
}
