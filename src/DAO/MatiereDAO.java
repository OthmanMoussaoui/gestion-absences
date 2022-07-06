/*    */ package DAO;
/*    */ 
/*    */ import Entités.Matiere;
/*    */ import Technique.CRUDE;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MatiereDAO
/*    */ {
/* 23 */   CRUDE crude = new CRUDE();
/*    */   
/*    */   public void ajouterMatiere(String s) {
/* 26 */     String req = "INSERT INTO `matiere`(`libelle`) VALUES ('" + s + "')";
/* 27 */     this.crude.exeCreate(req);
/*    */   }
/*    */   
/*    */   public List<Matiere> Lister() {
/* 31 */     String req = "SELECT * FROM matiere";
/* 32 */     ResultSet res = this.crude.exeRead(req);
/* 33 */     List<Matiere> list = new ArrayList<>();
/*    */     
/*    */     try {
/* 36 */       while (res.next()) {
/* 37 */         Matiere matiere = new Matiere();
/* 38 */         matiere.setIdMatiere(res.getInt(1));
/* 39 */         matiere.setLibelleMatiere(res.getString(2));
/* 40 */         list.add(matiere);
/*    */       } 
/* 42 */       return list;
/* 43 */     } catch (SQLException ex) {
/* 44 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 45 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public Matiere RechercherParId(int i) {
/* 50 */     String req = "SELECT * FROM matiere WHERE idMatiere=" + i;
/* 51 */     Matiere matiere = new Matiere();
/* 52 */     ResultSet res = this.crude.exeRead(req);
/*    */     try {
/* 54 */       while (res.next()) {
/* 55 */         matiere.setIdMatiere(i);
/* 56 */         matiere.setLibelleMatiere(res.getString(2));
/*    */       } 
/* 58 */       return matiere;
/* 59 */     } catch (SQLException ex) {
/* 60 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 61 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Matiere RechercherParLibelle(String libelle) {
/* 67 */     String req = "SELECT * FROM matiere WHERE libelle='" + libelle + "'";
/* 68 */     Matiere matiere = new Matiere();
/* 69 */     ResultSet res = this.crude.exeRead(req);
/*    */     try {
/* 71 */       while (res.next()) {
/* 72 */         matiere.setIdMatiere(res.getInt(1));
/* 73 */         matiere.setLibelleMatiere(res.getString(2));
/*    */       } 
/* 75 */       return matiere;
/* 76 */     } catch (SQLException ex) {
/* 77 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 78 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\DAO\MatiereDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */