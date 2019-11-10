/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabrielprieto
 */
public class Manufacturer {
    private int id;
    private String name;
    private String email;
    
    
    public static ArrayList<Manufacturer> getList() throws Exception{
        ArrayList<Manufacturer> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        String sql = "SELECT MANUFACTURER_ID, NAME, EMAIL FROM MANUFACTURER";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Manufacturer m = new Manufacturer(
                    rs.getInt("MANUFATURER_ID"),
                    rs.getString("NAME"),
                    rs.getString("EMAIL")
            );
            list.add(m);
        }
        return list;
    }

    public Manufacturer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
