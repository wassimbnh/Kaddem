package com.example.kaddemb.Contrat;

import com.example.kaddemb.Contrat.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends
        JpaRepository<Contrat,Long> {

@Query("select c from Contrat c where c.archive=False")
List<Contrat>retriveArchiveContratFalse();

    @Query("select c from Contrat c where c.archive=True")
    List<Contrat>retriveArchiveContratTrue();


}
