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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

//    private User obtenerUsuario(HttpServletRequest request) {
//        // Obtener el parámetro accion del request
//        String accion = Utilidad.getParameter(request, "accion", "index");
//        User usuario = new User();
//        // Obtener el parámetro nombre del request  y asignar ese valor a la propiedad Nombre de Usuario.
//        usuario.setName(Utilidad.getParameter(request, "nombre", ""));
//        // Obtener el parámetro apellido del request  y asignar ese valor a la propiedad Apellido de Usuario.
//        usuario.setLastName(Utilidad.getParameter(request, "apellido", ""));
//        // Obtener el parámetro login del request  y asignar ese valor a la propiedad Login de Usuario.
//        usuario.setEmail(Utilidad.getParameter(request, "email", ""));
//        // Obtener el parámetro idRol del request  y asignar ese valor a la propiedad IdRol de Usuario.
//        usuario.setUserName(Utilidad.getParameter(request, "username", ""));
//        // Obtener el parámetro estatus del request  y asignar ese valor a la propiedad Estatus de Usuario.
//        if (accion.equals("index")) {
//            // Obtener el parámetro top_aux del request  y asignar ese valor a la propiedad Top_aux de Usuario.
//            usuario.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
//            usuario.setTop_aux(usuario.getTop_aux() == 0 ? Integer.MAX_VALUE : usuario.getTop_aux());
//        }
//        if (accion.equals("login") || accion.equals("create") || accion.equals("cambiarpass")) {
//            // Obtener el parámetro password del request  y asignar ese valor a la propiedad Password de Usuario.
//            usuario.setPassword(Utilidad.getParameter(request, "password", ""));
//            // Obtener el parámetro confirmPassword_aux del request  y asignar ese valor a la propiedad ConfirmPassword_aux de Usuario.
//            usuario.setConfirmarPassword_aux(Utilidad.getParameter(request, "confirmPassword_aux", ""));
//            if (accion.equals("cambiarpass")) {
//                // Obtener el parámetro id del request  y asignar ese valor a la propiedad Id de Usuario.
//                usuario.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
//            }
//        } else {
//            // Obtener el parámetro id del request  y asignar ese valor a la propiedad Id de Usuario.
//            usuario.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
//        }
//        // Devolver la instancia de la entidad Usuario con los valores obtenidos del request.
//        return usuario;
//    }
//    
//    private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            User usuario = new User(); // Crear una instancia  de la entidad de Usuario.
//            usuario.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de Usuario.
//            // Ir a la capa de acceso a datos y buscar los registros de Usuario y asociar Rol.
//            ArrayList<User> usuarios = UserDAL.obtenerTodos();
//            // Enviar los usuarios al jsp utilizando el request.setAttribute con el nombre del atributo usuario.
//            request.setAttribute("usuarios", usuarios);
//            // Enviar el Top_aux de Usuario al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
//            request.setAttribute("top_aux", usuario.getTop_aux());
//            request.getRequestDispatcher("Views/User/index.jsp").forward(request, response); // Direccionar al jsp index de Usuario.
//        } catch (Exception ex) {
//            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
//        }
//    }
//    
//    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            User usuario = obtenerUsuario(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
//            // Ir a la capa de acceso a datos y buscar los registros de Usuario y asociar Rol.
//            ArrayList<User> usuarios = UserDAL.obtenerTodos();
//            // Enviar los usuarios al jsp utilizando el request.setAttribute con el nombre del atributo usuario.
//            request.setAttribute("usuarios", usuarios);
//            // Enviar el Top_aux de Usuario al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
//            request.setAttribute("top_aux", usuario.getTop_aux());
//            request.getRequestDispatcher("Views/User/index.jsp").forward(request, response); // Direccionar al jsp index de Usuario.
//        } catch (Exception ex) {
//            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
//        }
//    }
//    
//    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // direccionar al jsp create de Usuario
//        request.getRequestDispatcher("Views/User/create.jsp").forward(request, response);
//    }
//    
//    
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
