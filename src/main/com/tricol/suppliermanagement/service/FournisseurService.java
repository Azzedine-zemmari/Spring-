package com.tricol.suppliermanagement.service;

import com.tricol.suppliermanagement.model.FournisseurModel;
import com.tricol.suppliermanagement.repository.FournisseurRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class FournisseurService  implements FournisseurServiceInterface {
    private FournisseurRepositoryInterface fournisseurRepository;

    public void setFournisseurRepository(FournisseurRepositoryInterface fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public void save(FournisseurModel fournisseurModel) {
        fournisseurRepository.save(fournisseurModel);
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


}