package com.example.inscriptionms.service;

import com.example.inscriptionms.client.CoursClient;
import com.example.inscriptionms.dto.CoursDto;
import com.example.inscriptionms.entity.Inscription;
import com.example.inscriptionms.repositoire.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private CoursClient coursClient;

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    public Inscription createInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public Inscription updateInscription(Long id, Inscription inscriptionDetails) {
        Inscription inscription = inscriptionRepository.findById(id).orElse(null);
        if (inscription != null) {
            return inscriptionRepository.save(inscription);
        }
        return null;
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    //OpenFeign
    public CoursDto getCoursID(long inscriptionid) {
        Inscription inscription = inscriptionRepository.findById(inscriptionid).orElseThrow(() -> new RuntimeException("inscription not found"));
        CoursDto coursDto = coursClient.getCourseById(inscription.getCourseId());
        return coursDto;
}
}
