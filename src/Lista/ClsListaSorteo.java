/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Utilerias.Personasdao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelos.Personas;

/**
 *
 * @author USUARIOTC
 */
public class ClsListaSorteo {
    
     //aqui guardaremos los nombres 
        private List<String> llenarDatos(){
        Personasdao op2= new Personasdao();
        
        List<Personas> list = op2.returndatos();
        ArrayList<String> devuelve = new ArrayList<String>();
        for (Personas datos : list){
            devuelve.add(datos.getNombre());
            //System.out.println(datos.getNombre());
        }
        return devuelve;   
    }  
        
        
       public void sorteo() throws IOException{
           
        BufferedReader leer;
        leer = new BufferedReader(new InputStreamReader(System.in));//convierte un byte a un char
        String anws = "";
        List<String> listanombre = llenarDatos(); 
        List<String> ganadores = null;
        int cont=0;
        int i=0;
        
        do {
            
            System.out.println("\n--Sorteo 10 ganadores--");
            System.out.println("1- Mostrar nombres ganadores");
            System.out.println("2- Mostrar tabla con nombres");   
            anws = leer.readLine();
            
            
            if ("1".equals(anws)){
                System.out.println("\nPersonas Ganadoras!!");
                for (i = 0; i<10;i++){//y agarra 10 al azar
                    Collections.shuffle(listanombre);//desordena los nombres
                    System.out.println("Ganador No."+(i+1+" es "+listanombre.get(0)));
                    listanombre.remove(0);
                }
                //listanombre.remove(0);
                //Collections.sort(listanombre);
                //System.out.println("Personas a participar"+"\n "+listanombre);
               
            }           
            if ("2".equals(anws)){
                Collections.sort(listanombre);
                //listanombre.remove(i);
                //System.out.println("\nPersonas a participar"+listanombre+"\n ");          
                System.out.println("\nPersonas a participar");  
                for (String p : listanombre){//saca los nombres de las personas
                    cont--;
                    System.out.print("\n("+cont+")"+" "+p);
                }              
            }
        }while("1".equals(anws) || "2".equals(anws));        
    }                      
}
        
        
