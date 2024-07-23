package tn.esprit.clientms.repositoire;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.clientms.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
