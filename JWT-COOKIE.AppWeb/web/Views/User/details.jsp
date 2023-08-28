<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.User"%>
<% User usuario = (User) request.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Detalles de Usuario</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Detalle de Usuario</h5>
             <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" value="<%=usuario.getName()%>" disabled>
                        <label for="txtNombre">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtApellido" type="text" value="<%=usuario.getLastName()%>" disabled>
                        <label for="txtApellido">Apellido</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtEmail" type="text" value="<%=usuario.getEmail()%>" disabled>
                        <label for="txtEmail">Email</label>
                    </div>                     
                    
                    <div class="input-field col l4 s12">
                        <input id="txtUserName" type="text" value="<%=usuario.getUserName() %>" disabled>
                        <label for="txtUserName">Nombre de Uusario</label>
                    </div> 
                </div>

                <div class="row">
                    <div class="col l12 s12">
                         <a href="User?accion=edit&id=<%=usuario.getId()%>" class="waves-effect waves-light btn blue"><i class="material-icons right">edit</i>Ir modificar</a>            
                        <a href="User" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />         
    </body>
</html>
