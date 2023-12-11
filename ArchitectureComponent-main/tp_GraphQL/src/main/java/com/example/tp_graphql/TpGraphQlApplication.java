package com.example.tp_graphql;

import com.example.tp_graphql.Model.Centre;
import com.example.tp_graphql.Model.Etudiant;
import com.example.tp_graphql.Repository.CentreRepository;
import com.example.tp_graphql.Repository.EtudiantRepository;
import com.example.tp_graphql.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpGraphQlApplication implements CommandLineRunner {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpGraphQlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Centre centre1 = Centre.builder()
                .nom("Maarif").adress("Biranzarane").build();
        centreRepository.save(centre1);
        Centre centre2 = Centre.builder()
                .nom("adnani").adress("ahmad").build();
        centreRepository.save(centre2);
        Etudiant et1 = Etudiant.builder()
                .nom("Adnani").prenom("oussama").genre(Genre.Homme)
                .centre(centre1).build();
        Etudiant et2 = Etudiant.builder()
                .nom("karam").prenom("achraf").genre(Genre.Homme)
                .centre(centre1).build();
        etudiantRepository.save(et1);
        etudiantRepository.save(et2);

    }
}
