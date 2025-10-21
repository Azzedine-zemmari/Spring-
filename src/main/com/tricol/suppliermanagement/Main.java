package com.tricol.suppliermanagement;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.service.FournisseurServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");
        FournisseurServiceInterface fournisseurService = context.getBean("fournisseurService", FournisseurServiceInterface.class);

        // Create
        FournisseurModel fournisseur = new FournisseurModel();
        String id = UUID.randomUUID().toString();
        fournisseur.setId(id);
        fournisseur.setICE("ICE123");
        fournisseur.setSociete("Test Soc");
        fournisseur.setAdresse("123 Test St");
        fournisseur.setContact("123-456");
        fournisseur.setEmail("test@example.com");
        fournisseur.setVille("Test City");
        fournisseurService.save(fournisseur);
        System.out.println("Saved: " + fournisseur.getId());

        // Read by ID
        Optional<FournisseurModel> found = fournisseurService.findById(id);
        found.ifPresent(f -> System.out.println("Found: " + f.getSociete()));

        // Read all
        List<FournisseurModel> all = fournisseurService.findAll();
        System.out.println("All fournisseurs: " + all.size());

        // Update
        found.ifPresent(f -> {
            f.setSociete("Updated Soc");
            fournisseurService.save(f);
            System.out.println("Updated: " + f.getSociete());
        });

        // Delete
//        fournisseurService.deleteById(id);
//        System.out.println("Deleted");
    }
}