package tn.esprit.clientms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.clientms.client.CoursClient;
import tn.esprit.clientms.dto.CoursDto;
import tn.esprit.clientms.entity.Client;
import tn.esprit.clientms.repositoire.ClientRepository;

import java.util.List;

@Service
public class clientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CoursClient coursClient;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getclientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client inscription) {
        return clientRepository.save(inscription);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    //OpenFeign
    public CoursDto getCoursID(long inscriptionid) {
        Client client = clientRepository.findById(inscriptionid).orElseThrow(() -> new RuntimeException("client not found"));
        CoursDto coursDto = coursClient.getCourseById(client.getCourseId());
        return coursDto;
    }
}
