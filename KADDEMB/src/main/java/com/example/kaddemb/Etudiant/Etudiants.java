package com.example.kaddemb.Etudiant;

import com.example.kaddemb.Contrat.Contrat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor

@RequiredArgsConstructor
@Getter
@Setter
public class Etudiants implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant ;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    option ppt;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiants")
    private Set<Contrat> contrats;
}

