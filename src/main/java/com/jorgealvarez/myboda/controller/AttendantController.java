package com.jorgealvarez.myboda.controller;

import com.jorgealvarez.myboda.model.Attendant;
import com.jorgealvarez.myboda.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.jorgealvarez.myboda.service.getAuthorityService.isAdmin;
import static com.jorgealvarez.myboda.service.loggedUserService.getLoggedUserService;

@Controller
public class AttendantController {
	//TODO: ¿crear métodos genéricos?
	@Autowired
	private AttendantRepository attendantRepository;
	
	@GetMapping({"/asistentes"})
	public ModelAndView getAttendants() {
		ModelAndView modelAndView = new ModelAndView("/attendants/list-attendants");
		String loggedUser = getLoggedUserService();
		if (isAdmin()) {
			modelAndView.addObject("attendants", attendantRepository.findAll());
		} else {
		modelAndView.addObject("attendants", attendantRepository.findByloggedUserContaining(getLoggedUserService()));
		}
		return modelAndView;
	}
	
	@GetMapping("/nuevo-asistente")
	public ModelAndView addAttendant() {
		ModelAndView modelAndView = new ModelAndView("/attendants/add-attendant");
		Attendant attendant = new Attendant();
		modelAndView.addObject("attendant", attendant);
		return modelAndView;
	}
	
	@PostMapping("/guardar-nuevo-asistente")
	public String saveAttendant (@ModelAttribute Attendant attendant) {
		attendant.setLoggedUser(getLoggedUserService());
		attendantRepository.save(attendant);
		return "redirect:/asistentes";
	}
	
	@GetMapping("/editar-asistente")
	public ModelAndView editAttendant (@RequestParam int attendantId) {
		ModelAndView modelAndView = new ModelAndView("/attendants/add-attendant");
		Attendant attendant = attendantRepository.findById(attendantId).get();
		modelAndView.addObject("attendant", attendant);
		return modelAndView;
	}
	
	@GetMapping("/eliminar-asistente")
	public String deleteAttendant(@RequestParam int attendantId) {
		attendantRepository.deleteById(attendantId);
		return "redirect:/asistentes";
	}
}
