package com.jorgealvarez.myboda.repository;

import com.jorgealvarez.myboda.model.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO: ¿crear repositorio genérico?
/*
TODO: Para los enum de status y de availability, habrá que poner un
 valor por defecto: poblema de usar el mismo satus para asistir y para pet. especiales?
*/
@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Integer>{
    List <Attendant> findByloggedUserContaining(@Param("loggedUser") String loggedUser);
}
