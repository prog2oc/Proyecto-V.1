package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.CategoriaObj;

public class CategoriaLogic extends Logic
{
public boolean insertCategoriaBool(String p_strNombre, String p_strDescripcion)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.categoria(id,nombre,descripcion) "
                + "VALUES(0,'"+p_strNombre+"','"+p_strDescripcion+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertCategoriaRows(String p_strNombre, String p_strDescripcion)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.categoria(id,nombre,descripcion) "
                + "VALUES(0,'"+p_strNombre+"','"+p_strDescripcion+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<CategoriaObj> getAllCategorias() 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.categoria; ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CategoriaObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescripcion;
            
            CategoriaObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strDescripcion = CResult.getString("descripcion");
                    
                    CTemp = new CategoriaObj(iId, strName, strDescripcion);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CategoriaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteCategoriaRows(int p_iId) 
    {
        //delete from travelsys.client where id=0;
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.Categoria "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public CategoriaObj getCategoriaById(int p_iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.categoria where id= "+p_iId+" ;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CategoriaObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescripcion;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strDescripcion = CResult.getString("descripcion");
                    
                    
                    CTemp = new CategoriaObj(iId, strName, strDescripcion);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CategoriaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateCategoriaRows(int p_iId, String p_strNombre, String p_strDescripcion) 
    {
        
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.Categoria set nombre= '"+p_strNombre+"' ,descripcion = '"+p_strDescripcion+"' "
                + "WHERE id= "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }    
}
