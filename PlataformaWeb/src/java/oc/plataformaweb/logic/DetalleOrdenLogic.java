
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

    public boolean insertDetalleOrdenBool(int p_iIdArticulo1 , double p_dTotal, int p_iIdArticulo2, int p_iIdArticulo3, int p_iIdArticulo4, int p_iIdArticulo5, int p_iIdArticulo6, int p_iIdArticulo7, int p_iIdArticulo8, int p_iIdArticulo9, int p_iIdArticulo10)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`detalleorden`\n" +
                        "(`id`,`idarticulo1`,`total`,`idarticulo2`,`idarticulo3`,`idarticulo4`,`idarticulo5`,`idarticulo6`,\n" +
                        "`idarticulo7`,`idarticulo8`,`idarticulo9`,`idarticulo10`,`total`,`idarticulo1`)"
                + "VALUES(0,"+p_iIdArticulo1+","+p_dTotal+","+p_iIdArticulo2+","+p_iIdArticulo3+","+p_iIdArticulo4+",\n" +
                ""+p_iIdArticulo5+","+p_iIdArticulo6+","+p_iIdArticulo7+","+p_iIdArticulo8+","+p_iIdArticulo9+","+p_iIdArticulo10+");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertDetalleOrdenRows(int p_iIdArticulo1 , double p_dTotal, int p_iIdArticulo2, int p_iIdArticulo3, int p_iIdArticulo4, int p_iIdArticulo5, int p_iIdArticulo6, int p_iIdArticulo7, int p_iIdArticulo8, int p_iIdArticulo9, int p_iIdArticulo10)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`detalleorden`\n" +
                        "(`id`,`idarticulo1`,`total`,`idarticulo2`,`idarticulo3`,`idarticulo4`,`idarticulo5`,`idarticulo6`,\n" +
                        "`idarticulo7`,`idarticulo8`,`idarticulo9`,`idarticulo10`,`total`,`idarticulo1`)"
                + "VALUES(0,"+p_iIdArticulo1+","+p_dTotal+","+p_iIdArticulo2+","+p_iIdArticulo3+","+p_iIdArticulo4+",\n" +
                ""+p_iIdArticulo5+","+p_iIdArticulo6+","+p_iIdArticulo7+","+p_iIdArticulo8+","+p_iIdArticulo9+","+p_iIdArticulo10+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    /*public ArrayList<DetalleOrdenObj> getAllDetallesOrden() 
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

    public int deleteDetalleOrdenRows(int idproducto, int idorden) 
    {
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.detalleorden "
                + "where idproducto="+idproducto+" and idorden="+idorden+"";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public DetalleOrdenObj getDetalleOrdenById(int idproducto,int idorden)
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
*/
    
}
