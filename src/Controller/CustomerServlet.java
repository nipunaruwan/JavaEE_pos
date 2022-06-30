package Controller;

import db.Dbconnection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Customer")
public class CustomerServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("txtCusID");
        String name = req.getParameter("txtCusName");
        String address = req.getParameter("txtaddress");
        String contact = req.getParameter("txtcontact");

        Connection connection = Dbconnection.getdbconnection().getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("insert into Customer VALUE (?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,address);
            pst.setString(4,contact);


            PrintWriter writer = resp.getWriter();
           if (pst.executeUpdate()>0){

               writer.write("Customer save sucess");

           }else {
               writer.write("try again");
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jsonObject = Json.createReader(req.getReader()).readObject();
        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        String address = jsonObject.getString("address");
        String contact = jsonObject.getString("contact");



        Connection connection = Dbconnection.getdbconnection().getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("UPDATE Customer SET name=?, address=?, contact=? WHERE id=? ");
            pst.setString(1,name);
            pst.setString(2,address);
            pst.setString(3,contact);
            pst.setString(4,id);


            PrintWriter writer = resp.getWriter();
            if (pst.executeUpdate()>0){

                writer.write("Customer update sucess");

            }else {
                writer.write("try again");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("customerid");
        System.out.println(id);
        Connection connection = Dbconnection.getdbconnection().getConnection();

        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("DELETE from `Customer`  WHERE id=? ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       // System.out.println("before");
        try {
         pst.setString(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       // System.out.println("after");
            PrintWriter writer = resp.getWriter();
        try {
            if (pst.executeUpdate()>0){

                writer.write("Customer Deleted");

            }else {
                writer.write("try again");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
