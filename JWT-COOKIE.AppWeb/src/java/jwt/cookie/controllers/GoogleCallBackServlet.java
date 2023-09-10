/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jwt.cookie.controllers;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.Cookie;

import org.apache.http.client.ClientProtocolException;


import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import java.io.IOException;
import org.apache.http.client.fluent.Form;

/**
 *
 * @author MINEDUCYT
 */
@WebServlet(name = "GoogleCallBackServlet", urlPatterns = {"/GoogleCallBackServlet"})
public class GoogleCallBackServlet extends HttpServlet {
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDTO user = getUserInfo(accessToken);
//                UserGoogleDTO email = getUserEmail(accessToken);
                System.out.println("Inforomacion del usuario");
		System.out.println(user);
//                System.out.println(email);
                
                //
                request.setAttribute("user", user);
//                request.setAttribute("email", email);
                request.getRequestDispatcher("Views/GoogleLogin/UserInfo.jsp").forward(request, response);
	}
     
     public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
        // Construir el cuerpo de la solicitud POST como una cadena JSON
//        String requestBody = "{"
//                + "\"client_id\":\"" + Constants.GOOGLE_CLIENT_ID + "\","
//                + "\"client_secret\":\"" + Constants.GOOGLE_CLIENT_SECRET + "\","
//                + "\"redirect_uri\":\"" + Constants.GOOGLE_REDIRECT_URI + "\","
//                + "\"code\":\"" + code + "\","
//                + "\"grant_type\":\"" + Constants.GOOGLE_GRANT_TYPE + "\""
//                + "}";
//
//        // Crear una entidad de cadena JSON
//        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
//
//        // Realizar la solicitud POST para obtener el token
//        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
//                .body(entity)
//                .execute()
//                .returnContent()
//                .asString();
//
//        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//        return accessToken;

          String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                 .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                         .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                         .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                         .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                 .execute().returnContent().asString();

         JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
         String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
         return accessToken;
    }
     
    private void cookies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    System.out.println("User already logged in");
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
        }
    }
	
     
     public static UserGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);

		return googlePojo;
	}
     
//      public static UserGoogleDTO getUserEmail(final String accessToken) throws ClientProtocolException, IOException {
//		String link = Constants.GOOGLE_LINK_GET_USER_EMAIL + accessToken;
//		String response = Request.Get(link).execute().returnContent().asString();
//
//		UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);
//
//		return googlePojo;
//	}
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            //cookies(request, response);
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    

    // </editor-fold>


