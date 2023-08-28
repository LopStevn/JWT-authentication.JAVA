/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jwt.cookie.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.util.ArrayList; // Importar la clase ArrayList
import jwt.cookie.User;
import jwt.cookie.UserDAL;
import jwt.cookie.utils.Utilidad;



/**
 *
 * @author MINEDUCYT
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/User"})
public class UserServlet extends HttpServlet {

    private User obtenerUsuario(HttpServletRequest request) {
        // Obtener el parámetro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
        User usuario = new User();
        // Obtener el parámetro nombre del request  y asignar ese valor a la propiedad Nombre de Usuario.
        usuario.setName(Utilidad.getParameter(request, "nombre", ""));
        // Obtener el parámetro apellido del request  y asignar ese valor a la propiedad Apellido de Usuario.
        usuario.setLastName(Utilidad.getParameter(request, "apellido", ""));
        // Obtener el parámetro login del request  y asignar ese valor a la propiedad Login de Usuario.
        usuario.setEmail(Utilidad.getParameter(request, "email", ""));
        // Obtener el parámetro idRol del request  y asignar ese valor a la propiedad IdRol de Usuario.
        usuario.setUserName(Utilidad.getParameter(request, "username", ""));
        // Obtener el parámetro estatus del request  y asignar ese valor a la propiedad Estatus de Usuario.
        if (accion.equals("index")) {
            // Obtener el parámetro top_aux del request  y asignar ese valor a la propiedad Top_aux de Usuario.
            usuario.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
            usuario.setTop_aux(usuario.getTop_aux() == 0 ? Integer.MAX_VALUE : usuario.getTop_aux());
        }
        if (accion.equals("login") || accion.equals("create") || accion.equals("cambiarpass")) {
            // Obtener el parámetro password del request  y asignar ese valor a la propiedad Password de Usuario.
            usuario.setPassword(Utilidad.getParameter(request, "password", ""));
            // Obtener el parámetro confirmPassword_aux del request  y asignar ese valor a la propiedad ConfirmPassword_aux de Usuario.
            usuario.setConfirmarPassword_aux(Utilidad.getParameter(request, "confirmPassword_aux", ""));
            if (accion.equals("cambiarpass")) {
                // Obtener el parámetro id del request  y asignar ese valor a la propiedad Id de Usuario.
                usuario.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
            }
        } else {
            // Obtener el parámetro id del request  y asignar ese valor a la propiedad Id de Usuario.
            usuario.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
        }
        // Devolver la instancia de la entidad Usuario con los valores obtenidos del request.
        return usuario;
    }
    
    private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = new User(); // Crear una instancia  de la entidad de Usuario.
            usuario.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de Usuario.
            // Ir a la capa de acceso a datos y buscar los registros de Usuario y asociar Rol.
            ArrayList<User> usuarios = UserDAL.obtenerTodos();
            // Enviar los usuarios al jsp utilizando el request.setAttribute con el nombre del atributo usuario.
            request.setAttribute("usuarios", usuarios);
            // Enviar el Top_aux de Usuario al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", usuario.getTop_aux());
            request.getRequestDispatcher("Views/User/index.jsp").forward(request, response); // Direccionar al jsp index de Usuario.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }
    
    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
            // Ir a la capa de acceso a datos y buscar los registros de Usuario y asociar Rol.
            ArrayList<User> usuarios = UserDAL.obtenerTodos();
            // Enviar los usuarios al jsp utilizando el request.setAttribute con el nombre del atributo usuario.
            request.setAttribute("usuarios", usuarios);
            // Enviar el Top_aux de Usuario al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", usuario.getTop_aux());
            request.getRequestDispatcher("Views/User/index.jsp").forward(request, response); // Direccionar al jsp index de Usuario.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }
    
    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direccionar al jsp create de Usuario
        request.getRequestDispatcher("Views/User/create.jsp").forward(request, response);
    }
    
    private void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request
            // Enviar los datos de Usuario a la capa de accesoa a datos para que lo almacene en la base de datos el registro.
            int result = UserDAL.crear(usuario);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron ingresados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex para que nos direcciones al jsp index
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro registrar un nuevo registro
                Utilidad.enviarError("No se logro registrar un nuevo registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    private void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
            User usuario_result = UserDAL.obtenerPorId(usuario); // Obtener desde la capa de acceso a datos el usuario por Id.
            if (usuario_result.getId() > 0) { // Si el Id es mayor a cero.
                // Enviar el atributo usuario con el valor de los datos del usuario de nuestra base de datos a un jsp
                request.setAttribute("usuario", usuario_result);
            } else {
                // Enviar al jsp de error el siguiente mensaje. El Id: ? no existe en la tabla de Usuario
                Utilidad.enviarError("El Id:" + usuario_result.getId() + " no existe en la tabla de Usuario", request, response);
            }
        } catch (Exception ex) {
            // enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    private void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el usuario al jsp de edit que se obtiene por Id
        requestObtenerPorId(request, response);
        // Direccionar al jsp edit de Usuario
        request.getRequestDispatcher("Views/User/edit.jsp").forward(request, response);
    }
    
    
    private void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
            // Enviar los datos de Usuario a la capa de accesoa a datos para modificar el registro.
            int result = UserDAL.modificar(usuario);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron modificado correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex para que nos direcciones al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro actualizar el registro.
                Utilidad.enviarError("No se logro actualizar el registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    private void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el usuario al jsp de details que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp details de Usuario.
        request.getRequestDispatcher("Views/User/details.jsp").forward(request, response);
    }
    
    private void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el usuario al jsp de delete que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp delete de Usuario.
        request.getRequestDispatcher("Views/User/delete.jsp").forward(request, response);
    }
    
    private void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
            // Enviar los datos de Usuario a la capa de accesoa a datos para que elimine el registro.
            int result = UserDAL.eliminar(usuario);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron eliminados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);  // Ir al método doGetRequestIndex para que nos direccione al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro eliminar el registro.
                Utilidad.enviarError("No se logro eliminar el registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception.
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el parámetro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
//        if (accion.equals("create")) { // Si accion es igual a login.
//            // Enviar el atributo accion al jsp de login.
//            request.setAttribute("accion", accion);
//            //doGetRequestLogin(request, response); // Ir al método doGetRequestLogin.
//        } else {
            // Utilizar el método authorize de la clase SessionUser para validar que solo usuario con permiso
            // puedan acceder al servlet de Usuario. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el usuario tiene permitido
            // acceder a este Servlet 
                // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el parámetro de accion.
                switch (accion) {
                    case "index":
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request, response); // Ir al método doGetRequestIndex.
                        break;
                    case "create":
                        // Enviar el atributo accion al jsp de create.
                        request.setAttribute("accion", accion);
                        doGetRequestCreate(request, response); // Ir al método doGetRequestCreate.
                        break;
                    case "edit":
                        // Enviar el atributo accion al jsp de edit.
                        request.setAttribute("accion", accion);
                        doGetRequestEdit(request, response); // Ir al método doGetRequestEdit.
                        break;
                    case "delete":
                        // Enviar el atributo accion al jsp de delete.
                        request.setAttribute("accion", accion);
                        doGetRequestDelete(request, response); // Ir al método doGetRequestDelete.
                        break;
                    case "details":
                        // Enviar el atributo accion al jsp de details.
                        request.setAttribute("accion", accion);
                        doGetRequestDetails(request, response); // Ir al método doGetRequestDetails.
                        break;
                    case "cambiarpass":
                        // Enviar el atributo accion al jsp de cambiarPassword.
                        request.setAttribute("accion", accion);
                        //doGetRequestCambiarPassword(request, response); // Ir al método doGetRequestCambiarPassword.
                        break;
                    default:
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        //doGetRequestIndex(request, response); // Ir al método doGetRequestIndex.
                }
        }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el parámetro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
            // Utilizar el método authorize de la clase SessionUser para validar que solo usuario con permiso
            // puedan acceder al servlet de Usuario. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el usuario tiene permitido
            // acceder a este Servlet 
                // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el parámetro de accion.
                switch (accion) {
                    case "index":
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doPostRequestIndex(request, response);  // Ir al metodo doPostRequestIndex.
                        break;
                    case "create":
                        // Enviar el atributo accion al jsp de create.
                        request.setAttribute("accion", accion);
                        doPostRequestCreate(request, response);  // Ir al metodo doPostRequestCreate.
                        break;
                    case "edit":
                        // Enviar el atributo accion al jsp de edit.
                        request.setAttribute("accion", accion);
                        doPostRequestEdit(request, response);  // Ir al metodo doPostRequestEdit.
                        break;
                    case "delete":
                        // Enviar el atributo accion al jsp de delete.
                        request.setAttribute("accion", accion);
                        doPostRequestDelete(request, response);  // Ir al metodo doPostRequestDelete.
                        break;
                    case "cambiarpass":
                        request.setAttribute("accion", accion);
                        //doPostRequestCambiarPassword(request, response);  // Ir al metodo doPostRequestCambiarPassword.
                        break;
                    default:
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request, response);  // Ir al metodo doGetRequestIndex.
                }

        }
    }
    // </editor-fold>






