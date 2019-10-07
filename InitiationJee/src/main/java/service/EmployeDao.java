package service;

import model.Employe;
import model.Service;
import model.User;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeDao {
    public List<Service> findService(){
        List<Service> services = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  services";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            while (rs.next()){
                Service s = new Service();
                s.setId(rs.getInt(1));
                s.setLib(rs.getString(2));
                services.add(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return services ;
    }

    public void addEmploye(Employe employe){

        try {
            String sql = "INSERT  INTO employer VALUES  (null,?,?,?,?,?,?,?)";
            DatabaseHelper db = DatabaseHelper.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1,employe.getMatricule());
            db.getPstmt().setString(2,employe.getNom());
            db.getPstmt().setString(3,employe.getTelephone());
            db.getPstmt().setString(4,employe.getAdresse());
            db.getPstmt().setString(5,employe.getDate_naissance().toString());
            db.getPstmt().setInt(6,employe.getSalaire());
            db.getPstmt().setInt(7,employe.getService().getId());
            db.My_ExecutePrepareUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Afficher la list de tous les services employer

    public List<Employe> findEmploye(){
        List<Employe> employes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  employer e,services s WHERE e.idservice=s.id";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (rs.next()){
                Employe e = new Employe();
                e.setId(rs.getInt(1));
                e.setMatricule(rs.getString(2));
                e.setNom(rs.getString(3));
                e.setTelephone(rs.getString(4));
                e.setAdresse(rs.getString(5));
                e.setDate_naissance(LocalDate.parse(rs.getString(6)));
                e.setSalaire(rs.getInt(7));
                Service s = new Service();
                s.setId(rs.getInt(8));
                s.setLib(rs.getString(10));
                e.setService(s);
                employes.add(e);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return employes ;
    }
}
