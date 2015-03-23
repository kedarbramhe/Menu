/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kedar
 */

import com.ConnectionPool;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;



public class MenuDao {
ConnectionPool c = null;
    Connection conn = null;
 

private ArrayList<MenuBean> a1=new ArrayList<MenuBean>()  ;
private ArrayList<String> a2=new ArrayList<String>();
//private String check="";
    public ArrayList<MenuBean> getMenu() throws IOException {

//check="entered the function";

            a2=this.getParents();

             Menu("root");

  //           check=check+" finished";






        
        return a1;
    }

    /*public String getCheck() {
        return check;
    }*/



    public void Menu(String name){
       int flag=1,j=1;
         while(flag!=0){
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();


            String sql = "select * from menu where parent=\"" + name +"\" and seq=" + j;
            j++;

    //        check=check+" entered the menu";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = (ResultSet) pstmt.executeQuery();
//check=check+" executed query";

           if(rs.wasNull())
           {
//check=check+" rs was null";
              flag = 0;
            }




            if(rs.first())
            {
//              check=check+"adding";

            if(!rs.getString("node").equals("")){
            try{
                MenuBean temp = new MenuBean();

  //          check=check+" entry added";
                temp.node=rs.getString("node");
                temp.parent=rs.getString("parent");
                temp.seq=rs.getInt("seq");
                temp.pos=rs.getString("pos");
                temp.role=rs.getString("role");
                temp.url=rs.getString("url");
                temp.visibility=rs.getString("visibility");
                temp.linkState=rs.getString("linkState");
                a1.add(temp);
    //          check=check+" entry added in array list"+temp.node;
               
            if (a2.contains(temp.node)) {
                Menu(temp.node);

            }
 }catch(Exception e){//check=check+e;
 }
            }
             else return;
            }
 else flag=0;



        } catch (SQLException ex) {

        }
        c.putConnection(conn);
        }



    }

    public ArrayList<String> getParents(){

         ArrayList<String> a2=new ArrayList<String>()  ;
      try{
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
             String sql = "select distinct parent from menu";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
             a2.add(rs.getString("parent"));
            }
            }catch(Exception e){
            }
            c.putConnection(conn);
            return a2;

    }



}
