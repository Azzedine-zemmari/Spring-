package com.tricol.suppliermanagement.service;

import com.tricol.suppliermanagement.model.FournisseurModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface  FournisseurServiceInterface {
    FournisseurModel save(FournisseurModel fournisseurModel);
    Optional<FournisseurModel> findById(String id);
    List<FournisseurModel> findAll();
    void deleteById(String id);

    ResponseEntity<List<FournisseurModel>> findBySocieteContainingIgnoreCase(String name);
}
