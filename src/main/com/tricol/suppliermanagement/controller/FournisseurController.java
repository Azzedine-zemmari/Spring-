package com.tricol.suppliermanagement.controller;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.service.FournisseurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<FournisseurModel>> getAllFournisseurs() {
        List<FournisseurModel> fournisseurModelList = fournisseurServiceInterface.findAll();
        return ResponseEntity.ok(fournisseurModelList);
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

}
