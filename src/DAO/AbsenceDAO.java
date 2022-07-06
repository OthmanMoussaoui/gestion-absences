package DAO;

import Entités.Absence;
import Entités.Classe;
import Entités.Enseignant;
import Entités.Etudiant;
import Entités.Matiere;
import Technique.CRUDE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbsenceDAO {
  CRUDE crude = new CRUDE();
  

  
  public void AjouterAbsence(Etudiant e, Enseignant ens, Matiere m, int seance, boolean p1, boolean p2) {
    String format = "yyyy-MM-dd";
    SimpleDateFormat formater = new SimpleDateFormat(format);
    Date dat = new Date();
    String req = "INSERT INTO absence (idAbsence, idEtudiant , idEnseingant, idMatiere, idClasse, numSeance,  periode1, periode2) VALUES ( NULL, " + Integer.toString(e.getIdEtudiant()) + "," + Integer.toString(ens.getIdEnseignant()) + "," + Integer.toString(m.getIdMatiere()) + "," + Integer.toString(e.getClasse().getIdClasse()) + "," + seance + "," + p1 + "," + p2 + ")";
    System.out.println(req);
    if (this.crude.exeCreate(req))
      System.out.println("Absence ajouter"); 
  }
  
  public List<Absence> ListerAbsenceEtudiant(Etudiant e) {
    String req = "SELECT * FROM absence WHERE idEtudiant=" + e.getIdEtudiant();
    ResultSet res = this.crude.exeRead(req);
    List<Absence> list = new ArrayList<>();
    EtudiantDAO eDAO = new EtudiantDAO();
    EnseignantDAO ensDAO = new EnseignantDAO();
    MatiereDAO mDAO = new MatiereDAO();
    ClasseDAO cDAO = new ClasseDAO();
    try {
      while (res.next()) {
        Absence absence = new Absence();
        absence.setId(res.getInt(1));
        absence.setEtudiant(eDAO.RechercherParId(res.getInt(2)));
        absence.setEnseignant(ensDAO.RechercherParId(res.getInt(3)));
        absence.setMatiere(mDAO.RechercherParId(res.getInt(4)));
        absence.setClasse(cDAO.RechercherParId(res.getInt(5)));
        absence.setNumseance(res.getInt(6));
        absence.setDate(res.getDate(7));
        absence.setPeriode1(res.getBoolean(8));
        absence.setPeriode2(res.getBoolean(9));
        if (absence.isPeriode1() == true) {
          absence.setP1("Absente");
        } else {
          absence.setP1("Present");
        } 
        if (absence.isPeriode2() == true) {
          absence.setP2("Absent");
        } else {
          absence.setP2("Present");
        } 
        list.add(absence);
      } 
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
      return null;
    } 
  }
  
  public List<Absence> ListerAbsenceClasse(Classe c) {
    String req = "SELECT * FROM absence WHERE idClasse=" + c.getIdClasse();
    ResultSet res = this.crude.exeRead(req);
    List<Absence> list = new ArrayList<>();
    EtudiantDAO eDAO = new EtudiantDAO();
    EnseignantDAO ensDAO = new EnseignantDAO();
    MatiereDAO mDAO = new MatiereDAO();
    ClasseDAO cDAO = new ClasseDAO();
    try {
      while (res.next()) {
        Absence absence = new Absence();
        absence.setId(res.getInt(1));
        absence.setEtudiant(eDAO.RechercherParId(res.getInt(2)));
        absence.setEnseignant(ensDAO.RechercherParId(res.getInt(3)));
        absence.setMatiere(mDAO.RechercherParId(res.getInt(4)));
        absence.setClasse(cDAO.RechercherParId(res.getInt(5)));
        absence.setNumseance(res.getInt(6));
        absence.setDate(res.getDate(7));
        absence.setPeriode1(res.getBoolean(8));
        absence.setPeriode2(res.getBoolean(9));
        if (absence.isPeriode1() == true) {
          absence.setP1("Absente");
        } else {
          absence.setP1("Present");
        } 
        if (absence.isPeriode2() == true) {
          absence.setP2("Absent");
        } else {
          absence.setP2("Present");
        } 
        list.add(absence);
      } 
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
      return null;
    } 
  }
  
  public List<Absence> ListerAbsenceEtudiantMatiere(Etudiant e, Matiere m) {
    String req = "SELECT * FROM absence WHERE idEtudiant=" + e.getIdEtudiant() + " AND idMatiere=" + m.getIdMatiere();
    ResultSet res = this.crude.exeRead(req);
    List<Absence> list = new ArrayList<>();
    EtudiantDAO eDAO = new EtudiantDAO();
    EnseignantDAO ensDAO = new EnseignantDAO();
    MatiereDAO mDAO = new MatiereDAO();
    ClasseDAO cDAO = new ClasseDAO();
    try {
      while (res.next()) {
        Absence absence = new Absence();
        absence.setId(res.getInt(1));
        absence.setEtudiant(eDAO.RechercherParId(res.getInt(2)));
        absence.setEnseignant(ensDAO.RechercherParId(res.getInt(3)));
        absence.setMatiere(mDAO.RechercherParId(res.getInt(4)));
        absence.setClasse(cDAO.RechercherParId(res.getInt(5)));
        absence.setNumseance(res.getInt(6));
        absence.setDate(res.getDate(7));
        absence.setPeriode1(res.getBoolean(8));
        absence.setPeriode2(res.getBoolean(9));
        if (absence.isPeriode1() == true) {
          absence.setP1("Absent");
        } else {
          absence.setP1("Present");
        } 
        if (absence.isPeriode2() == true) {
          absence.setP2("Absent");
        } else {
          absence.setP2("Present");
        } 
        list.add(absence);
      } 
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
      return null;
    } 
  }
  
  public int CompterAbsencesTotalEtudiant(Etudiant e) {
    int nombreAbsence = 0;
    String requete = "SELECT COUNT( * ) FROM  `absence` WHERE `idEtudiant` =" + e.getIdEtudiant();
    ResultSet rs = this.crude.exeRead(requete);
    try {
      while (rs.next())
        nombreAbsence += rs.getInt(1); 
    } catch (SQLException ex) {
      Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    return nombreAbsence;
  }
  
  public int CompterToutesLesAbsence() {
    int nombreAbsence = 0;
    String requete = "SELECT COUNT( * ) FROM  `absence`";
    ResultSet rs = this.crude.exeRead(requete);
    try {
      while (rs.next())
        nombreAbsence += rs.getInt(1); 
    } catch (SQLException ex) {
      Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    return nombreAbsence;
  }
  
  public int CompterAbsencesClasse(Classe c) {
    int nombreAbsence = 0;
    String requete = "SELECT COUNT( * ) FROM  `absence` WHERE `idClasse` =" + c.getIdClasse();
    ResultSet rs = this.crude.exeRead(requete);
    try {
      while (rs.next())
        nombreAbsence += rs.getInt(1); 
    } catch (SQLException ex) {
      Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    return nombreAbsence;
  }
  
  public Object CompterAbsences(Etudiant e, Matiere matiere) {
    int nombreAbsence = 0;
    String requete = "SELECT COUNT(*) FROM absence WHERE idEtudiant=" + e.getIdEtudiant() + " AND idMatiere=" + matiere.getIdMatiere();
    ResultSet rs = this.crude.exeRead(requete);
    try {
      while (rs.next())
        nombreAbsence = rs.getInt(1); 
    } catch (SQLException ex) {
      Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    return Integer.valueOf(nombreAbsence);
  }
}
