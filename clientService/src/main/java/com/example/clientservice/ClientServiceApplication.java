package com.example.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Service de gestion des clients
 * Fournit des API REST pour gérer les clients
 */
@SpringBootApplication
@RestController
public class ClientServiceApplication {

    /**
     * Point d'entrée principal de l'application
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Endpoint de base pour vérifier que le service est opérationnel
     * @return Message de confirmation
     */
    @GetMapping("/")
    public String home() {
        return "Service Client démarré avec succès - API disponible sur /clients";
    }

    /**
     * Récupère la liste de tous les clients
     * @return Liste des clients au format JSON
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

/**
 * Entité représentant un client dans le système
 */
@Entity
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private Float age;

    // Constructeur par défaut requis par JPA
    public Client() {}

    /**
     * Crée une nouvelle instance de Client
     * @param nom Nom du client
     * @param age Âge du client
     */
    public Client(String nom, Float age) {
        this.nom = nom;
        this.age = age;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public Float getAge() { return age; }
    public void setAge(Float age) { this.age = age; }
}

/**
 * Interface du repository pour l'accès aux données des clients
 */
interface ClientRepository extends JpaRepository<Client, Long> {
}
