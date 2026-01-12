# Application de Gestion de Flotte Automobile

## Description
Ce projet est une application microservices pour la gestion d'une flotte automobile, composée de trois services principaux :

1. **Service Client** : Gère les informations des clients
2. **Service Voiture** : Gère les informations des véhicules
3. **Service Gateway** : Point d'entrée unique pour l'API

## Architecture

```
┌─────────────────┐     ┌──────────────────┐     ┌─────────────────┐
│                 │     │                  │     │                 │
│  Client Web/App │ ◄──►│  API Gateway     │ ◄───┤  Service Client  │
│                 │     │  (Spring Cloud)  │     │                 │
└─────────────────┘     └──────────────────┘     └─────────────────┘                                      
                                    │
                                    ▼
                          ┌──────────────────┐
                          │                  │
                          │  Service Voiture │
                          │                  │
                          └──────────────────┘
```

## Prérequis

- Java 17 ou supérieur
- Maven 3.8+
- Docker 20.10+
- Docker Compose 2.0+

## Services

### 1. Service Client
- **Port** : 8081
- **Endpoints** :
  - `GET /` : Vérification du statut du service
  - `GET /clients` : Liste tous les clients

### 2. Service Voiture
- **Port** : 8082
- **Endpoints** :
  - `GET /` : Vérification du statut du service
  - `GET /voitures` : Liste toutes les voitures

### 3. API Gateway
- **Port** : 8080
- **Routes** :
  - `/clients/**` : Routé vers le Service Client
  - `/voitures/**` : Routé vers le Service Voiture

## Installation et Démarrage

1. **Cloner le dépôt** :
   ```bash
   git clone [URL_DU_REPO]
   cd Conteneurisation-des-Microservices-avec-Docker-main
   ```

2. **Construire les images Docker** :
   ```bash
   docker-compose build
   ```

3. **Démarrer les services** :
   ```bash
   docker-compose up -d
   ```

4. **Vérifier les conteneurs en cours d'exécution** :
   ```bash
   docker ps
   ```

## Accès aux services

- **API Gateway** : http://localhost:8080
- **Service Client** : http://localhost:8081
- **Service Voiture** : http://localhost:8082

## Structure des dossiers

```
.
├── clientService/          # Service de gestion des clients
├── voitureService/         # Service de gestion des véhicules
├── gatewayService/         # Service Gateway (API Gateway)
├── dockerfiles/            # Fichiers Docker pour chaque service
├── docs/                   # Documentation supplémentaire
└── docker-compose.yml      # Configuration Docker Compose
```

## Développement

### Reconstruire un service spécifique
```bash
docker-compose up -d --build [nom_du_service]
```

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## Auteur

[Votre Nom] - [Votre Email]
