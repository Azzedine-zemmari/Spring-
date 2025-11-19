# 🧵 Tricol – Module de Gestion des Fournisseurs
*Première étape du système de gestion des approvisionnements*

## 📌 Contexte du Projet
Tricol est une entreprise spécialisée dans la conception et la fabrication de vêtements professionnels.  
L’entreprise souhaite digitaliser ses processus internes avec une application de gestion des approvisionnements.

Cette première phase se concentre sur la **gestion des fournisseurs**, posant les bases pour les futures fonctionnalités : produits, commandes et stocks.

---

## 🎯 Objectif
Développer une application Java basée sur **Spring Core** permettant :
- Gestion complète des fournisseurs
- Architecture évolutive et en couches (Controller / Service / Repository)
- Utilisation correcte du conteneur IoC et des Spring Beans
- Configuration Spring via XML, annotations et Java Config

---

## 🧩 Exigences Fonctionnelles

### ✔ Gestion des Fournisseurs
| Fonctionnalité | Description |
|----------------|-------------|
| ➕ Ajouter un fournisseur | Enregistrer un fournisseur : société, adresse, contact, email, téléphone, ville, ICE |
| ✏️ Modifier un fournisseur | Mettre à jour les informations existantes |
| 🗑 Supprimer un fournisseur | Retirer un fournisseur du système |
| 📄 Consulter la liste | Afficher tous les fournisseurs, tri possible par nom |

---

## 🛠️ Exigences Techniques

### 🔧 Technologies et Concepts Spring Core
- Java + Spring Core  
- Conteneur IoC (Inversion of Control)  
- Spring Beans & Scopes  
- ApplicationContext & BeanFactory  
- Configuration Spring :
  - XML
  - Annotations (`@Component`, `@Service`, `@Repository`)
  - Java Config (`@Configuration`, `@Bean`)  
- Component Scanning

### 🏗 Architecture en Couches
- **Controller** : expose les endpoints REST  
- **Service** : logique métier  
- **Repository** : accès aux données via Spring Data JPA  

### 🗂 Persistance
- Requêtes standard auto-générées : `findAll()`, `findById()`, `count()`  
- Query Methods personnalisées : `findByNom(...)`, `findByEmailEndingWith(...)`  

---

## 🌐 API REST – Endpoints Fournisseurs

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| **GET** | `/api/v1/fournisseurs` | Liste des fournisseurs |
| **GET** | `/api/v1/fournisseurs/{id}` | Voir un fournisseur spécifique |
| **POST** | `/api/v1/fournisseurs` | Ajouter un fournisseur |
| **PUT** | `/api/v1/fournisseurs/{id}` | Modifier un fournisseur |
| **DELETE** | `/api/v1/fournisseurs/{id}` | Supprimer un fournisseur |

---
