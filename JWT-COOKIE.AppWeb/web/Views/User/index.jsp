<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.User"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<User> usuarios = (ArrayList<User>) request.getAttribute("usuarios");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (usuarios == null) {
        usuarios = new ArrayList();
    } else if (usuarios.size() > numReg) {
        double divNumPage = (double) usuarios.size() / (double) numReg;
        numPage = (int) Math.ceil(divNumPage);
    }
    String strTop_aux = request.getParameter("top_aux");
    int top_aux = 10;
    if (strTop_aux != null && strTop_aux.trim().length() > 0) {
        top_aux = Integer.parseInt(strTop_aux);
    }
%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Buscar Usuario</title>

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Buscar Usuario</h5>
            <form action="User" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtLogin" type="text" name="email">
                        <label for="txtEmail">Email</label>
                    </div>              
                    <div class="input-field col l4 s12">
                        <input  id="txtUserName" type="text" name="login">
                        <label for="txtUserName">UserName</label>
                    </div> 
   
                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Shared/selectTop.jsp">
                            <jsp:param name="top_aux" value="<%=top_aux%>" />                        
                        </jsp:include>                        
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">search</i>Buscar</button>
                        <a href="User?accion=create" class="waves-effect waves-light btn blue"><i class="material-icons right">add</i>Crear</a>                          
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col l12 s12">
                    <div style="overflow: auto">
                        <table class="paginationjs">
                            <thead>
                                <tr>                                     
                                    <th>Nombre</th>  
                                    <th>Apellido</th> 
                                    <th>Email</th>  
                                    <th>UserName</th>  
                                </tr>
                            </thead>                       
                            <tbody>                           
                                <% for (User usuario : usuarios) {
                                        int tempNumPage = numPage;
                                        if (numPage > 1) {
                                            countReg++;
                                            double divTempNumPage = (double) countReg / (double) numReg;
                                            tempNumPage = (int) Math.ceil(divTempNumPage);
                                    }
                                %>
                                <tr data-page="<%= tempNumPage%>">                                    
                                    <td><%=usuario.getName()%></td>  
                                    <td><%=usuario.getLastName()%></td>
                                    <td><%=usuario.getEmail()%></td>  
                                    <td><%=usuario.getUserName()%></td> 
                                    <td>
                                        <div style="display:flex">
                                             <a href="User?accion=edit&id=<%=usuario.getId()%>" title="Modificar" class="waves-effect waves-light btn green">
                                            <i class="material-icons">edit</i>
                                        </a>
                                        <a href="User?accion=details&id=<%=usuario.getId()%>" title="Ver" class="waves-effect waves-light btn blue">
                                            <i class="material-icons">description</i>
                                        </a>
                                        <a href="User?accion=delete&id=<%=usuario.getId()%>" title="Eliminar" class="waves-effect waves-light btn red">
                                            <i class="material-icons">delete</i>
                                        </a>    
                                        </div>                                                                    
                                    </td>                                   
                                </tr>
                                <%}%>                                                       
                            </tbody>
                        </table>
                    </div>                  
                </div>
            </div>             
            <div class="row">
                <div class="col l12 s12">
                    <jsp:include page="/Views/Shared/paginacion.jsp">
                        <jsp:param name="numPage" value="<%= numPage%>" />                        
                    </jsp:include>
                </div>
            </div>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>