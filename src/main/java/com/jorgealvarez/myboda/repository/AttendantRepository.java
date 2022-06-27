package com.jorgealvarez.myboda.repository;

import com.jorgealvarez.myboda.model.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Integer> {
    List<Attendant> findByloggedUserContaining(@Param("loggedUser") String loggedUser);
}
