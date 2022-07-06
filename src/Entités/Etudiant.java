/*    */ package Entités;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Etudiant
/*    */   extends Personne
/*    */ {
/*    */   private int idEtudiant;
/*    */   private String nom;
/*    */   private String prenom;
/*    */   private Classe classe;
/*    */   private int niveau;
/*    */   
/*    */   public Etudiant() {
/* 20 */     this.nom = "PADNOM";
/*    */   }
/*    */   
/*    */   public Etudiant(int idEtudiant, String nom, String prenom, Classe classe) {
/* 24 */     this.idEtudiant = idEtudiant;
/* 25 */     this.nom = nom;
/* 26 */     this.prenom = prenom;
/* 27 */     this.classe = classe;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setClasse(Classe classe) {
/* 33 */     this.classe = classe;
/*    */   }
/*    */   public void setNiveau(int niveau) {
/* 36 */     this.niveau = niveau;
/*    */   }
/*    */   
/*    */   public void setIdEtudiant(int idEtudiant) {
/* 40 */     this.idEtudiant = idEtudiant;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 44 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public void setPrenom(String prenom) {
/* 48 */     this.prenom = prenom;
/*    */   }
/*    */   
/*    */   public Classe getClasse() {
/* 52 */     return this.classe;
/*    */   }
/*    */   
/*    */   public int getIdEtudiant() {
/* 56 */     return this.idEtudiant;
/*    */   }
/*    */   public int getNiveau() {
/* 59 */     return this.niveau;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 63 */     return this.nom;
/*    */   }
/*    */   
/*    */   public String getPrenom() {
/* 67 */     return this.prenom;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     return "Nom = " + this.nom + " \nPrenom = " + this.prenom + " \n\n  ";
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Entit�s\Etudiant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */