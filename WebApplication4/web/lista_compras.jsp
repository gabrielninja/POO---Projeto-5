<%-- 
    Document   : lista_compras
    Created on : Nov 10, 2019, 8:24:24 PM
    Author     : gabrielprieto
--%>
<%@page import="br.com.fatecpg.db.Lista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <%try{%>
        <table border="1">
            <tr> 
                <a href="lista_compras.jsp">Compras</a></h2>
                <th>Id</th>
                

            </tr>
           <%for(Lista lis: Lista.getList(String.Parse(getParameter("customer_id")))){%>
            <tr >
                <td><%= lis.getCustomer_id()%></td>
               
            </tr>
            <%}%>
        </table> 
        <%}catch (Exception ex){%>
            <tr><td colspan="5"><%= ex.getMessage()%></td></tr>
        <%}%>
    </body>
</html>