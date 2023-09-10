/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jwt.cookie.controllers;

/**
 *
 * @author MINEDUCYT
 */
public class Constants {
    
    public static String GOOGLE_CLIENT_ID = "944298047916-9523mfs19e1kltq95smrikn309v42p5c.apps.googleusercontent.com";

    public static String GOOGLE_CLIENT_SECRET = "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";

    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/JWT-COOKIE.AppWeb/GoogleCallBackServlet";

    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v3/userinfo?access_token=";
    
    public static String GOOGLE_LINK_GET_USER_EMAIL = "https://www.googleapis.com/oauth2/v3/userinfo.email?access_token=";

    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}




//http://localhost:8080/LoginGoogle/LoginGoogleHandler
//https://www.googleapis.com/oauth2/v1/userinfo?access_token=