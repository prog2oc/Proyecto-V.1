package oc.plataformaweb.logic;
/**
 * @author Gabriela Centeno
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.OrdenObj;


public class OrdenLogic extends Logic{

  public boolean insertNuevaOrdenBool(int p_id, int p_fecha_orden, int p_fecha_entrega, int p_idusuario)
    { 
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.orden(id, fecha_orden, fecha_entrega, idusuario)"
                + "VALUES('"+p_id+"','"+p_fecha_orden+"','"+p_fecha_entrega+"','"+p_idusuario+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertNuevaOrdenRows(int p_id, int p_fecha_orden, int p_fecha_entrega, int p_idusuario)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.orden(id, fecha_orden, fecha_entrega, idusuario)"
                + "VALUES('"+p_id+"','"+p_fecha_orden+"','"+p_fecha_entrega+"','"+p_idusuario+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<OrdenObj> getAllUsuarios() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.orden ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<OrdenObj> CArray = null;
        
        if(CResult!=null)
        {
            int id;
            int fecha_orden;
            int fecha_entrega;
            int idusuario;
            
            OrdenObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                     id = CResult.getInt("id");
                     fecha_orden = CResult.getInt("fecha_orden");
                     fecha_entrega = CResult.getInt("fecha_entrega");
                     idusuario = CResult.getInt("idusuario");
                                         
                    CTemp = new OrdenObj(id, fecha_orden, fecha_entrega, idusuario);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OrdenLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteOrdenRows(int id, int idusuario) 
    {
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.detalleorden "
                + "where id="+id+" and idusuario="+idusuario+"";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public OrdenObj getNuevaOrdenById(int id,int idusuario)
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.detalleorden where id="+id+" and idorden="+idusuario+"";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        
        OrdenObj CTemp = null;
        
        if(CResult!=null)
        {
            int fecha_orden;
            int fecha_entrega;
            
            try 
            {
                while(CResult.next())
                {
                    
                    id = CResult.getInt("id");
                    fecha_orden = CResult.getInt("fecha_orden");
                    fecha_entrega = CResult.getInt("fecha_entrega");
                    idusuario = CResult.getInt("idusuario");
                    
                    CTemp = new OrdenObj(id, fecha_orden, fecha_entrega, idusuario);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OrdenLogic.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        return CTemp;
        
    }
}