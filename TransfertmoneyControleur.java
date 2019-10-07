package com.tranfertmoney.tranfertmoney.controleur;

import com.tranfertmoney.tranfertmoney.form.FormulaireCompte;
import com.tranfertmoney.tranfertmoney.form.FormulaireDepot;
import com.tranfertmoney.tranfertmoney.form.FormulairePartenaire;
import com.tranfertmoney.tranfertmoney.form.FormulaireUser;
import com.tranfertmoney.tranfertmoney.model.*;
import com.tranfertmoney.tranfertmoney.repository.CompteRepository;
import com.tranfertmoney.tranfertmoney.repository.DepotRepository;
import com.tranfertmoney.tranfertmoney.services.CompteService;
import com.tranfertmoney.tranfertmoney.services.PartenaireService;
import com.tranfertmoney.tranfertmoney.services.UserDetailsServiceImpl;
import com.tranfertmoney.tranfertmoney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin

public class TransfertmoneyControleur {
    @Autowired // sa permet de donner le reference de l'objet
    private UserService userService;
    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireService partenaireService;
    @Autowired // sa permet de donner le reference de l'objet
    private CompteService compteService;
    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;
    @Autowired // sa permet de donner le reference de l'objet
    private DepotRepository depotRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping (value = "partenaire/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Message addParteanire(@RequestBody FormulairePartenaire formulairePartenaire){
        Partenaire partenaire = new Partenaire(formulairePartenaire.getNomentreprise(),formulairePartenaire.getAdresse(),formulairePartenaire.getEmailpart(),formulairePartenaire.getNinea(),formulairePartenaire.getRaisonsocial(),formulairePartenaire.getTelephone());
        partenaireService.save(partenaire);
        Compte compte=new Compte();
        SimpleDateFormat formater = new SimpleDateFormat("yyMM ddhh mmss");
        Date now=new Date();
        compte.setDatecreation(new Date());
        String numerocompte=formater.format(now);
        compte.setNumerocompte(numerocompte);
        compte.setPartenaire(partenaire);
        compte.setSolde(0);
        compteService.save(compte);
        User user=new User(formulairePartenaire.getEmail(),formulairePartenaire.getNom(),formulairePartenaire.getPassword(),formulairePartenaire.getPrenom(),formulairePartenaire.getUsername(),"Actif",formulairePartenaire.getImage());
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(4);
        roles.add(role);
        user.setRoles(roles);
        user.setPartenaire(partenaire);
        user.setCompte(compte);
        userService.save(user);
        String msg="L'entreprise "+ partenaire.getRaisonsocial()+" ainsi que son admin principal ont bien été ajouté !! ";
        String msgCompte="Le compte numéro "+compte.getNumerocompte()+"  lui a été assigné";
        Message lire = new Message(200,msg,msgCompte);
        return lire;
    }

    @PostMapping (value = "caissier/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Message addUser(@RequestBody FormulaireUser formulaireUser){
        User user= new User(formulaireUser.getEmail(),formulaireUser.getNom(),formulaireUser.getPassword(),formulaireUser.getPrenom(),formulaireUser.getUsername(),"Actif",formulaireUser.getImage());
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(3);
        roles.add(role);
        user.setRoles(roles);
        userService.save(user);
        String msg="Le Caissier à été ajouté avec succée !! ";
        Message lire = new Message(200,msg);
        return lire;
    }

    /*@PostMapping (value = "compte/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Message addCompte(@RequestBody FormulaireCompte formulaireCompte, int id) throws Exception {
        Partenaire partenaire=partenaireService.findById(id).orElseThrow(
                ()-> new Exception("Ce partenaire n'existe pas !!")
        );
        Compte compte= new Compte(formulaireCompte.getDatecreation(),formulaireCompte.getNumerocompte(),formulaireCompte.getSolde());
        SimpleDateFormat formater = new SimpleDateFormat("yyMM ddhh mmss");
        Date now=new Date();
        String numerocompte=formater.format(now);
        compte.setNumerocompte(numerocompte);
        compte.setDatecreation(new Date());
        compte.setPartenaire(compte.getPartenaire());
        compteService.save(compte);
        String msg="Un nouveau compte est créé pour l'entreprise "+ partenaire.getRaisonsocial();
        String msgCompte=compte.getNumerocompte();
        Message message=new Message(200,msg,msgCompte);
        return message;
    }*/

    @PostMapping(value = "compte/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte addCompte(@RequestBody(required = false) Compte compte){
        SimpleDateFormat formater = new SimpleDateFormat("yyMMddhhmmss");
        Date now=new Date();
        String numerocompte=formater.format(now);
        //double nombre =(int) (Math.random() *999999999)+1;
        //nombre *= 999999;
        compte.setDatecreation(new Date());
        compte.setNumerocompte(numerocompte);
        compte.setSolde(0);
        compte.setPartenaire(compte.getPartenaire());
        return  compteRepository.save(compte);
    }

    @PostMapping(value = "/depot/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAnyAuthority('ROLE_CAISSIER')")
    public Depot addDepot(@RequestBody(required = false) Depot depot)throws  Exception{
        Compte  compte =compteRepository.findById(depot.getId()).orElseThrow();
        depot.setDatedepot(new Date());
        depot.setMontant(depot.getMontant());
        //depot.setCompte(depot.getCompte());
        compte.setSolde(compte.getSolde() + depot.getMontant());
        compteRepository.save(compte);
        depot.setUser(depot.getUser());

        return  depotRepository.save(depot);
    }

    /*@PostMapping(value = "/nouveau/depot", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('ROLE_Caissier')")
    public Depot depot(@RequestBody FormulaireDepot formulaireDepot) throws Exception {
        User caissier = userDetailsService.getUserConnecte();
        Depot depot=new Depot();
        depot.setCaissier(caissier);
        Compte compte=compteService.findByNumeroCompte(depotForm.getCompte()).orElseThrow(
                ()-> new Exception("Ce compte n'existe pas !")
        );
        if(compte.getEntreprise().getRaisonSociale().equals("SA Transfert") || compte.getEntreprise().getRaisonSociale().equals("Etat du Sénégal")){
            throw new Exception("On ne peut pas faire de depot dans ce compte!");
        }

        depot.setCompte(compte);
        depot.setDate(new Date());
        depot.setMontant(depotForm.getMontant());
        compte.setSolde(compte.getSolde()+depotForm.getMontant());
        compteService.save(compte);
        return depotService.save(depot);
    }*/

}