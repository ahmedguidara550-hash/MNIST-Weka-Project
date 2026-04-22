
# 🧠 Reconnaissance de Chiffres Manuscrits avec Machine Learning en Java

## 📝 Présentation du Projet
Ce projet est un système complet de reconnaissance de chiffres manuscrits basé sur la célèbre base de données **MNIST**. Il a été développé de zéro en **Java** dans le cadre d'un mini-projet universitaire (Niveau 1TA1) visant à mettre en pratique les concepts avancés de la Programmation Orientée Objet (POO) et du Machine Learning.

L'application permet d'entraîner des modèles d'Intelligence Artificielle à différencier les chiffres "3" et "5", puis de tester ces modèles en temps réel via une interface graphique interactive où l'utilisateur peut dessiner son propre chiffre.

## 🚀 Fonctionnalités Principales
* **Architecture Orientée Objet stricte** : Utilisation d'interfaces, de classes abstraites, de polymorphisme et d'encapsulation.
* **Traitement de Fichiers Multi-formats** : 
  * Lecture des fichiers binaires originaux MNIST (`idx3-ubyte` et `idx1-ubyte`).
  * Génération et lecture de fichiers **CSV** pour le dataset.
  * Exportation des données au format **Excel (.xlsx)** avec mise en forme conditionnelle (via Apache POI).
  * Conversion d'images **PNG** réelles en données textuelles (et inversement).
* **Machine Learning (Weka)** : 
  * Entraînement et comparaison de deux modèles : **Naive Bayes** et **Random Forest**.
  * Évaluation des performances via une validation croisée (*10-fold cross-validation*).
* **Interface Graphique Interactive (Java Swing)** : 
  * Zone de dessin libre sur une grille de 28x28 pixels.
  * Prédiction en temps réel du chiffre dessiné selon le modèle sélectionné.
* **Gestion des Erreurs Robuste** : Implémentation d'exceptions personnalisées (`InvalidMNISTFormatException`, `DimensionMismatchException`, etc.).

## 🛠️ Technologies Utilisées
* **Langage** : Java (JDK 21)
* **Bibliothèque d'Apprentissage Automatique** : [Weka](https://waikato.github.io/weka-wiki/)
* **Interface Graphique** : Java Swing
* **Manipulation Excel** : Apache POI

## ⚙️ Comment exécuter le projet ?
1. Clonez ce dépôt sur votre machine locale :
   git clone https://github.com/ahmedguidara550-hash/MNIST-Weka-Project.git
2. Ouvrez le projet dans votre IDE préféré (Eclipse, IntelliJ IDEA, etc.).
3. Assurez-vous que les bibliothèques **Weka** (`weka.jar`) et **Apache POI** sont bien ajoutées au *Build Path* de votre projet.
4. Téléchargez les fichiers binaires de la base de données MNIST et mettez à jour les chemins (`imagesPath` et `labelsPath`) dans la classe `Main.java`.
5. Exécutez la classe `Main.java`. Le programme va générer les fichiers, entraîner les modèles, puis ouvrir l'interface de dessin !

## 👨‍💻 Auteur
Développé dans le cadre du module de Programmation Orientée Objet (Java).
L'Interface Graphique :
<img width="606" height="492" alt="num3RandomForest" src="https://github.com/user-attachments/assets/6601a936-6c77-4c7f-b9ee-53334ea4af55" />
<img width="606" height="492" alt="num3NaiveBayes" src="https://github.com/user-attachments/assets/1856a16e-78ae-45d9-a79f-f962ec9afe10" />
<img width="605" height="492" alt="num5RandomForest" src="https://github.com/user-attachments/assets/f6df8c54-5e4a-4816-8f16-c41fc8690422" />
La Console :
<img width="673" height="492" alt="image" src="https://github.com/user-attachments/assets/10eaa901-52e3-4cfa-985f-b76b9271e1c2" />
Le fichier Excel :
<img width="640" height="707" alt="exceldoc" src="https://github.com/user-attachments/assets/a9de53d4-4129-41e7-b1c6-6cd8c04fc468" />
