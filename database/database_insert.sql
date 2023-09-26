INSERT INTO administrateurs (email, password)
VALUES
    ('admin1@example.com', 'password1'),
    ('admin2@example.com', 'password2'),
    ('admin3@example.com', 'password3'),
    ('admin4@example.com', 'password4'),
    ('admin5@example.com', 'password5'),
    ('admin6@example.com', 'password6'),
    ('admin7@example.com', 'password7'),
    ('admin8@example.com', 'password8'),
    ('admin9@example.com', 'password9'),
    ('admin10@example.com', 'password10');

INSERT INTO agents (email, password, codeVerification)
VALUES
    ('agent1@example.com', 'password1', 'code1'),
    ('agent2@example.com', 'password2', 'code2'),
    ('agent3@example.com', 'password3', 'code3'),
    ('agent4@example.com', 'password4', 'code4'),
    ('agent5@example.com', 'password5', 'code5'),
    ('agent6@example.com', 'password6', 'code6'),
    ('agent7@example.com', 'password7', 'code7'),
    ('agent8@example.com', 'password8', 'code8'),
    ('agent9@example.com', 'password9', 'code9'),
    ('agent10@example.com', 'password10', 'code10');

INSERT INTO patients (email, password, nom, matricule)
VALUES
    ('patient1@example.com', 'password1', 'Patient 1', '12345'),
    ('patient2@example.com', 'password2', 'Patient 2', '67890'),
    ('patient3@example.com', 'password3', 'Patient 3', '13579'),
    ('patient4@example.com', 'password4', 'Patient 4', '24680'),
    ('patient5@example.com', 'password5', 'Patient 5', '98765'),
    ('patient6@example.com', 'password6', 'Patient 6', '54321'),
    ('patient7@example.com', 'password7', 'Patient 7', '11111'),
    ('patient8@example.com', 'password8', 'Patient 8', '22222'),
    ('patient9@example.com', 'password9', 'Patient 9', '33333'),
    ('patient10@example.com', 'password10', 'Patient 10', '44444');

INSERT INTO dossiers (numDossier, status, totalRemboursement, matricule)
VALUES
    ('Dossier1', 'Pending', 100.00, '12345'),
    ('Dossier2', 'Approved', 250.00, '67890'),
    ('Dossier3', 'Rejected', 50.00, '13579'),
    ('Dossier4', 'Approved', 300.00, '24680'),
    ('Dossier5', 'Pending', 75.00, '98765'),
    ('Dossier6', 'Rejected', 120.00, '54321'),
    ('Dossier7', 'Approved', 200.00, '11111'),
    ('Dossier8', 'Pending', 180.00, '22222'),
    ('Dossier9', 'Rejected', 90.00, '33333'),
    ('Dossier10', 'Approved', 220.00, '44444');


INSERT INTO analyse (analyseId, prix, description, dossierNum)
VALUES
    (1, 50.00, 'Analysis 1', 'Dossier1'),
    (2, 75.00, 'Analysis 2', 'Dossier2'),
    (3, 60.00, 'Analysis 3', 'Dossier3'),
    (4, 80.00, 'Analysis 4', 'Dossier4'),
    (5, 45.00, 'Analysis 5', 'Dossier5'),
    (6, 55.00, 'Analysis 6', 'Dossier6'),
    (7, 70.00, 'Analysis 7', 'Dossier7'),
    (8, 65.00, 'Analysis 8', 'Dossier8'),
    (9, 90.00, 'Analysis 9', 'Dossier9'),
    (10, 85.00, 'Analysis 10', 'Dossier10');

INSERT INTO fichiers (numeroFichier, dateDepot, TotalFraisDossier, specialite, dossierNum)
VALUES
    (1, '2023-09-23', 150.00, 'Specialty 1', 'Dossier1'),
    (2, '2023-09-24', 200.00, 'Specialty 2', 'Dossier2'),
    (3, '2023-09-25', 125.00, 'Specialty 3', 'Dossier3'),
    (4, '2023-09-26', 180.00, 'Specialty 4', 'Dossier4'),
    (5, '2023-09-27', 220.00, 'Specialty 5', 'Dossier5'),
    (6, '2023-09-28', 95.00, 'Specialty 6', 'Dossier6'),
    (7, '2023-09-29', 120.00, 'Specialty 7', 'Dossier7'),
    (8, '2023-09-30', 175.00, 'Specialty 8', 'Dossier8'),
    (9, '2023-10-01', 140.00, 'Specialty 9', 'Dossier9'),
    (10, '2023-10-02', 160.00, 'Specialty 10', 'Dossier10');

INSERT INTO medicament (codeBarre, quantite, prix, dossierNum)
VALUES
    (12345, 5, 20.00, 'Dossier1'),
    (67890, 10, 15.00, 'Dossier2'),
    (13579, 8, 12.50, 'Dossier3'),
    (24680, 6, 18.00, 'Dossier4'),
    (98765, 12, 10.00, 'Dossier5'),
    (54321, 7, 22.00, 'Dossier6'),
    (11111, 4, 25.00, 'Dossier7'),
    (22222, 9, 14.00, 'Dossier8'),
    (33333, 11, 16.50, 'Dossier9'),
    (44444, 5, 21.00, 'Dossier10');

INSERT INTO remboursement (specialite, trMedicament, pbMedicament, trAnalyse, pbAnalyse, trRadio, pbRadio, trScanner, pbScanner, trVisisteSpecialiste, pbVisiteSpecialiste, trVisiteGeneratrice, pbVisiteGeneratrice)
VALUES
    ('Specialty 1', 10.00, 5.00, 15.00, 8.00, 20.00, 10.00, 25.00, 12.00, 30.00, 15.00, 35.00, 18.00),
    ('Specialty 2', 12.00, 6.00, 18.00, 9.00, 24.00, 12.00, 30.00, 14.00, 36.00, 18.00, 42.00, 20.00),
    ('Specialty 3', 8.00, 4.00, 12.00, 6.00, 16.00, 8.00, 20.00, 10.00, 24.00, 12.00, 28.00, 14.00),
    ('Specialty 4', 15.00, 7.50, 22.50, 11.25, 30.00, 15.00, 37.50, 18.75, 45.00, 22.50, 52.50, 26.25),
    ('Specialty 5', 9.00, 4.50, 13.50, 6.75, 18.00, 9.00, 22.50, 11.25, 27.00, 13.50, 31.50, 15.75),
    ('Specialty 6', 11.00, 5.50, 16.50, 8.25, 22.00, 11.00, 27.50, 13.75, 33.00, 16.50, 38.50, 19.25),
    ('Specialty 7', 13.00, 6.50, 19.50, 9.75, 26.00, 13.00, 32.50, 16.25, 39.00, 19.50, 45.50, 22.75),
    ('Specialty 8', 10.00, 5.00, 15.00, 7.50, 20.00, 10.00, 25.00, 12.50, 30.00, 15.00, 35.00, 17.50),
    ('Specialty 9', 14.00, 7.00, 21.00, 10.50, 28.00, 14.00, 35.00, 17.50, 42.00, 21.00, 49.00, 24.50),
    ('Specialty 10', 16.00, 8.00, 24.00, 12.00, 32.00, 16.00, 40.00, 20.00, 48.00, 24.00, 56.00, 28.00);

INSERT INTO Visite (visiteId, prix, description, dossierNum)
VALUES
    (1, 40.00, 'Visit 1', 'Dossier1'),
    (2, 55.00, 'Visit 2', 'Dossier2'),
    (3, 45.00, 'Visit 3', 'Dossier3'),
    (4, 60.00, 'Visit 4', 'Dossier4'),
    (5, 50.00, 'Visit 5', 'Dossier5'),
    (6, 70.00, 'Visit 6', 'Dossier6'),
    (7, 75.00, 'Visit 7', 'Dossier7'),
    (8, 65.00, 'Visit 8', 'Dossier8'),
    (9, 80.00, 'Visit 9', 'Dossier9'),
    (10, 85.00, 'Visit 10', 'Dossier10');

INSERT INTO radio (radioId, prix, description, dossierNum)
VALUES
    (1, 60.00, 'X-ray 1', 'Dossier1'),
    (2, 80.00, 'CT Scan 1', 'Dossier2'),
    (3, 65.00, 'MRI 1', 'Dossier3'),
    (4, 70.00, 'Ultrasound 1', 'Dossier4'),
    (5, 75.00, 'X-ray 2', 'Dossier5'),
    (6, 90.00, 'CT Scan 2', 'Dossier6'),
    (7, 55.00, 'MRI 2', 'Dossier7'),
    (8, 75.00, 'Ultrasound 2', 'Dossier8'),
    (9, 70.00, 'X-ray 3', 'Dossier9'),
    (10, 85.00, 'CT Scan 3', 'Dossier10');

INSERT INTO  scanner (scannerId, prix, description, dossierNum)

VALUES
    (1, 60.00, 'X-ray 1', 'Dossier1'),
    (2, 80.00, 'CT Scan 1', 'Dossier2'),
    (3, 65.00, 'MRI 1', 'Dossier3'),
    (4, 70.00, 'Ultrasound 1', 'Dossier4'),
    (5, 75.00, 'X-ray 2', 'Dossier5'),
    (6, 90.00, 'CT Scan 2', 'Dossier6'),
    (7, 55.00, 'MRI 2', 'Dossier7'),
    (8, 75.00, 'Ultrasound 2', 'Dossier8'),
    (9, 70.00, 'X-ray 3', 'Dossier9'),
    (10, 85.00, 'CT Scan 3', 'Dossier10');


CREATE TABLE remboursementmedicament (
                                         codeBare bigint(20) NOT NULL,
                                         PrixBasic float NOT NULL,
                                         TauxRe int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO remboursementmedicament (codeBare, PrixBasic, TauxRe) VALUES
                                                                      (1123456789, 11.99, 45),
                                                                      (1234509876, 7.99, 10),
                                                                      (1234567890, 10.99, 1),
                                                                      (1345678901, 25.49, 37),
                                                                      (1456789012, 14.99, 28),
                                                                      (1567890123, 26.99, 19),
                                                                      (2234567890, 26.49, 46),
                                                                      (2345018765, 18.49, 11),
                                                                      (2345678901, 15.49, 2),
                                                                      (2456789012, 20.99, 38),
                                                                      (2567890123, 17.49, 29),
                                                                      (2678901234, 16.49, 20),
                                                                      (3345678901, 15.49, 47),
                                                                      (3450187654, 13.99, 12),
                                                                      (3456789012, 8.99, 3),
                                                                      (3567890123, 16.99, 39),
                                                                      (3678901234, 11.49, 30),
                                                                      (3789012345, 23.99, 21),
                                                                      (4456789012, 27.49, 48),
                                                                      (4501876543, 16.99, 13),
                                                                      (4567890123, 25.99, 4),
                                                                      (4678901234, 18.49, 40),
                                                                      (4789012345, 29.99, 31),
                                                                      (4890123456, 12.49, 22),
                                                                      (5018765432, 14.49, 14),
                                                                      (5567890123, 12.49, 49),
                                                                      (5678901234, 12.99, 5),
                                                                      (5789012345, 21.49, 41),
                                                                      (5890123456, 9.49, 32),
                                                                      (5901234567, 8.49, 23),
                                                                      (6012345678, 27.99, 24),
                                                                      (6123456789, 21.99, 15),
                                                                      (6678901234, 28.99, 50),
                                                                      (6789012345, 17.99, 6),
                                                                      (6890123456, 24.49, 42),
                                                                      (6901234567, 12.99, 33),
                                                                      (7012345678, 13.49, 34),
                                                                      (7123456789, 15.99, 25),
                                                                      (7234567890, 9.99, 16),
                                                                      (7890123456, 22.49, 7),
                                                                      (7901234567, 14.99, 43),
                                                                      (8123456789, 22.99, 35),
                                                                      (8234567890, 28.49, 26),
                                                                      (8345678901, 20.49, 17),
                                                                      (8901234567, 11.99, 8),
                                                                      (9012345678, 19.99, 9),
                                                                      (9234567890, 19.49, 36),
                                                                      (9345678901, 10.49, 27),
                                                                      (9456789012, 24.99, 18);

select * from Visite;