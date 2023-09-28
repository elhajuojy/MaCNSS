package ma.yc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



public class Societe {
    public Societe() {
    }

    private Long id;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
    private List<Employe> employes = new ArrayList<Employe>();
}
