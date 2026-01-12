package com.example.voitureservice;

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
 * Service de gestion des véhicules
 * Fournit des API REST pour gérer les véhicules des clients
 */
@SpringBootApplication
@RestController
public class VoitureServiceApplication {

    /**
     * Point d'entrée principal de l'application
     */
    public static void main(String[] args) {
        SpringApplication.run(VoitureServiceApplication.class, args);
    }

    @Autowired
    private VoitureRepository voitureRepository;

    /**
     * Endpoint de base pour vérifier que le service est opérationnel
     * @return Message de confirmation
     */
    @GetMapping("/")
    public String home() {
        return "Service Voiture démarré avec succès - API disponible sur /voitures";
    }

    /**
     * Récupère la liste de tous les véhicules
     * @return Liste des véhicules au format JSON
     */
    @GetMapping("/voitures")
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }
}

/**
 * Entité représentant un véhicule dans le système
 */
@Entity
class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marque;    // Marque du véhicule (ex: Renault, Peugeot)
    private String matricule; // Numéro d'immatriculation
    private String model;     // Modèle du véhicule
    private Long id_client;   // Référence au propriétaire du véhicule

    // Constructeur par défaut requis par JPA
    public Voiture() {}

    /**
     * Crée une nouvelle instance de Voiture
     * @param marque Marque du véhicule
     * @param matricule Numéro d'immatriculation
     * @param model Modèle du véhicule
     * @param id_client Identifiant du propriétaire
     */
    public Voiture(String marque, String matricule, String model, Long id_client) {
        this.marque = marque;
        this.matricule = matricule;
        this.model = model;
        this.id_client = id_client;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public Long getId_client() { return id_client; }
    public void setId_client(Long id_client) { this.id_client = id_client; }
}

/**
 * Interface du repository pour l'accès aux données des véhicules
 */
interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
