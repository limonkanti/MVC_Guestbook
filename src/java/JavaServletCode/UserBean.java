
package JavaServletCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBean 
{
    private String uname,upass;
    
    public String getUname()
    {
        return uname;
    }
    public void setUname(String uname)
    {
        this.uname=uname;
    }
    
    public String getUpass()
    {
        return upass;
    }
    public void setUpass(String upass)
    {
        this.upass=upass;
    }
    public int RegisterUser(UserBean ob)
    {
        int i=0;
       UserBean ob1=new UserBean();
        try{
           Connection con=ConnectionProvider2.getConnection();
           String insertquery="insert into reg values(?,?)";
           PreparedStatement ps=con.prepareStatement(insertquery);
           ps.setString(1, ob.getUname());
           ps.setString(2, ob.getUpass());
           i=ps.executeUpdate(); 
          
       }
       catch(Exception e)
       {
           System.out.println("Error is:\n"+e.toString());
     
       }
       
       return i;
    }
    public static boolean validate(UserBean b)
    {
        boolean status=false;
        ResultSet rs;
        try{
            
           Connection con=ConnectionProvider2.getConnection();
           String insertquery="select * from reg where uname=? and upass=?";
           PreparedStatement ps=con.prepareStatement(insertquery);
           ps.setString(1, b.getUname());
           ps.setString(2, b.getUpass());
           rs=ps.executeQuery();
           status=rs.next();
          
        }
        catch(Exception e)
        {
            System.out.println("Error is:\n"+e.getMessage());
            
        }
        
        return status;
        
    }
    
}
