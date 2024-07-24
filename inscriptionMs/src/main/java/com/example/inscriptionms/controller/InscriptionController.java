package com.example.inscriptionms.controller;

import com.example.inscriptionms.dto.CoursDto;
import com.example.inscriptionms.entity.Inscription;
import com.example.inscriptionms.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscriptions")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getInscriptionById(@PathVariable Long id) {
        Inscription inscription = inscriptionService.getInscriptionById(id);
        return ResponseEntity.ok(inscription);
    }

    @PostMapping
    public Inscription createInscription(@RequestBody Inscription inscription) {
        return inscriptionService.createInscription(inscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscription> updateInscription(@PathVariable Long id, @RequestBody Inscription inscriptionDetails) {
        Inscription updatedInscription = inscriptionService.updateInscription(id, inscriptionDetails);
        return ResponseEntity.ok(updatedInscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/course")
    public ResponseEntity<CoursDto> getCoursByInscriptionId(@PathVariable Long id) {
        CoursDto coursDto = inscriptionService.getCoursID(id);
        return ResponseEntity.ok(coursDto);
    }
}

