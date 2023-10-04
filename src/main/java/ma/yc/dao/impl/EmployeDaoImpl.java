package ma.yc.dao.impl;

import ma.yc.core.Print;
import ma.yc.dao.EmployeDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Employe;
import ma.yc.model.Hourly_emp;
import ma.yc.model.SalaryHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

            }

            //TODO : GET THE LAST 96 RECORDS FROM THE SALARY HISTORY
            String SalaryQuery = "SELECT * FROM salary_history WHERE employe_id = ? ORDER BY id DESC LIMIT 96";
            PreparedStatement salaryStatement = this.connection.prepareStatement(SalaryQuery);
            salaryStatement.setLong(1, this.employe.getMatricule());
            ResultSet salaryResultSet = salaryStatement.executeQuery();
            ArrayList<SalaryHistory> salaryHistories = new ArrayList<>() ;
            SalaryHistory salaryHistory = new SalaryHistory();
            while (salaryResultSet.next()){
                //TODO : GET THE SALARY HISTORY
                salaryHistory.setId(salaryResultSet.getLong("id"));
                salaryHistory.setSalaire(salaryResultSet.getDouble("salaire"));
                salaryHistories.add(salaryHistory);

            }
                this.employe.setSalaires(salaryHistories);

            //GETT ALL THE WORKING DAYS
            String hourlySumQuery = "SELECT * FROM hourly_emp WHERE employe_id = ?";
             PreparedStatement hourlySumStatement = this.connection.prepareStatement(hourlySumQuery);
             hourlySumStatement.setLong(1, this.employe.getMatricule());
             ResultSet hourlySumResultSet = hourlySumStatement.executeQuery();
             ArrayList<Hourly_emp> hourly_emps = new ArrayList<>();
                while (hourlySumResultSet.next()){
                    Hourly_emp hourly_emp = new Hourly_emp();
//                    Print.log(hourlySumResultSet.getInt(3));
                    hourly_emp.setJourTravaille(hourlySumResultSet.getInt("jour_travaille"));
                    hourly_emp.setId(hourlySumResultSet.getLong("id"));
                    hourly_emps.add(hourly_emp);
                }
                this.employe.setJourTravaillesParMois(hourly_emps);



            return this.employe;
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
