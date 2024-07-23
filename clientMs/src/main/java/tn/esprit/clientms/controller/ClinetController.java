package tn.esprit.clientms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.clientms.dto.CoursDto;
import tn.esprit.clientms.entity.Client;
import tn.esprit.clientms.service.clientService;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClinetController {
    @Autowired
    private clientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getInscriptionById(@PathVariable Long id) {
        Client client = clientService.getclientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/course")
    public ResponseEntity<CoursDto> getCoursByInscriptionId(@PathVariable Long id) {
        CoursDto coursDto = clientService.getCoursID(id);
        return ResponseEntity.ok(coursDto);
    }
}
