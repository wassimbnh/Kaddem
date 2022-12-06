package com.example.kaddemb.Contrat;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/contrat")
public class ContratController {
    ContratService contratService;
    @GetMapping
    List<Contrat> getContrats(){
        return contratService.getContrats();
    }
    @PostMapping(path = "add")
    Contrat addContrat(@RequestBody Contrat c){
        return contratService.addContrat(c);
    }
    @PutMapping(path = "update/{idc}")
    void updateContrat(@RequestBody Contrat c,
                          @PathVariable("idc") Long idc){
         contratService.updateContrat(c,idc);
    }
    @DeleteMapping(path = "delete/{idc}")
    void deleteContrat(@PathVariable("idc") Long idc){
        contratService.deleteContrat(idc);
    }


@PutMapping(path = "affectContratToEtudiant/{idCont}/{idEt}")
    Contrat affectContratToEtudiant (@PathVariable("idCont") Long idCont ,
                                    @PathVariable("idEt") Long idEt
                                     ){

        return  contratService.affectContratToEtudiant(idCont,idEt);
    }


    @GetMapping(path = "nbContratNonArchivee")
public Integer nbContratsNonArchivee(){
        return  contratService.nbContratsNonArchivee();

    }

    @GetMapping(path = "nbContratArchivee")
    public Integer nbContratsArchivee(){
        return  contratService.nbContratsArchivee();

    }
    @GetMapping(path = "dureeContrat/{idC}")
    public Period dureeContrat(@PathVariable("idC") Long idC){
         return contratService.dureeContrat(idC);
    }
@GetMapping(path ="dureeResteeContrat/{idC}" )
public Period dureeResteeContrat(@PathVariable("idC") Long idC){
        return contratService.dureeResteeContrat(idC);
}





}

