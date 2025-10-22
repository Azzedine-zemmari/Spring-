package com.tricol.suppliermanagement.controller;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.service.FournisseurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
