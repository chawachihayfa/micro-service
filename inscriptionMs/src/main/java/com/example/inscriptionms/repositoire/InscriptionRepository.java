package com.example.inscriptionms.repositoire;

import com.example.inscriptionms.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
