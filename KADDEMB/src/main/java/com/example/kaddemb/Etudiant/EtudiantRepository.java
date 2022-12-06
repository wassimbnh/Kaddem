package com.example.kaddemb.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends
        JpaRepository<Etudiants,Long> {
    @Query ("select  e from  Etudiants  e where e.nomE=:nomE and  e.prenomE=:prenomE ")
    Etudiants retriecEtudiantByNomEtPrenom (@Param("prenomE") String nomE ,
                                           @Param( "nomE") String prenomE ) ;

    @Query ("select e from Etudiants e ,Contrat c where e.idEtudiant=c.etudiants.idEtudiant and  c.archive=true and e.contrats.size>5"  )
    Etudiants retriveEtudiantOuContratInf5(@Param("idet") Long idet);


}
