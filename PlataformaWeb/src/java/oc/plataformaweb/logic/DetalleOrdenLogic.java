
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

    public boolean insertDetalleOrdenBool(int p_iIdArticulo1 , double p_dTotal, int p_iIdUsuario , int p_iIdArticulo2, int p_iIdArticulo3, int p_iIdArticulo4, int p_iIdArticulo5)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`detalleorden`\n" +
        "(`id`,`idproducto1`,`idusuario`,`total`,`idproducto2`,`idproducto3`,`idproducto4`,`idproducto5`,`total`,`idproducto1`,`idusuario`)"
                + "VALUES(0,"+p_iIdArticulo1+", "+p_iIdUsuario+", "+p_dTotal+","+p_iIdArticulo2+","+p_iIdArticulo3+","+p_iIdArticulo4+",\n" +
                ""+p_iIdArticulo5+");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertDetalleOrdenRows(int p_iIdArticulo1 , double p_dTotal, int p_iIdUsuario , int p_iIdArticulo2, int p_iIdArticulo3, int p_iIdArticulo4, int p_iIdArticulo5)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`detalleorden`\n" +
        "(`id`,`idproducto1`,`idusuario`,`total`,`idproducto2`,`idproducto3`,`idproducto4`,`idproducto5`,`total`,`idproducto1`,`idusuario`)"
                + "VALUES(0,"+p_iIdArticulo1+", "+p_iIdUsuario+", "+p_dTotal+","+p_iIdArticulo2+","+p_iIdArticulo3+","+p_iIdArticulo4+",\n" +
                ""+p_iIdArticulo5+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
