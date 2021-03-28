/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.util.List;
import modelos.Personas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USUARIOTC
 */
public class Personasdao {
    
    public List<Personas> returndatos(){
        List<Personas> listaPersonas= null;
        Session section = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = section.beginTransaction();
        
        String query = "from Personas";
        
        try{
            listaPersonas = section.createQuery(query).list();
            ts.commit();
            section.close();
        }catch (HibernateException ex){
            System.out.println("Error en consulta"+ex.getMessage());
        }
        return listaPersonas;
    }
}
