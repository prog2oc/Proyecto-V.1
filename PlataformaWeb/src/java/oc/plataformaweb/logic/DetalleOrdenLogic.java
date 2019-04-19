
package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.DetalleOrdenObj;


public class DetalleOrdenLogic extends Logic
{

    public boolean insertNuevaOrdenBool(int p_idproducto, int p_idorden, int p_cantidad,double p_descuento)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.detalleorden (idproducto, idorden, cantidad, descuento)"
                + "VALUES('"+p_idproducto+"','"+p_idorden+"','"+p_cantidad+"','"+p_descuento+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertNuevaOrdenRows(int p_idproducto, int p_idorden, int p_cantidad,double p_descuento)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.detalleorden (idproducto, idorden, cantidad, descuento)"
                + "VALUES('"+p_idproducto+"','"+p_idorden+"','"+p_cantidad+"','"+p_descuento+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<DetalleOrdenObj> getAllUsuarios() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.detalleorden ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<DetalleOrdenObj> CArray = null;
        
        if(CResult!=null)
        {
            int idproducto;
            int idorden;
            int cantidad;
            double descuento;
            
            DetalleOrdenObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                     idproducto = CResult.getInt("idproducto");
                     idorden = CResult.getInt("idorden");
                     cantidad = CResult.getInt("cantidad");
                     descuento = CResult.getDouble("descuento");
                                         
                    CTemp = new DetalleOrdenObj(idproducto, idorden, cantidad, descuento);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteNuevaOrdenRows(int idproducto, int idorden) 
    {
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.detalleorden "
                + "where idproducto="+idproducto+" and idorden="+idorden+"";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public DetalleOrdenObj getNuevaOrdenById(int idproducto,int idorden)
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.detalleorden where id="+idproducto+" and idorden="+idorden+"";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        DetalleOrdenObj CTemp = null;
        
        if(CResult!=null)
        {
            
            int cantidad;
            double descuento;
            
            try 
            {
                while(CResult.next())
                {
                    
                    idproducto = CResult.getInt("idproducto");
                    idorden = CResult.getInt("idorden");
                    cantidad = CResult.getInt("cantidad");
                    descuento = CResult.getDouble("descuento");
                    
                    CTemp = new DetalleOrdenObj(idproducto, idorden, cantidad, descuento);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        return CTemp;
        
    }
    
}
