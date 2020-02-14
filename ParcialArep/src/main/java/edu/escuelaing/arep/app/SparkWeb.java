/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.app;
import static spark.Spark.*;

/**
 *
 * @author david.caycedo
 */
public class SparkWeb {
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> "Hello Heroku");
 }
    
    
    static int getPort() {
    if (System.getenv("PORT") != null) {
    return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; //returns default port if heroku-port isn't set
   
    }
    
    
}
