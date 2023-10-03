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
