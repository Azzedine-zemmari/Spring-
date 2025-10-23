package com.tricol.suppliermanagement.service;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.repository.FournisseurRepositoryInterface;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class FournisseurService  implements FournisseurServiceInterface {
    private FournisseurRepositoryInterface fournisseurRepository;

    public void setFournisseurRepository(FournisseurRepositoryInterface fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurModel save(FournisseurModel fournisseurModel) {
       return fournisseurRepository.save(fournisseurModel);
    }
    @Override
    public Optional<FournisseurModel> findById(String id){
        return fournisseurRepository.findById(id);
    }
    @Override
    public List<FournisseurModel> findAll(){
        return fournisseurRepository.findAll();
    }
    @Override
    public void deleteById(String id){
        fournisseurRepository.deleteById(id);
    }
    @Override
    public ResponseEntity<List<FournisseurModel>> findBySocieteContainingIgnoreCase(String name){
        List<FournisseurModel> result = fournisseurRepository.findBySocieteContainingIgnoreCase(name);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
    @Override
    public ResponseEntity<List<FournisseurModel>> findByEmailEndingWith(String emailEnding){
        List<FournisseurModel> result = fournisseurRepository.findByEmailEndingWith(emailEnding);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }


}