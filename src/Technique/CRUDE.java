/*    */ package Technique;
/*    */ 
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRUDE
/*    */ {
/* 15 */   MyConnexion mc = MyConnexion.getInstance();
/*    */   
/*    */   public boolean exeCreate(String sql) {
/*    */     try {
/* 19 */       Statement statement = MyConnexion.getConnexion().createStatement();
/* 20 */       statement.executeUpdate(sql);
/* 21 */       return true;
/* 22 */     } catch (SQLException ex) {
/* 23 */       Logger.getLogger(CRUDE.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 24 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean exeUpdate(String sql) {
/*    */     try {
/* 30 */       Statement statement = MyConnexion.getConnexion().createStatement();
/* 31 */       statement.executeUpdate(sql);
/* 32 */       return true;
/* 33 */     } catch (SQLException ex) {
/* 34 */       Logger.getLogger(CRUDE.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 35 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean exeDelete(String sql) {
/*    */     try {
/* 41 */       Statement statement = MyConnexion.getConnexion().createStatement();
/* 42 */       statement.executeUpdate(sql);
/* 43 */       return true;
/* 44 */     } catch (SQLException ex) {
/* 45 */       Logger.getLogger(CRUDE.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 46 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultSet exeRead(String sql) {
/* 52 */     System.out.println("Test lecture ... Crude");
/*    */     try {
/* 54 */       Statement statement = MyConnexion.getConnexion().createStatement();
/*    */       
/* 56 */       ResultSet re = statement.executeQuery(sql);
/* 57 */       return re;
/* 58 */     } catch (SQLException ex) {
/* 59 */       Logger.getLogger(CRUDE.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 60 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Technique\CRUDE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */