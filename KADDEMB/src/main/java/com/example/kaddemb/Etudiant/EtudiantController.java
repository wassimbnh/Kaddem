package com.example.kaddemb.Etudiant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/etudiant")
public class EtudiantController {
    EtudiantService etudiantService;

    @GetMapping
    List<Etudiants> getEtudiants(){
        return etudiantService.getEtudiants();
    }
    @PostMapping(path = "add")
    Etudiants addEtudiant(@RequestBody Etudiants e){
        return etudiantService.addEtudiant(e);
    }
    @DeleteMapping(path = "delete/{ide}")
    void deleteEtudiant(@PathVariable("ide") Long ide){
        etudiantService.deleteEtudiant(ide);
    }
    @PutMapping(path = "update/{ide}")
    void updateEtudiant(@PathVariable("ide") Long ide,
                        @RequestBody Etudiants e){
        etudiantService.updateEtudiant(ide,e);

    }

}
