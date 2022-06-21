package com.jorgealvarez.myboda.controller;

import com.jorgealvarez.myboda.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingListController {
	//TODO: ¿crear métodos genéricos?
	@Autowired
	private AttendantRepository attendantRepository;
	
	@GetMapping({"/lista-de-bodas"})
	public ModelAndView getAttendants() {
		ModelAndView modelAndView = new ModelAndView("/wedding-list");
		return modelAndView;
	}
	
//	@GetMapping("/nuevoAsistente")
//	public ModelAndView addAttendant() {
//		ModelAndView modelAndView = new ModelAndView("/attendants/add-attendant");
//		Attendant attendant = new Attendant();
//		modelAndView.addObject("attendant", attendant);
//		return modelAndView;
//	}
//
//	@PostMapping("/guardarNuevoAsistente")
//	public String saveAttendant (@ModelAttribute Attendant attendant) {
//		attendant.setLoggedUser(getLoggedUserService());
//		attendantRepository.save(attendant);
//		return "redirect:/asistentes";
//	}
//
//	@GetMapping("/editarAsistente")
//	public ModelAndView editAttendant (@RequestParam int attendantId) {
//		ModelAndView modelAndView = new ModelAndView("/attendants/add-attendant");
//		Attendant attendant = attendantRepository.findById(attendantId).get();
//		modelAndView.addObject("attendant", attendant);
//		return modelAndView;
//	}
//
//	@GetMapping("/eliminarAsistente")
//	public String deleteAttendant(@RequestParam int attendantId) {
//		attendantRepository.deleteById(attendantId);
//		return "redirect:/asistentes";
//	}
}