
package oc.plataformaweb.logic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.EmpresaObj;

public class EmpresaLogic extends Logic
{
    public boolean insertEmpresaBool(String p_strNombre, InputStream p_isLogo, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.empresa (id,nombre,logo,direccion,departamento,ciudad,telefono,sitioweb)"+
        "VALUES (0,'"+p_strNombre+"','"+ p_isLogo +"','"+p_strDireccion+"','"+p_strDepartamento+"','"+p_strCiudad+"','"+p_strTelefono+"','"+p_strSitioWeb+"');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertEmpresaRows(String p_strNombre, InputStream p_isLogo, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.empresa (id,nombre,logo,direccion,departamento,ciudad,telefono,sitioweb)"+
        "VALUES (0,'"+p_strNombre+"','"+ p_isLogo +"','"+p_strDireccion+"','"+p_strDepartamento+"','"+p_strCiudad+"','"+p_strTelefono+"','"+p_strSitioWeb+"');";
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
            byte[] bLogo;
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
                    bLogo = EResult.getBytes("logo");
                    strDireccion = EResult.getString("direccion");
                    strDepartamento = EResult.getString("departamento");
                    strCiudad = EResult.getString("ciudad");
                    strTelefono = EResult.getString("telefono");
                    strSitioWeb = EResult.getString("sitioweb");                                                            
                    
                    ETemp = new EmpresaObj(iId, strNombre, bLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
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
    
    public void listarImg (int id, HttpServletResponse response){
        DatabaseX database = getDatabase();
        String strSql = "select foto from ocplataformaweb.empresa where id="+id;
        System.out.println(strSql);
        ResultSet EResult = database.executeQuery(strSql);
        
        
         if(EResult!=null)
        {
            byte[] bLogo = null;
            response.setContentType("image/*");
                
            try {
                
                while (EResult.next()) {
                    bLogo = EResult.getBytes("logo");
                }
                InputStream bos = new ByteArrayInputStream(bLogo);

                int tamanoInput = bos.available();
                byte[] datosIMAGEN = new byte[tamanoInput];
                bos.read(datosIMAGEN, 0, tamanoInput);

                response.getOutputStream().write(datosIMAGEN);
                
            } catch (SQLException | IOException ex) {
                Logger.getLogger(EmpresaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            byte[] bLogo;
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
                    bLogo = EResult.getBytes("logo");
                    strDireccion = EResult.getString("direccion");
                    strDepartamento = EResult.getString("departamento");
                    strCiudad = EResult.getString("ciudad");
                    strTelefono = EResult.getString("telefono");
                    strSitioWeb = EResult.getString("sitioweb");
                    
                    ETemp = new EmpresaObj(iId, strNombre, bLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpresaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ETemp;
        
    }
    
    public int updateEmpresaRows(int p_iId, String p_strNombre, InputStream p_isLogo, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.empresa" +
                        " SET nombre = '"+p_strNombre+"', logo = '"+ p_isLogo +"', direccion = '"+p_strDireccion+"', departamento = '"+p_strDepartamento+"', ciudad = '"+p_strCiudad+"', telefono = '"+p_strTelefono+"', sitioweb = '"+p_strSitioWeb+"'" +
                        " WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
