package com.example.kaddemb.Contrat;

import com.example.kaddemb.Etudiant.EtudiantRepository;
import com.example.kaddemb.Etudiant.Etudiants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratService {
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
    public List<Contrat> getContrats() {
        return contratRepository.findAll();
    }

    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    public void updateContrat(Contrat c, Long idc) {
        Contrat contrat =contratRepository.findById(idc).orElse(null);
        contrat.setDdContract(c.getDdContract());
        contrat.setDfContract(c.getDfContract());
        contrat.setSpecialite(c.getSpecialite());
        contrat.setArchive(c.isArchive());
        contrat.setMontantContract(c.getMontantContract());

        contratRepository.save(contrat);
    }

    public void deleteContrat(Long idc) {
        contratRepository.deleteById(idc);
    }

    public Contrat affectContratToEtudiant(Long idCont,
                                          Long idEt) {
       Etudiants etudiants= etudiantRepository.
               findById(idEt).orElse(null);
        Contrat contrat =contratRepository.findById(idCont).orElse(null);
        contrat.setEtudiants(etudiants);


         etudiantRepository.save(etudiants);
        return null;

    }

    public Integer nbContratsNonArchivee() {
        int nb=0 ;
        List<Contrat> c =contratRepository.retriveArchiveContratFalse();
        nb=c.size();
        return nb;
    }

    public Integer nbContratsArchivee() {
        int nbc=0 ;
        List<Contrat> c =contratRepository.retriveArchiveContratTrue();
        nbc=c.size();
        return nbc;
    }

    public Period dureeContrat(Long idC) {
        LocalDate deb,fin;
        Contrat contrat =contratRepository.findById(idC).orElse(null);
        deb=contrat.getDdContract();
        fin=contrat.getDfContract();


        Period period= Period.between(deb,fin);
        return period;


    }

    public Period dureeResteeContrat(Long idC) {
        LocalDate df,now;
        Contrat contrat =contratRepository.findById(idC).orElse(null);
        df=contrat.getDfContract();
        now=LocalDate.now();
        Period period=Period.between(now,df);
        return period;
    }



}
