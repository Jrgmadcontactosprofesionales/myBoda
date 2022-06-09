package com.jorgealvarez.myboda.dao;

import com.jorgealvarez.myboda.model.Attendant;
import com.jorgealvarez.myboda.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//TODO: ¿crear repositorio genérico?
/*
TODO: Para los enum de status y de availability, habrá que poner un
 valor por defecto: poblema de usar el mismo satus para asistir y para pet. especiales?
*/
@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Integer>{

}
