<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.User"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Registrar Usuario</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Crear Usuario</h5>
            <form action="User" method="post" onsubmit="return  validarFormulario()">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                        <span id="txtNombre_error" style="color:red" class="helper-text"></span>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtApellido" type="text" name="apellido" required class="validate" maxlength="30">
                        <label for="txtApellido">Apellido</label>
                        <span id="txtApellido_error" style="color:red" class="helper-text"></span>
                    </div>
                    <div class="input-field col l4 s12">
                        <input  id="txtEmail" type="text" name="email" required class="validate" maxlength="30">
                        <label for="txtEmail">Email</label>
                        <span id="txtEmail_error" style="color:red" class="helper-text"></span>
                    </div>
                    <div class="input-field col l4 s12">
                        <input  id="txtUserName" type="text" name="username" required class="validate" maxlength="30">
                        <label for="txtUserName">Usuario</label>
                    </div>
                    <div class="input-field col l4 s12">
                        <input  id="txtPassword" type="password" name="password" required class="validate" minlength="5" maxlength="32">
                        <label for="txtPassword">Password</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtConfirmPassword_aux" type="password" name="confirmPassword_aux" required class="validate" minlength="5" maxlength="32">
                        <label for="txtConfirmPassword_aux">Confirmar password</label>
                        <span id="txtConfirmPassword_aux_error" style="color:red" class="helper-text"></span>
                    </div> 
                    
                    </div>
                  
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="Usuario" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />    
        
       <script>   
            function validarFormulario() {
                var result = true;
                var txtPassword = document.getElementById("txtPassword");
                var txtConfirm_password = document.getElementById("txtConfirmPassword_aux");
                var txtConfirm_password_error = document.getElementById("txtConfirmPassword_aux_error");
                if (txtPassword.value !== txtConfirm_password.value) {
                    txtConfirm_password_error.innerHTML = "El password y confirmar password debe ser iguales";
                    result = false;
                } else {
                    txtConfirm_password_error.innerHTML = "";
                }
                if (txtNombre.value == 0) {
                    txtNombre_error.innerHTML = "El nombre es obligatorio";
                    result = false;
                } else {
                    txtNombre_error.innerHTML = "";
                }
                if (txtApellido.value == 0) {
                    txtApellido_error.innerHTML = "El apellido es obligatorio";
                    result = false;
                } else {
                    txtApellido_error.innerHTML = "";
                }
                return result;
            }
            
        </script>
    </body>
</html>
//

