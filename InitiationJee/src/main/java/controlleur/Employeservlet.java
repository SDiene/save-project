package controlleur;

import model.Employe;
import model.Service;
import model.User;
import service.EmployeDao;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name="employe", urlPatterns="/employe")
public class Employeservlet extends HttpServlet {
    EmployeDao  employeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.getWriter().println("hello world");

        //charger une page de redirection
        String action=req.getParameter("action");
        employeDao = new EmployeDao();
        switch (action){
            case "add":
                req.setAttribute("employe",employeDao.findEmploye());
                req.setAttribute("service",employeDao.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // charge une redirection
        String action=req.getParameter("action");

        // Instanciation de notre objet employeDao

        employeDao = new EmployeDao();

        switch (action){
            case "add":
                try {
                    req.setAttribute("employe",employeDao.findEmploye());
                    String matricule = req.getParameter("matricule");
                String nom = req.getParameter("nom");
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date_naissance = LocalDate.parse(req.getParameter("date_naissance"),df);
                String telephone = req.getParameter("telephone");
                String adresse = req.getParameter("adresse");
                int salaire = Integer.parseInt(req.getParameter("salaire"));
                int ids = Integer.parseInt(req.getParameter("service"));

                Service s = new Service();
                s.setId(ids);

                Employe employe = new Employe();

                employe.setService(s);
                employe.setAdresse(adresse);
                employe.setMatricule(matricule);
                employe.setDate_naissance(date_naissance);
                employe.setTelephone(telephone);
                employe.setNom(nom);
                employe.setSalaire(salaire);

                employeDao.addEmploye(employe);

                }catch (Exception ex){
                    req.setAttribute("error","erreur dans l'insertion");
                    ex.printStackTrace();
                }

                req.setAttribute("service", employeDao.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
        }
    }

}


