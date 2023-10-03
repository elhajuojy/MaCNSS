package ma.yc.dao;

import ma.yc.model.Employe;

public interface EmployeDao {
    //consulter son compte avec possibilité de savoir s'il peut bénéficier d'une retraite ou non, si oui il peut voir son salaire de retraite qui se calcul comme suit:
    public Employe consulterCompte(String Matricule);
    public boolean addEmployee(Employe employe);
    public boolean updateEmployeeSalary(double salary,Long idSociete,long id);


    boolean declareJourTravileParEmployee(long societeId, long employeeMatricule, int jourTravile);
}
