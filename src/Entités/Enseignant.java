/*    */ package Entités;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Enseignant
/*    */   extends Personne
/*    */ {
/*    */   private int idEnseignant;
/*    */   private String nom;
/*    */   private String prenom;
/*    */   
/*    */   public Enseignant() {
/* 14 */     this.nom = "PADNOM";
/*    */   }
/*    */   
/*    */   public Enseignant(int idEnseignant, String nom, String prenom, String login, String pwd) {
/* 18 */     this.idEnseignant = idEnseignant;
/* 19 */     this.nom = nom;
/* 20 */     this.prenom = prenom;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIdEnseignant(int idEnseignant) {
/* 26 */     this.idEnseignant = idEnseignant;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 30 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public void setPrenom(String prenom) {
/* 34 */     this.prenom = prenom;
/*    */   }
/*    */   
/*    */   public int getIdEnseignant() {
/* 38 */     return this.idEnseignant;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 42 */     return this.nom;
/*    */   }
/*    */   
/*    */   public String getPrenom() {
/* 46 */     return this.prenom;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "Nom Enseig :  " + this.nom + " \nPrenom : " + this.prenom + " ";
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Entit�s\Enseignant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */