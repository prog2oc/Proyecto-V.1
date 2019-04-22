package oc.plataformaweb.logic;

import oc.plataformaweb.database.DatabaseX;

public class ArticuloLogic extends Logic
{
    public boolean insertEmpresaBool(int p_iIdProducto, int p_iCantidad)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`articulo`(`id`,`idproducto`,`cantidad`)"+
        "VALUES(0,"+p_iIdProducto+","+p_iCantidad+";";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertEmpresaRows(int p_iIdProducto, int p_iCantidad)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO `ocplataformaweb`.`articulo`(`id`,`idproducto`,`cantidad`)"+
        "VALUES(0,"+p_iIdProducto+","+p_iCantidad+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
