
package JavaServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerLogin2 extends HttpServlet
{
     protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
     {
        

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
       
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");

        UserBean ub = new UserBean();
        ub.setUname(uname);
        ub.setUpass(upass);
       
        req.setAttribute("ub", ub);
        boolean status=LoginDao.validate(ub);
        if(status)
        {
            RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
            rd.forward(req, res);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.include(req, res);
            
        }
        

    }
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
        doPost(req, res);  
    }  
    

}
