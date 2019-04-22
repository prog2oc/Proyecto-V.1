package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.TipoPublicidadObj;

public class TipoPublicidadLogic extends Logic {
    
    public ArrayList<TipoPublicidadObj> getAllTipoPublicidad(){
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.tipopublicidad ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        ArrayList<TipoPublicidadObj> PArray = null;
        
     if(PResult!=null)
        {
            int iId;
            String strName;
            String strDescription;
            
            TipoPublicidadObj PTemp;
            PArray = new ArrayList<>();
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strName = PResult.getString("nombre");
                    strDescription = PResult.getString("descripcion");
                    
                    PTemp = new TipoPublicidadObj(iId, strName, strDescription);
                    PArray.add(PTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TipoPublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PArray;        
    }
    public int insertTipoPublicidadRows(String p_strName, String p_strDescription) 
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.tipopublicidad(id,nombre,descripcion) "
                + "VALUES(0,'"+p_strName+"','"+p_strDescription+"'); ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
     public int deleteTipoPublicidadRows(int p_iId) 
    {
        //delete from travelsys.client where id=0;
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.tipopublicidad "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
     public TipoPublicidadObj getTipoPublicidadById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.tipopublicidad "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet PResult = database.executeQuery(strSql);
        TipoPublicidadObj PTemp = null;
        
        if(PResult!=null)
        {
            int iId;
            String strName;
            String strDescription;
            
            try 
            {
                while(PResult.next())
                {
                    iId = PResult.getInt("id");
                    strName = PResult.getString("nombre");
                    strDescription = PResult.getString("descripcion");
                    
                    PTemp = new TipoPublicidadObj(iId, strName, strDescription);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TipoPublicidadLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return PTemp;
    }

      public int updateTipoPublicidadRows(int p_iId, String p_strName, String p_strDescription) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update ocplataformaweb.tipopublicidad "
                + "set nombre = '"+p_strName+"',descripcion = '"+p_strDescription+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}