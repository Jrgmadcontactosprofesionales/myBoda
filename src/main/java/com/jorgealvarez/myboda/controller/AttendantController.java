package com.jorgealvarez.myboda.controller;

import com.jorgealvarez.myboda.dao.AttendantRepository;
import com.jorgealvarez.myboda.dao.EmployeeRepository;
import com.jorgealvarez.myboda.model.Attendant;
import com.jorgealvarez.myboda.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendantController {
	//TODO: ¿crear métodos genéricos?
	@Autowired
	private AttendantRepository attendantRepository;
	
	@GetMapping({"/asistentes"})
	public ModelAndView getAttendants() {
		ModelAndView modelAndView = new ModelAndView("list-attendants");
		modelAndView.addObject("attendants", attendantRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/nuevoAsistente")
	public ModelAndView addAttendant() {
		ModelAndView modelAndView = new ModelAndView("add-attendant");
		Attendant attendant = new Attendant();
		modelAndView.addObject("attendant", attendant);
		return modelAndView;
	}
	
	@PostMapping("/guardarNuevoAsistente")
	public String saveAttendant (@ModelAttribute Attendant attendant) {
		attendantRepository.save(attendant);
		return "redirect:/asistentes";
	}
	
	@GetMapping("/editarAsistente")
	public ModelAndView editAttendant (@RequestParam int attendantId) {
		ModelAndView modelAndView = new ModelAndView("edit-attendant");
		Attendant attendant = attendantRepository.findById(attendantId).get();
		modelAndView.addObject("attendant", attendant);
		return modelAndView;
	}
	
	@GetMapping("/eliminarAsistente")
	public String deleteAttendant(@RequestParam int attendantId) {
		attendantRepository.deleteById(attendantId);
		return "redirect:/asistentes";
	}
}
