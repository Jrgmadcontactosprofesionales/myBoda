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

import static com.jorgealvarez.myboda.service.AttendantService.getLoggedUserService;
import static com.jorgealvarez.myboda.service.AttendantService.isAdmin;

@Controller
public class AttendantController {
    //TODO: ¿crear métodos genéricos?
    @Autowired
    private AttendantRepository attendantRepository;

    @GetMapping({"/invitados"})
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

    @GetMapping("/nuevo-invitado")
    public ModelAndView addAttendant() {
        ModelAndView modelAndView = new ModelAndView("/attendants/add-attendant");
        Attendant attendant = new Attendant();
        modelAndView.addObject("attendant", attendant);
        return modelAndView;
    }

    @PostMapping("/guardar-nuevo-invitado")
    public String saveNewAttendant(@ModelAttribute Attendant attendant) {
        attendant.setLoggedUser(getLoggedUserService());
        attendantRepository.save(attendant);
        return "redirect:/invitados";
    }

    @GetMapping("/editar-invitado")
    public ModelAndView editAttendant(@RequestParam int attendantId) {
        ModelAndView modelAndView = new ModelAndView("/attendants/edit-attendant");
        Attendant attendant = attendantRepository.findById(attendantId).get();
        modelAndView.addObject("attendant", attendant);
        return modelAndView;
    }

    //TODO JORGE PEDRO: no funciona el método post. Dejado como put para salir del paso no se puede editar
    @PostMapping("/guardar-cambios-invitado")
    public String saveEditedAttendant(@ModelAttribute Attendant attendant) {
        Attendant attendantTemp = attendantRepository.findById(attendant.getId()).get();
        attendantTemp.setName(attendant.getName());
        attendantTemp.setSurname(attendant.getSurname());
        attendantTemp.setDob(attendant.getDob());
        attendantTemp.setPh(attendant.getPh());
        attendantTemp.setAttendingStatus(attendant.getAttendingStatus());
        attendantTemp.setSpecialRequirement(attendant.getSpecialRequirement());
        attendantTemp.setSpecialRequirementStatus(attendant.getSpecialRequirementStatus());
        attendantRepository.save(attendantTemp);
        return "redirect:/invitados";
    }


//    @PutMapping("/guardar-cambios-invitado/{attendantId}")
//    public String saveEditedAttendant(@PathVariable("attendantId") int attendantId,
//                                      @RequestBody Attendant attendant) {
//        Attendant attendantTemp = attendantRepository.findById(attendantId).get();
//        attendantTemp.setName(attendant.getName());
//        attendantTemp.setSurname(attendant.getSurname());
//        attendantTemp.setDob(attendant.getDob());
//        attendantTemp.setPh(attendant.getPh());
//        attendantTemp.setAttendingStatus(attendant.getAttendingStatus());
//        attendantTemp.setSpecialRequirement(attendant.getSpecialRequirement());
//        attendantTemp.setSpecialRequirementStatus(attendant.getSpecialRequirementStatus());
//        attendantRepository.save(attendant);
//        return "redirect:/asistentes";
//    }


//    @PutMapping("/guardar-cambios-invitado")
//    public String saveEditedAttendant(@RequestBody Attendant attendant) {
//        Attendant attendantTemp = attendantRepository.findById(attendant.getId()).get();
//        attendantTemp.setName(attendant.getName());
//        attendantTemp.setSurname(attendant.getSurname());
//        attendantTemp.setDob(attendant.getDob());
//        attendantTemp.setPh(attendant.getPh());
//        attendantTemp.setAttendingStatus(attendant.getAttendingStatus());
//        attendantTemp.setSpecialRequirement(attendant.getSpecialRequirement());
//        attendantTemp.setSpecialRequirementStatus(attendant.getSpecialRequirementStatus());
//        attendantRepository.save(attendant);
//        return "redirect:/asistentes";
//    }

//    @PutMapping("/guardar-cambios-invitado/{attendantId}")
//    public String saveEditedAttendant(@PathVariable(value = "attendantId") int attendantId, @Valid @RequestBody Attendant attendantNewDetails) throws ResourceNotFoundException {
//        Attendant attendant = attendantRepository.findById(attendantId)
//                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado ningún asistente con este id :: " + attendantId));
//        attendant.setName(attendantNewDetails.getName());
//        attendant.setSurname(attendantNewDetails.getSurname());
//        attendant.setDob(attendantNewDetails.getDob());
//        attendant.setPh(attendantNewDetails.getPh());
//        attendant.setAttendingStatus(attendantNewDetails.getAttendingStatus());
//        attendant.setSpecialRequirement(attendantNewDetails.getSpecialRequirement());
//        attendant.setSpecialRequirementStatus(attendantNewDetails.getSpecialRequirementStatus());
//        attendantRepository.save(attendant);
//        return "redirect:/asistentes";
//    }

//    @GetMapping("/guardar-cambios-invitado/{attendantId}")
//    public String saveEditedAttendant(@RequestParam int attendantId, @RequestBody Attendant attendantNewDetails) {
//        attendantRepository.save(attendantRepository.findById(attendantNewDetails.getId()).get());
//        return "redirect:/asistentes";
//    }


    @GetMapping("/eliminar-invitado")
    public String deleteAttendant(@RequestParam int attendantId) {
        attendantRepository.deleteById(attendantId);
        return "redirect:/invitados";
    }
}
