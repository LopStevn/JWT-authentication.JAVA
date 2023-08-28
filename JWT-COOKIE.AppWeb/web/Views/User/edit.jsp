<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.User"%>
<% User usuario = (User) request.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar Usuario</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Editar Usuario</h5>
            <form action="User" method="post" onsubmit="return  validarFormulario()">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <input type="hidden" name="id" value="<%=usuario.getId()%>">  
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" value="<%=usuario.getName()%>" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtApellido" type="text" name="apellido" value="<%=usuario.getLastName()%>" required class="validate" maxlength="30">
                        <label for="txtApellido">Apellido</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtEmail" type="text" name="email" value="<%=usuario.getEmail()%>" required  class="validate" maxlength="25">
                        <label for="txtEmail">Email</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtUsername" type="text" name="username" value="<%=usuario.getUserName()%>" required  class="validate" maxlength="25">
                        <label for="txtUsername">Nombre de Usuario</label>
                    </div>                                          
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="User" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
        <script>
            function validarFormulario() {
                var result = true;
                var slEstatus = document.getElementById("slEstatus");
                var slEstatus_error = document.getElementById("slEstatus_error");
                var slRol = document.getElementById("slRol");
                var slRol_error = document.getElementById("slRol_error");
                
                if (slRol.value == 0) {
                    slRol_error.innerHTML = "El Rol es obligatorio";
                    result = false;
                } else {
                    slRol_error.innerHTML = "";
                }

                return result;
            }
        </script>
    </body>
</html>
