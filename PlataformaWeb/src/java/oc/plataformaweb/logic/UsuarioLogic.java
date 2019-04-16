
package oc.plataformaweb.logic;

import escuadron.usuario.objetos.UsuarioObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;


public class UsuarioLogic extends Logic{

  public boolean insertClientBool(String p_strName, int p_iAge)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.client(id,name,age) "
                + "VALUES(0,'"+p_strName+"',"+p_iAge+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertClientRows(String p_strName, int p_iAge)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.client(id,name,age) "
                + "VALUES(0,'"+p_strName+"',"+p_iAge+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<UsuarioObj> getAllUsuarios() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.client ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<UsuarioObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strNombreUsuario;
            String strGenero;
            String strCorreo;
            String strContrasena;
            String strDireccion;
            
            UsuarioObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strNombreUsuario = CResult.getString("usuario");
                    strGenero = CResult.getString("genero");
                    strCorreo = CResult.getString("correo");
                    strContrasena = CResult.getString("contrasena");
                    strDireccion = CResult.getString("direccion");
                    
                    CTemp = new UsuarioObj(iId,strNombre,strApellido,strNombreUsuario,strGenero,strCorreo,strContrasena,strDireccion);
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

    public int deleteClientRows(int p_iId) 
    {
        //delete from travelsys.client where id=0;
        DatabaseX database = getDatabase();
        String strSql = "delete from travelsys.client "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public UsuarioObj getUsuarioById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.client where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        UsuarioObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            
            String strNombre; 
            String strApellido;
            String strNombreUsuario;
            String strGenero;
            String strCorreo;
            String strContrasena;
            String strDireccion;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strNombreUsuario = CResult.getString("usuario");
                    strGenero = CResult.getString("genero");
                    strCorreo = CResult.getString("correo");
                    strContrasena = CResult.getString("contrasena");
                    strDireccion = CResult.getString("direccion");
                    
                    CTemp = new UsuarioObj(iId, strNombre, strApellido, strNombreUsuario, strGenero, strCorreo, strContrasena, strDireccion);
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
