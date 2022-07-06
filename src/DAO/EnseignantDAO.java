/*    */ package DAO;
/*    */ 
/*    */ import Entités.Enseignant;
/*    */ import Technique.CRUDE;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
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
/*    */ 
/*    */ 
/*    */ public class EnseignantDAO
/*    */ {
/* 23 */   CRUDE crude = new CRUDE();
/*    */ 
/*    */   
/*    */   public Enseignant authentification(String login, String pwd) {
/* 27 */     String req = "SELECT * FROM enseignant WHERE login='" + login + "' AND pwd='" + pwd + "'";
/* 28 */     Enseignant e = new Enseignant();
/* 29 */     ResultSet res = this.crude.exeRead(req);
/*    */     try {
/* 31 */       while (res.next()) {
/* 32 */         e.setIdEnseignant(res.getInt(1));
/* 33 */         e.setNom(res.getString(2));
/* 34 */         e.setPrenom(res.getString(3));
/*    */       } 
/* 36 */       return e;
/* 37 */     } catch (SQLException ex) {
/* 38 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 39 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Enseignant RechercherParId(int i) {
/* 45 */     String req = "SELECT * FROM enseignant WHERE idEnseignant=" + i;
/* 46 */     Enseignant enseignant = new Enseignant();
/* 47 */     ResultSet res = this.crude.exeRead(req);
/*    */     try {
/* 49 */       while (res.next()) {
/* 50 */         enseignant.setIdEnseignant(i);
/* 51 */         enseignant.setNom(res.getString(2));
/* 52 */         enseignant.setPrenom(res.getString(3));
/*    */       } 
/* 54 */       return enseignant;
/* 55 */     } catch (SQLException ex) {
/* 56 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 57 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\DAO\EnseignantDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */