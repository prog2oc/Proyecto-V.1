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
import oc.plataformaweb.objects.UsuarioObj;


public class UsuarioLogic extends Logic{

    public boolean insertUsuarioBool(int p_iId, String p_strNombre, String p_strApellido, String p_strFotoPerfil, String p_strNombreUsuario, String p_strGenero, String p_strFechaNacimiento, String p_strCorreo, String p_strContrasena, String p_strDepartamento, String p_strDireccion) 
       
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.usuario (id,nombre,apellido,nombreusuario, fotoperfil, genero,fechanacimiento,correo,contraseña,departamento,direccion)"+
        "VALUES (0,'"+p_strNombre+"','"+p_strApellido+"','"+p_strNombreUsuario+"', '"+p_strFotoPerfil+"', '"+p_strGenero+"','"+p_strFechaNacimiento+"','"+p_strCorreo+"','"+p_strContrasena+"','"+p_strDepartamento+"','"+p_strDireccion+"');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }

    public int insertUsuarioRows(String p_strNombre, String p_strApellido, String p_strNombreUsuario, String p_strFotoPerfil, String p_strGenero, String p_strFechaNacimiento, String p_strCorreo, String p_strContrasena, String p_strDepartamento, String p_strDireccion)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.usuario (id,nombre,apellido,nombreusuario, fotoperfil, genero,fechanacimiento,correo,contraseña,departamento,direccion)"+
        "VALUES (0,'"+p_strNombre+"','"+p_strApellido+"','"+p_strNombreUsuario+"', '"+p_strFotoPerfil+"', '"+p_strGenero+"','"+p_strFechaNacimiento+"','"+p_strCorreo+"','"+p_strContrasena+"','"+p_strDepartamento+"','"+p_strDireccion+"');";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

     public ArrayList<UsuarioObj> getAllUsuarios() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.usuario ";
        System.out.println(strSql);
        ResultSet UResult = database.executeQuery(strSql);
        ArrayList<UsuarioObj> UArray = null;
        
        if(UResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strNombreUsuario;
            String strFotoPerfil;
            String strGenero;
            String strFechaNacimiento;
            String strCorreo;
            String strContrasena;
            String strDepartamento;
            String strDireccion;
            
            
            
            UsuarioObj UTemp;
            UArray = new ArrayList<>();
            
            try 
            {
                while(UResult.next())
                {
                    iId = UResult.getInt("id");
                    strNombre = UResult.getString("nombre");
                    strApellido = UResult.getString("apellido");
                    strNombreUsuario = UResult.getString("nombreusuario");
                    strFotoPerfil = UResult.getString("fotoperfil");
                    strGenero= UResult.getString("genero");
                    strFechaNacimiento = UResult.getString("fechanacimiento");
                    strCorreo = UResult.getString("correo");
                    strContrasena = UResult.getString("contraseña");
                    strDepartamento= UResult.getString("departamento");
                    strDireccion = UResult.getString("direccion");
                    
                    if(strFotoPerfil.equals("")){
                        strFotoPerfil = "fotodefault.png";
                    }
                    
                    UTemp = new UsuarioObj(iId, strNombre, strApellido, strNombreUsuario, strFotoPerfil, strGenero, strFechaNacimiento, strCorreo,strContrasena,strDepartamento,strDireccion);
                    UArray.add(UTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return UArray;
        
    }

    public int deleteUsuarioRows(int p_iId) 
    {
        
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.usuario "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public UsuarioObj getUsuarioById(int p_iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.usuario where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet UResult = database.executeQuery(strSql);
        UsuarioObj UTemp = null;
        
        if(UResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strNombreUsuario;
            String strFotoPerfil;
            String strGenero;
            String strFechaNacimiento;
            String strCorreo;
            String strContrasena;
            String strDepartamento;
            String strDireccion;
            
            try 
            {
                while(UResult.next())
                {
               
                    iId = UResult.getInt("id");
                    strNombre = UResult.getString("nombre");
                    strApellido = UResult.getString("apellido");
                    strNombreUsuario = UResult.getString("nombreusuario");
                    strFotoPerfil = UResult.getString("fotoperfil");
                    strGenero= UResult.getString("genero");
                    strFechaNacimiento = UResult.getString("fechanacimiento");
                    strCorreo = UResult.getString("correo");
                    strContrasena = UResult.getString("contraseña");
                    strDepartamento= UResult.getString("departamento");
                    strDireccion = UResult.getString("direccion");
                    
                    if(strFotoPerfil.equals("")){
                        strFotoPerfil = "fotodefault.png";
                    }
                    
                    UTemp = new UsuarioObj(iId, strNombre, strApellido, strNombreUsuario, strFotoPerfil, strGenero, strFechaNacimiento, strCorreo,strContrasena,strDepartamento,strDireccion);
            } 
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return UTemp;
        
    }
    
    public int updateUsuarioRows(int p_iId,String p_strNombre, String p_strApellido, String p_strNombreUsuario, String p_strGenero, String p_strFechaNacimiento, String p_strCorreo, String p_strContrasena, String p_strDepartamento, String p_strDireccion) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.usuario" +
                        " SET id = "+p_iId+",nombre = '"+p_strNombre+"',apellido = '"+p_strApellido+"',nombreusuario = '"+p_strNombreUsuario+"',genero = '"+p_strGenero+"',fechanacimiento = '"+p_strFechaNacimiento+"',correo = '"+p_strCorreo+"',contraseña ='"+p_strContrasena+"',departamento ='"+p_strDepartamento+"',direccion = '"+p_strDireccion+"'" +
                        "WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public UsuarioObj getUsuarioInfo(String p_strNombreUsuario, String p_strContrasena) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.usuario where nombreusuario= '"+p_strNombreUsuario
                +"' AND contraseña = '"+ p_strContrasena +"' ";
        System.out.println(strSql);
        ResultSet UResult = database.executeQuery(strSql);
        UsuarioObj UTemp = null;
        
        if(UResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strNombreUsuario;
            String strFotoPerfil;
            String strGenero;
            String strFechaNacimiento;
            String strCorreo;
            String strContrasena;
            String strDepartamento;
            String strDireccion;
            
            try 
            {
                while(UResult.next())
                {
               
                    iId = UResult.getInt("id");
                    strNombre = UResult.getString("nombre");
                    strApellido = UResult.getString("apellido");
                    strNombreUsuario = UResult.getString("nombreusuario");
                    strFotoPerfil = UResult.getString("fotoperfil");
                    strGenero= UResult.getString("genero");
                    strFechaNacimiento = UResult.getString("fechanacimiento");
                    strCorreo = UResult.getString("correo");
                    strContrasena = UResult.getString("contraseña");
                    strDepartamento= UResult.getString("departamento");
                    strDireccion = UResult.getString("direccion");
                    
                    if(strFotoPerfil.equals("")){
                        strFotoPerfil = "fotodefault.png";
                    }
                    
                    UTemp = new UsuarioObj(iId, strNombre, strApellido, strNombreUsuario, strFotoPerfil, strGenero, strFechaNacimiento, strCorreo,strContrasena,strDepartamento,strDireccion);
            } 
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return UTemp;
        
    }
    
    public int updateUsuarioFotoRows(int p_iId, String p_strFoto) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.usuario" +
                        " SET fotoperfil = '"+ p_strFoto +
                        "' WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
