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
public class Lista {
    private static int customer_id;
    private int product_id;
    
   public static ArrayList<Lista> getList() throws Exception{
        ArrayList<Lista> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        String sql = "SELECT P.CUSTUMER_ID, C.\"NAME\", PRO.PRODUCT_ID \n" +
                "FROM PURCHASE_ORDER AS P\n" +
                "INNER JOIN CUSTOMER AS C ON P.CUSTOMER_ID = C.CUSTOMER_ID\n" +
                "INNER JOIN PRODUCT AS PRO ON P.PRODUCT_ID = PRO.PRODUCT_ID\n" +
                "WHERE P.CUSTOMER_ID = "+customer_id+"";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Lista l = new Lista(
                    rs.getInt("PRODUCT_ID"),
                    rs.getInt("CUSTOMER_ID")         
            );
            list.add(l);
        }

    public Lista(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCliente_id() {
        return customer_id;
    }

    public void setCliente_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
}
