package com.example.kaddemb.Contrat;

import com.example.kaddemb.Etudiant.Etudiants;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idContract ;

    private LocalDate ddContract ;
    private LocalDate dfContract ;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    private boolean archive;
    private Integer montantContract ;


    @ManyToOne
    Etudiants etudiants;
}

