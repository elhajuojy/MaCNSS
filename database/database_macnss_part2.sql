-- i have to add societe
-- employee
--

-- CREATE TABLE SOIETE WITH THIS PROPERTIES
# public class Societe  extends Utilisateur{
#     private Long id;
# private String nom;
# private String adresse;
# private String email;
# private String tel;
# private List<Employe> employes = new ArrayList<Employe>();
# }
#


create table societe(
    id bigint not null,
    nom varchar(255),
    email varchar(255),
    adresse varchar(255),
    tel varchar(255),
    primary key (id)
);

-- ADD CONSTRAINT UNIQUE ON EMAIL
ALTER TABLE societe ADD CONSTRAINT unique_email UNIQUE (email);

INSERT INTO societe (id, nom, email, adresse, tel)
VALUES (1, 'societe1', 'email@gmail.com', 'adresse1', 'tel1'),
         (2, 'societe2', 'email2@gmail.com', 'adresse2', 'tel2');


-- CREATE TABLE EMPLOYE WITH THIS PROPERTIES
# public class Employe extends Utilisateur {
#     //chaque employé doit cumulé au minimum 1320 jours dans sa carrière professionnelle si un employé change de socité,
#     // il garde le même matricule avec changement de société qu'elle a employé
#     private Long matricule;
#     private String nom;
#     private String prenom;
#     private String email;
#     private Date dateNaissance;
#     private String tel;
#     private Societe societe;
#     private Statusretaitre retaitre;
#     private List<Hourly_emp> jourTravaillesParMois;
#     private List<SalaryHistory> salaires;
#     private double salaire;
# }


create table employe(
                        id bigint AUTO_INCREMENT,
                        matricule bigint,
                        nom varchar(255),
                        prenom varchar(255),
                        email varchar(255),
                        date_naissance date,
                        tel varchar(255),
                        salaire double precision,
                        societe_id bigint,
                        primary key (id, matricule)
);


-- ADD CONSTRAINT UNIQUE ON EMAIL
ALTER TABLE employe ADD CONSTRAINT unique_email UNIQUE (email);
-- ADD CNOSTRAINT UNIQUE ON MATRICULE
ALTER TABLE employe ADD CONSTRAINT unique_matricule UNIQUE (matricule);
-- ADD CONSTRAINT societe_id_fk FOREIGN KEY (societe_id) REFERENCES societe (id);
ALTER TABLE employe ADD CONSTRAINT societe_id_fk FOREIGN KEY (societe_id) REFERENCES societe (id);
-- ADD CONSTRAINT ON MATRICULE WITH THE PATIENT TABLE WITH THE SAME MATRICULE
ALTER TABLE employe ADD CONSTRAINT matricule_patient_fk FOREIGN KEY (matricule) REFERENCES patients (matricule);


-- salary history
# public class SalaryHistory {
#     private Long id ;
# private double salaire ;
# private Employe employe ;
# }

create table salary_history(
    id bigint not null,
    salaire double precision,
    employe_id bigint,
    primary key (id)
);

-- ADD CONSTRAINT employe_id_fk FOREIGN KEY (employe_id) REFERENCES employe (id);
ALTER TABLE salary_history ADD CONSTRAINT employe_id_salary_history_fk FOREIGN KEY (employe_id) REFERENCES employe (matricule);
-- ADD CONSTRAINT ON THIS TABLE ID AUTO INCREMENT

DELIMITER //
CREATE TRIGGER hourly_emp_insert_trigger AFTER INSERT ON hourly_emp FOR EACH ROW
BEGIN
    INSERT INTO salary_history (employe_id, salaire)
    VALUES (NEW.employe_id, NEW.jour_travaille * (SELECT employe.salaire FROM employe WHERE matricule = NEW.employe_id)/26);
END;
//
DELIMITER ;

-- Hourly_emp
# public class Hourly_emp {
#     private Long id ;
# private Date date ;
# private Employe employe ;
# private int jourTravaille ;
# }

CREATE TABLE hourly_emp(
    id bigint not null,
    date date,
    employe_id bigint,
    jour_travaille int,
    primary key (id)
);

-- ADD CONSTRAINT employe_id_fk FOREIGN KEY (employe_id) REFERENCES employe (id);
ALTER TABLE hourly_emp ADD CONSTRAINT employe_id_fk FOREIGN KEY (employe_id) REFERENCES employe (matricule);
-- ADD CONSTRAINT THE JOUR_TRAVAILLE BETWEEN 0 AND 26
ALTER TABLE hourly_emp ADD CONSTRAINT jour_travaille_check CHECK (jour_travaille BETWEEN 0 AND 26);



-- CREATE TRIGGER WHEN INSERTING TO THE TABLE HOURLY_EMP TO ADD TO THE SALARY OF THE EMPLOYE THE SALARY RECORD SHOULD BE LIKE THIS
--  SALARAY IS  JOUR_TRAVAILLE * SALAIRE
-- EMPLYE_ID IS THE EMPLOYE ID IN THE TABLE EMPLOYE


-- update employe
UPDATE employe SET employe.salaire = '340000' AND employe.societe_id = '2' WHERE employe.matricule =  '3345';

SELECT * FROM employe where  matricule = 3345;

UPDATE employe SET salaire = 33028.22 , societe_id = 2 WHERE matricule = 3345 ;
