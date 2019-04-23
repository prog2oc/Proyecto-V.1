/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.PublicidadObj;
import oc.plataformaweb.objects.TipoPublicidadObj;

/**
 *
 * @author erick
 */
public class PublicidadLogic extends Logic 
{

    public ArrayList<PublicidadObj> getAllPublicidad(){
        
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.publicidad ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        ArrayList<PublicidadObj> PArray = null;
        
     if(PResult!=null)
        {
            int iId;
            String strImagen;
            int iIdTipoPublicidad;
            int iIdEmpresa;
            
            PublicidadObj PTemp;
            PArray = new ArrayList<>();
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strImagen = PResult.getString("imagen");
                    iIdTipoPublicidad = PResult.getInt("idtipopublicidad");
                    iIdEmpresa = PResult.getInt("idempresa");
                    
                    PTemp = new PublicidadObj(iId, strImagen, iIdTipoPublicidad, iIdEmpresa);
                    PArray.add(PTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PArray;        
    }
    public int insertPublicidadRows(String p_strImagen, int p_iIdTipoPublicidad, int p_iIdEmpresa) 
    {       
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.publicidad(id,imagen,idtipopublicidad,idempresa) "
                + "VALUES(0,'"+p_strImagen+"','"+p_iIdTipoPublicidad+"', '"+p_iIdEmpresa+"' ); ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
     public int deletePublicidadRows(int p_iId) 
    {
        //delete from travelsys.client where id=0;
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.publicidad "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
     public PublicidadObj getPublicidadById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.publicidad "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        PublicidadObj PTemp = null;
        
        if(PResult!=null)
        {
            int iId;
            String strImagen;
            int iIdTipoPublicidad;
            int iIdEmpresa;           
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strImagen = PResult.getString("imagen");
                    iIdTipoPublicidad = PResult.getInt("idtipopublicidad");
                    iIdEmpresa = PResult.getInt("idempresa");
                    
                    PTemp = new PublicidadObj(iId, strImagen, iIdTipoPublicidad, iIdEmpresa);                    
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PTemp;
    }

      public int updatePublicidadRows(int p_iId, int p_iIdTipoPublicidad) 
    {        
        DatabaseX database = getDatabase();
        String strSql = "update ocplataformaweb.publicidad "
                + "set idtipopublicidad = "+p_iIdTipoPublicidad+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
      
      public int updatePublicidadImagenRows(int p_iId, String p_strImagen) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.publicidad" +
                        " SET imagen = '"+ p_strImagen +
                        "' WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
      public PublicidadObj getPublicidadByIdEmpresa(int p_iIdEmpresa) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.publicidad "
                + "where idempresa="+p_iIdEmpresa+" ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        PublicidadObj PTemp = null;
        
        if(PResult!=null)
        {
            int iId;
            String strImagen;
            int iIdTipoPublicidad;
            int iIdEmpresa;           
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strImagen = PResult.getString("imagen");
                    iIdTipoPublicidad = PResult.getInt("idtipopublicidad");
                    iIdEmpresa = PResult.getInt("idempresa");
                    
                    PTemp = new PublicidadObj(iId, strImagen, iIdTipoPublicidad, iIdEmpresa);                    
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PTemp;
    }
      
      public ArrayList<PublicidadObj> getAllPublicidadByEmpresa(int iIdEmpresa){
        
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.publicidad where idempresa= "+iIdEmpresa+" ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        ArrayList<PublicidadObj> PArray = null;
        
     if(PResult!=null)
        {
            int iId;
            String strImagen;
            int iIdTipoPublicidad;
            
            PublicidadObj PTemp;
            PArray = new ArrayList<>();
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strImagen = PResult.getString("imagen");
                    iIdTipoPublicidad = PResult.getInt("idtipopublicidad");
                    
                    PTemp = new PublicidadObj(iId, strImagen, iIdTipoPublicidad, iIdEmpresa);
                    PArray.add(PTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PArray;        
    }

}
