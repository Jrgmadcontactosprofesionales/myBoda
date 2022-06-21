package com.jorgealvarez.myboda.controller;

import com.jorgealvarez.myboda.model.Attendant;
import com.jorgealvarez.myboda.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String saveNewAttendant(@ModelAttribute Attendant attendant) {
        attendant.setLoggedUser(getLoggedUserService());
        attendantRepository.save(attendant);
        return "redirect:/asistentes";
    }

    @GetMapping("/editar-asistente")
    public ModelAndView editAttendant(@RequestParam int attendantId) {
        ModelAndView modelAndView = new ModelAndView("/attendants/edit-attendant");
        Attendant attendant = attendantRepository.findById(attendantId).get();
        modelAndView.addObject("attendant", attendant);
        return modelAndView;
    }

    //TODO JORGE PEDRO: no funciona el método post y no se puede editar
    @PutMapping("/guardar-cambios-asistente")
    public String saveEditedAttendant(@RequestBody Attendant attendant) {
        Attendant attendantTemp = attendantRepository.findById(attendant.getId()).get();
        attendantTemp.setName(attendant.getName());
        attendantTemp.setSurname(attendant.getSurname());
        attendantTemp.setDob(attendant.getDob());
        attendantTemp.setPh(attendant.getPh());
        attendantTemp.setAttendingStatus(attendant.getAttendingStatus());
        attendantTemp.setSpecialRequirement(attendant.getSpecialRequirement());
        attendantTemp.setSpecialRequirementStatus(attendant.getSpecialRequirementStatus());
        attendantRepository.save(attendantTemp);
        return "redirect:/asistentes";
    }


//    @PutMapping("/guardar-cambios-asistente/{attendantId}")
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


//    @PutMapping("/guardar-cambios-asistente")
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

//    @PutMapping("/guardar-cambios-asistente/{attendantId}")
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

//    @GetMapping("/guardar-cambios-asistente/{attendantId}")
//    public String saveEditedAttendant(@RequestParam int attendantId, @RequestBody Attendant attendantNewDetails) {
//        attendantRepository.save(attendantRepository.findById(attendantNewDetails.getId()).get());
//        return "redirect:/asistentes";
//    }


    @GetMapping("/eliminar-asistente")
    public String deleteAttendant(@RequestParam int attendantId) {
        attendantRepository.deleteById(attendantId);
        return "redirect:/asistentes";
    }
}
