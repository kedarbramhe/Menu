/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author kedar
 */
public class Menu extends HttpServlet {
    private int it=0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    ArrayList<MenuBean> a1=new ArrayList<MenuBean>();

    PrintWriter out;
    MenuDao md = new MenuDao();
    String leftM="";
    String tempS="";
    a1=md.getMenu();
    int id=0;
    out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang=\"en\">");
    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
    out.println("<title>untitled</title>");
    out.println("<link rel=\"stylesheet\" href=\"css/style1.css\" type=\"text/css\" />");
    //out.println("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" />");
/*out.println("<script>");
out.println("function show(id) {");
    out.println("document.getElementById(id).style.display = 'block';");
 out.println("alert(id);");
out.println("}");


out.println("</script>");*/
    /*out.println("<style>");
    out.println(".top a{color: red;text-decoration: none;}");
    out.println(".left li a{color: blue;text-decoration: none;display: table;}");
    out.println(".left {display:none;}");
    out.println(".left:target {display:table;position:fixed;left:50px;top:200px;}");
    out.println(".left li{display: table; background-color: aqua}");
    out.println(".top ul{list-style-type:none;margin:0;padding:0;overflow:hidden;}.top li{float:left;display:inline;}.top a{display: table;width:60px;background-color:#dddddd;}");
    out.println(".left li{clear:both;}");
    out.println(".left li{display: table; background-color: aqua}");
    //out.println(".top ul li{display:block;}");
    //out.println(".top:hover ul li a{height:auto;display:block;}");
    out.println("</style>");*/

    out.println("</head>");
    out.println("<body>");
    out.println("<center>");
out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"980px\">");
 out.println("<tbody>");
 out.println("<tr>");
 out.println("<td colspan=\"3\" heignt=\"10px\" style=\"background:#292929;\">");
 out.println("<div id=\"nav\">");
 out.println("<ul class=\"top\">");

 String r=request.getParameter("role");



 String oldParent = "root";
 String oldNode="root";
 ArrayList<String> parent1=new ArrayList<String>(); //contains parent of parent
 ArrayList<String> parent=new ArrayList<String>();
//out.print(a1.size());
//out.print(a2.size());
 //out.println(md.getCheck());
 parent.add("root");parent1.add(" ");
 for(int i=0;i<a1.size();i++)
 {
 MenuBean temp=a1.get(i);
 oldNode=temp.node;

 if(!temp.parent.equals(oldParent))
 {
 if(parent.contains(temp.parent)){


         for(int k=parent.indexOf(oldParent);k>parent.indexOf(temp.parent);k--){
             if(it==1){
                 leftM=leftM+"</ul> \n";
                 it=0;
             }
             out.println("</li>");
             out.println("</ul>");

             parent.remove(k);
         }


 }else{
     parent.add(temp.parent);
     parent1.add(oldNode);
     if(temp.pos.equals("left"))
     {tempS="<ul class=\"newLeft\" id=\""+temp.parent+"\"> \n";
         leftM=leftM+tempS;
         out.println("<ul>");
     }else{
     out.println("<ul class=\"top\">");
 }
 }
//out.println("<ul>");

 }else{
     out.println("</li>");
     }
if(temp.role.equals(r)|| temp.role.equals("all")){

    if(temp.pos.equals("left")&& temp.visibility.equals("visible")){
        if(temp.linkState.equals("active"))
        tempS="<li>"+"<a href=\"http://"+temp.url+"\">"+temp.node+"</a> </li> \n";
        else
            tempS="<li>"+"<a href=\"#"+temp.node+"\">"+temp.node+"</a> </li> \n";
      leftM=leftM+tempS;it=1;
    }
 else{
        if(temp.visibility.equals("visible"))
            if(temp.linkState.equals("inactive"))
            out.println("<li class=\"top\">"+"<a class=\"top\" href=\"#"+temp.node+"\">"+temp.node+"</a>");
        else
         out.println("<li class=\"top\">"+"<a class=\"top\" href=\"http://"+temp.url+"\">"+temp.node+"</a>");
 }
    //out.println("<li>"+"<a href=\"#"+temp.node+"\">"+temp.node+"</a>");
}
 oldParent=temp.parent;

 oldNode=temp.node;

        }

out.println("</ul>");
out.println("</div>");
out.println("</tr>");
out.println("<tr>");
out.println("<td align=\"center\" width=\"150\" style=\"background:#5186bc\" height=\"600\">");



out.println("<div class=newLeft>");
out.println(leftM);
out.println("</div>");
out.println("<td style=\"background:white;padding-top:5px;padding-left:10px;\" align=\"left\" valign=\"top\" width=\"523\" height=\"600\">");
out.println("<td style=\"background:white;padding-top:5px;padding-left:5px;\" align=\"left\" valign=\"top\" width=\"192\" >");
//out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>");
//out.println("<script src=\"http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js\" type=\"text/javascript\"></script>");
//out.println("<script type=\"text/javascript\" src=\"js/scripts.js\"></script>");
out.println("</tr>");

out.println("</center>");
out.println("</body>");
            out.println("</html>");

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
