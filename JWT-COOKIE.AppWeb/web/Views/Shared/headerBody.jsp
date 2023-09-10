<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.utils.Utilidad"%>
<nav>
    <div class="nav-wrapper blue">
        <a href="Home" class="brand-logo">JWT-COOKIE System</a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>       
        <ul class="right hide-on-med-and-down"> 
            <li><a href="https://accounts.google.com/o/oauth2/auth?scope=openid%20profile%20email&?&redirect_uri=http://localhost:8080/JWT-COOKIE.AppWeb/GoogleCallBackServlet&response_type=code&client_id=944298047916-9523mfs19e1kltq95smrikn309v42p5c.apps.googleusercontent.com&approval_prompt=force"
                   >Iniciar con Google</a></li>     
            <li><a href="">Inicio</a></li>
            <li><a href="User">Usuarios</a></li>          
        </ul>
    </div>
</nav>

<ul class="sidenav" id="mobile-demo">
      <li><a href="">Inicio</a></li>
    <li><a href="User">Usuarios</a></li>  
</ul>
