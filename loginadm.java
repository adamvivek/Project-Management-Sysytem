package Parking;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
public class loginadm extends javax.swing.JFrame {
        String s1,s2,r1,r2;
public loginadm() {
initComponents();
    }
 private void cancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
dispose();
log l=new log();
l.setVisible(true);
    }                                      
 private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
 s1=t1.getText();
 s2=t2.getText();
 if(s1.length()<=0 && s2.length()<=0)
      {
   JOptionPane.showMessageDialog(null,"Please fill Details");     
        }
        else
        {
            try
            {
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/parkingdb","parking","system"); 
 PreparedStatement ps;
 ps = con.prepareStatement("select aname,pass from admindb where aname=? and pass=?");
 ps.setString(1,s1);
 ps.setString(2,s2);        
 ResultSet rs=ps.executeQuery();
  if(rs.next())
            {
                r1=rs.getString(1);
                r2=rs.getString(2);          
                if(r1.equals(s1) && r2.equals(s2))
                {
con=DriverManager.getConnection("jdbc:derby://localhost:1527/parkingdb","parking","system"); 
           ps=con.prepareStatement("insert into loginadm (aname,adate,atime) values (?,?,?)");
          java.util.Date date=new java.util.Date();
           java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            java.sql.Timestamp sqlTime=new    java.sql.Timestamp(date.getTime());
            ps.setString(1,s1);
            ps.setDate(2,sqlDate);
            ps.setTimestamp(3,sqlTime);
            ps.execute();
       JOptionPane.showMessageDialog(null,"Login Successfully done");
            dispose();
        admhome a=new admhome();
        a.setVisible(true);
                }
            }
            else
                {
   JOptionPane.showMessageDialog(null,"Login Unsucessfull");                   
                }
            }
    catch(SQLException | HeadlessException e)
        {
        }
          }
       }                                     

    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
    new loginadm().setVisible(true);
        });
    }
    }
