package com.tricol.suppliermanagement.repository;

import com.tricol.suppliermanagement.model.FournisseurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurRepositoryInterface extends JpaRepository<FournisseurModel, String> {

    List<FournisseurModel> findBySocieteContainingIgnoreCase(@Param("societe") String societe);
}
