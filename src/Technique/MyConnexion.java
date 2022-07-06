/*    */ package Technique;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyConnexion
/*    */ {
/* 13 */   static String login = "root";
/*    */   
/* 15 */   static String pwd = "root";
/*    */   
/* 17 */   static String url = "jdbc:mysql://localhost:3306/gestionabsences";

/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Connection connexion;
/*    */ 
/*    */ 
/*    */   
/*    */   private static MyConnexion instance;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MyConnexion() {
/*    */     try {
/* 33 */       Class.forName("com.mysql.cj.jdbc.Driver");
/* 34 */       System.out.println("Driver chargÃ©");
/*    */       
/* 36 */       connexion = DriverManager.getConnection(url, login, pwd);
/*    */       
/* 38 */       System.out.println("Connetion a la BD reussie");
/* 39 */     } catch (ClassNotFoundException ex) {
/* 40 */       System.out.println("Driver n'est pas chargé");
/* 41 */       Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 42 */     } catch (SQLException ex) {
/* 43 */       System.out.println("Connetion a la BD echoué");
/* 44 */       Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, (String)null, ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Connection getConnexion() {
/* 49 */     return connexion;
/*    */   }
/*    */   
/*    */   public static MyConnexion getInstance() {
/* 53 */     if (instance == null)
/* 54 */       instance = new MyConnexion(); 
/* 55 */     System.out.println("Utilisation de la connexion precedement établie");
/* 56 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Technique\MyConnexion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */