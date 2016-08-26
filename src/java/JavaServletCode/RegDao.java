
package JavaServletCode;

import java.sql.*;


public class RegDao
{
     
    public static int register(UserBean ub)
    {
       int i=0;
       try{
           Connection con=ConnectionProvider2.getConnection();
           String insertquery="insert into reg values(?,?)";
           PreparedStatement ps=con.prepareStatement(insertquery);
           ps.setString(1, ub.getUname());
           ps.setString(2, ub.getUpass());
           i=ps.executeUpdate();
           
   
       }
       catch(Exception e)
       {
           System.out.println(e.toString());
       }
     
      return i;  
    }
    
}
