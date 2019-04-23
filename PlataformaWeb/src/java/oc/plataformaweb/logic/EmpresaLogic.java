
package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.EmpresaObj;

public class EmpresaLogic extends Logic
{
    public boolean insertEmpresaBool(String p_strNombre, String p_strLogo, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.empresa (id,nombre, logo, direccion,departamento,ciudad,telefono,sitioweb)"+
        "VALUES (0,'"+p_strNombre+"','"+p_strLogo+"','"+p_strDireccion+"','"+p_strDepartamento+"','"+p_strCiudad+"','"+p_strTelefono+"','"+p_strSitioWeb+"');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertEmpresaRows(String p_strNombre, String p_strLogo, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.empresa (id,nombre, logo, direccion,departamento,ciudad,telefono,sitioweb)"+
        "VALUES (0,'"+p_strNombre+"','"+p_strLogo+"','"+p_strDireccion+"','"+p_strDepartamento+"','"+p_strCiudad+"','"+p_strTelefono+"','"+p_strSitioWeb+"');";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<EmpresaObj> getAllEmpresas() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.empresa ";
        System.out.println(strSql);
        ResultSet EResult = database.executeQuery(strSql);
        ArrayList<EmpresaObj> EArray = null;
        
        if(EResult!=null)
        {
            int iId;
            String strNombre;
            String strLogo;
            String strDireccion;
            String strDepartamento;
            String strCiudad;
            String strTelefono;
            String strSitioWeb;
            
            EmpresaObj ETemp;
            EArray = new ArrayList<>();
            
            try 
            {
                while(EResult.next())
                {
                    iId = EResult.getInt("id");
                    strNombre = EResult.getString("nombre");
                    strLogo = EResult.getString("logo");
                    strDireccion = EResult.getString("direccion");
                    strDepartamento = EResult.getString("departamento");
                    strCiudad = EResult.getString("ciudad");
                    strTelefono = EResult.getString("telefono");
                    strSitioWeb = EResult.getString("sitioweb");
                    
                    ETemp = new EmpresaObj(iId, strNombre, strLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
                    EArray.add(ETemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpresaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return EArray;
        
    }

    public int deleteEmpresaRows(int p_iId) 
    {
        
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.empresa "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public EmpresaObj getEmpresaById(int p_iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.empresa where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet EResult = database.executeQuery(strSql);
        EmpresaObj ETemp = null;
        
        if(EResult!=null)
        {
            int iId;
            String strNombre;
            String strLogo;
            String strDireccion;
            String strDepartamento;
            String strCiudad;
            String strTelefono;
            String strSitioWeb;
            
            try 
            {
                while(EResult.next())
                {
                    iId = EResult.getInt("id");
                    strNombre = EResult.getString("nombre");
                    strLogo = EResult.getString("logo");
                    strDireccion = EResult.getString("direccion");
                    strDepartamento = EResult.getString("departamento");
                    strCiudad = EResult.getString("ciudad");
                    strTelefono = EResult.getString("telefono");
                    strSitioWeb = EResult.getString("sitioweb");
                    
                    ETemp = new EmpresaObj(iId, strNombre, strLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpresaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ETemp;
        
    }
    
    public int updateEmpresaImagenRows(int p_iId, String p_strLogo) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.empresa" +
                        " SET logo = '"+ p_strLogo +
                        "' WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public int updateEmpresaRows(int p_iId, String p_strNombre, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.empresa" +
                        " SET nombre = '"+p_strNombre+"', direccion = '"+p_strDireccion+"', departamento = '"+p_strDepartamento+"', ciudad = '"+p_strCiudad+"', telefono = '"+p_strTelefono+"', sitioweb = '"+p_strSitioWeb+"'" +
                        " WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public EmpresaObj getEmpresaInfo(String p_strNombreUsuario, String p_strContrasena) 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from ocplataformaweb.empresa where nombre= '"+p_strNombreUsuario
                +"' AND telefono = '"+ p_strContrasena +"' ";
        System.out.println(strSql);
        ResultSet EResult = database.executeQuery(strSql);
        EmpresaObj ETemp = null;
        
        if(EResult!=null)
        {
            int iId;
            String strNombre;
            String strLogo;
            String strDireccion;
            String strDepartamento;
            String strCiudad;
            String strTelefono;
            String strSitioWeb;
            
            try 
            {
                while(EResult.next())
                {
                    iId = EResult.getInt("id");
                    strNombre = EResult.getString("nombre");
                    strLogo = EResult.getString("logo");
                    strDireccion = EResult.getString("direccion");
                    strDepartamento = EResult.getString("departamento");
                    strCiudad = EResult.getString("ciudad");
                    strTelefono = EResult.getString("telefono");
                    strSitioWeb = EResult.getString("sitioweb");
                    
                    ETemp = new EmpresaObj(iId, strNombre, strLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpresaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ETemp;
        
        
    }
}
