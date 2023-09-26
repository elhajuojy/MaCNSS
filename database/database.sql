-- DATABASE MACNSS
DROP DATABASE IF EXISTS MACNSS;
CREATE DATABASE MACNSS;
USE MACNSS;


CREATE TABLE administrateurs (email CHAR (55), password CHAR(55));

-- agent
CREATE TABLE agents (email CHAR (55), password CHAR(55), codeVerification VARCHAR(250));

-- analysis
CREATE TABLE patients (email CHAR (55), password CHAR(55),nom CHAR(55), matricule VARCHAR(250) PRIMARY KEY NOT NULL );

-- dossier
CREATE  TABLE dossiers (numDossier VARCHAR(123) PRIMARY KEY NOT NULL , status CHAR(55), totalRemboursement FLOAT, matricule VARCHAR(123), FOREIGN KEY(matricule) REFERENCES patients(matricule),  FOREIGN KEY (`matricule`) REFERENCES `patients`(`matricule`) ON DELETE CASCADE ON UPDATE CASCADE);

-- fichier
CREATE TABLE analyse (analyseId BIGINT PRIMARY KEY,prix FLOAT,description VARCHAR(255),dossierNum VARCHAR(255),FOREIGN KEY (dossierNum)  REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);

-- patient
CREATE TABLE fichiers (numeroFichier BIGINT PRIMARY KEY, dateDepot DATE,TotalFraisDossier FLOAT, specialite VARCHAR(123),dossierNum VARCHAR(123),FOREIGN
    KEY(dossierNum) REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);

-- medicine
CREATE TABLE medicament (codeBarre BIGINT PRIMARY KEY, quantite INT(123), prix FLOAT, dossierNum VARCHAR(123), FOREIGN KEY(dossierNum) REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);

-- reimbursement
CREATE TABLE remboursement (specialite VARCHAR(100) PRIMARY KEY,trMedicament FLOAT,pbMedicament FLOAT,trAnalyse FLOAT, pbAnalyse FLOAT,trRadio FLOAT,pbRadio FLOAT,trScanner FLOAT,pbScanner FLOAT,trVisisteSpecialiste FLOAT,pbVisiteSpecialiste FLOAT,trVisiteGeneratrice FLOAT,pbVisiteGeneratrice FLOAT);

-- visit
CREATE TABLE Visite(visiteId BIGINT PRIMARY KEY,prix FLOAT,description VARCHAR(255),dossierNum VARCHAR(255),FOREIGN KEY (dossierNum)  REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);

-- radio
CREATE TABLE radio(radioId BIGINT PRIMARY KEY,prix FLOAT,description VARCHAR(255),dossierNum VARCHAR(255),FOREIGN KEY (dossierNum) REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);

-- scanner
CREATE TABLE scanner(scannerId BIGINT PRIMARY KEY,prix FLOAT,description VARCHAR(255),dossierNum VARCHAR(255),FOREIGN KEY (dossierNum) REFERENCES dossiers(numDossier) ON DELETE CASCADE ON UPDATE CASCADE);