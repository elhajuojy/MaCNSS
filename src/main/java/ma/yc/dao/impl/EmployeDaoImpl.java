package ma.yc.dao.impl;

import ma.yc.core.Print;
import ma.yc.dao.EmployeDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Employe;

import java.sql.*;

public class EmployeDaoImpl implements EmployeDao {
    private Employe employe = new Employe();
    private Connection connection ;

    public EmployeDaoImpl() {
        try{
            this.connection = DatabaseConnection.getInstance().getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employe consulterCompte(String Matricule) {
        String query = "SELECT * FROM employe WHERE matricule = ?";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, Matricule);
            //TODO : get the result set
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                this.employe.setMatricule(resultSet.getLong("matricule"));
                this.employe.setNom(resultSet.getString("nom"));
                this.employe.setPrenom(resultSet.getString("prenom"));
                this.employe.setEmail(resultSet.getString("email"));
                this.employe.setDateNaissance(resultSet.getDate("date_naissance"));
                this.employe.setTel(resultSet.getString("tel"));
                this.employe.setSalaire(resultSet.getDouble("salaire"));
                this.employe.setSociete(null);
                return this.employe;
            }
        }catch (SQLException e){
            Print.log(e.toString());
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employe employe) {

        String query = "INSERT INTO employe (matricule, nom, prenom, email, date_naissance, tel , salaire , societe_id)" +
                " VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setLong(1, employe.getMatricule());
            preparedStatement.setString(2, employe.getNom());
            preparedStatement.setString(3, employe.getPrenom());
            preparedStatement.setString(4, employe.getEmail());
            preparedStatement.setDate(5, (Date) employe.getDateNaissance());
            preparedStatement.setString(6, employe.getTel());
            preparedStatement.setDouble(7, employe.getSalaire());
            preparedStatement.setLong(8, employe.getSociete().getId());
            return preparedStatement.executeUpdate() ==1? true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateEmployeeSalary(double salary, Long idSociete, long id) {
        String query  = "UPDATE employe SET salaire = ? , societe_id = ? WHERE matricule = ?;";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setDouble(1,salary);
            preparedStatement.setLong(2,idSociete);
            preparedStatement.setLong(3,id);
            return preparedStatement.executeUpdate() == 1;

        }catch (SQLException e){
            Print.log("");
        }
        return false;
    }


}
