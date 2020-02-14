/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.app;
import com.google.gson.Gson;
import java.util.ArrayList;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
import edu.escuelaing.arep.model.MergeSort;
import org.json.JSONObject;


/**
 *
 * @author david.caycedo
 */
public class SparkWeb {
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (Request req, Response res) -> {res.type("application/json");
             return resultsPage(req, res);
                    });
            
    }   
    

    
     private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Taller 2 AREP</h2>"
                + "<form action=\"/results\">"
                + " Ingrese los numeros separados por coma (,) :<br>"
                + "  <input type=\"text\" name=\"lista\" >"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Ordenar\">"
                + "</form>"
                + "<p>If you click the \"Calcular\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    
     private static JSONObject resultsPage(Request req, Response res) {
        ArrayList<Integer> datos;
        datos = new ArrayList<Integer>();
        JSONObject jo = new JSONObject(); 


        String numeros= req.queryParams("lista");
        String[] numerosLista = numeros.split(",");
        int sum=0;
        for (String p:numerosLista){
            datos.add(Integer.parseInt(p));
            
        }
        int[] arreglo = datos.stream().mapToInt(i -> i).toArray();
         for (int p:arreglo){
           sum+=p;            
        }
        
        MergeSort.mergeSort(arreglo,arreglo.length);

        
        jo.put("Lista",arreglo);
        jo.put("Sumatoria",sum);
        return jo;
     }
     
    static int getPort() {
    if (System.getenv("PORT") != null) {
    return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; //returns default port if heroku-port isn't set
   
    }

   
    
}
