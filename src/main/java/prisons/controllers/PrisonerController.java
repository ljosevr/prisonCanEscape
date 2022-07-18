package prisons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import prisons.exceptions.ForbiddenException;
import prisons.models.dto.PrisonDto;
import prisons.models.service.PrisonerService;

@RestController
public class PrisonerController {
	
	@Autowired
	private PrisonerService prisonerService;
	
	/**
	 * Puede Un prisionero salidr de una Prision.
	 */
	@PostMapping("/prisoner")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean canEscape(@RequestBody PrisonDto prison) throws ForbiddenException {

			if(prisonerService.canEscape(prison.getPrison())) {
				return true;
			} else {
				throw new ForbiddenException();
			}

	}
}
