package com.tricol.suppliermanagement.controller;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.service.FournisseurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController  // This is important for JSON response
@RequestMapping("/api/v1/fournisseur")
public class FournisseurController {

    @Autowired  // Inject your service automatically
    private FournisseurServiceInterface fournisseurServiceInterface;

    @GetMapping("/all")
    public ResponseEntity<List<FournisseurModel>> getAllFournisseurs(@RequestParam(value = "societe", required = false) String societe) {
        if (societe == null || societe.isEmpty()) {
            List<FournisseurModel> fournisseurModelList = fournisseurServiceInterface.findAll();
            return ResponseEntity.ok(fournisseurModelList);
        }
            return fournisseurServiceInterface.findBySocieteContainingIgnoreCase(societe);
    }
    @GetMapping("/fournisseurs")
    public ResponseEntity<List<FournisseurModel>> getFournisseursByEndingEmail(@RequestParam(value = "emailEnding" , required = false) String emailEnding) {
        ResponseEntity<List<FournisseurModel>> fournisseurModelList = fournisseurServiceInterface.findByEmailEndingWith(emailEnding);
        return fournisseurModelList;
    }
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurModel> getById(@PathVariable("id") String id) {
        Optional<FournisseurModel> fournisseurModel = fournisseurServiceInterface.findById(id);
        return fournisseurModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/insert")
    public ResponseEntity<FournisseurModel> insert(@RequestBody FournisseurModel fournisseurModel) {
        FournisseurModel savedFournisseur = fournisseurServiceInterface.save(fournisseurModel);
        return ResponseEntity.ok(savedFournisseur);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FournisseurModel> update(@PathVariable("id") String id , @RequestBody FournisseurModel fournisseurDetails) {
        Optional<FournisseurModel> existentfournisseur = fournisseurServiceInterface.findById(id);
        if (existentfournisseur.isPresent()) {
            FournisseurModel fournisseur = existentfournisseur.get();
            fournisseur.setICE(fournisseurDetails.getICE());
            fournisseur.setAdresse(fournisseurDetails.getAdresse());
            fournisseur.setEmail(fournisseurDetails.getEmail());
            fournisseur.setSociete(fournisseurDetails.getSociete());
            fournisseur.setVille(fournisseurDetails.getVille());
            fournisseur.setContact(fournisseurDetails.getContact());

            FournisseurModel updatedFournisseur = fournisseurServiceInterface.save(fournisseur);
            return ResponseEntity.ok(updatedFournisseur);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if(fournisseurServiceInterface.findById(id).isPresent()) {
            fournisseurServiceInterface.deleteById(id);
            return ResponseEntity.ok("Fournisseur deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fournisseur with ID " + id + " not found");
    }

}
