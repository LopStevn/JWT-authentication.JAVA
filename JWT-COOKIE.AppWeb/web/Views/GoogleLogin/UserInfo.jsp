<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jwt.cookie.controllers.UserGoogleDTO"%>
<%@page import="jwt.cookie.utils.Utilidad"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/Views/Shared/title.jsp" />
    <title>Información de Usuario</title>
</head>
<body>
    <jsp:include page="/Views/Shared/headerBody.jsp" />
    <h1>Información de Usuario</h1>
    <%
        // Obtener la información del usuario del atributo de sesión configurado en el servlet
        UserGoogleDTO user = (UserGoogleDTO) request.getAttribute("user");
     

        if (user != null) {
    %>
    
    <h5>Nombre: <%= user.getName() %></h5>
    <h5>Email: <%= user.getEmail() %></h5>
    <img src="<%= user.getPicture() %>" alt="Foto de perfil">
    <%
        } else {
    %>
    <p>No se pudo obtener la información del usuario.</p>
    <%
        }
    %>
    <jsp:include page="/Views/Shared/footerBody.jsp" />      
</body>

</html>
