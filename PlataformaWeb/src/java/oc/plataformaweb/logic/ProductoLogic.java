package oc.plataformaweb.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oc.plataformaweb.database.DatabaseX;
import oc.plataformaweb.objects.ProductoObj;

public class ProductoLogic extends Logic
{
    
    public boolean insertProductoBool(String p_strNombreProducto, String p_strImagen, String p_strDescripcion, double p_dPrecioUnidad, int p_iUnidades, int p_iIdCategoria, int p_iIdEmpresa)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.producto " +
            "(id,nombreproducto, imagen, descripcion, preciounidad,unidades,idcategoria,idempresa) " +
            "VALUES " +
            "( 0,'"+p_strNombreProducto+"', '"+p_strImagen+"', '"+p_strDescripcion+"', "+p_dPrecioUnidad+","+ p_iUnidades+","+p_iIdCategoria+","+p_iIdEmpresa+");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertProductoRows(String p_strNombreProducto, String p_strImagen, String p_strDescripcion, double p_dPrecioUnidad, int p_iUnidades, int p_iIdCategoria, int p_iIdEmpresa)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO ocplataformaweb.producto " +
            "(id,nombreproducto, imagen, descripcion, preciounidad,unidades,idcategoria,idempresa) " +
            "VALUES " +
            "( 0,'"+p_strNombreProducto+"', '"+p_strImagen+"', '"+p_strDescripcion+"', "+p_dPrecioUnidad+","+ p_iUnidades+","+p_iIdCategoria+","+p_iIdEmpresa+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<ProductoObj> getAllProductos() 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.producto; ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombreProducto;
            String strImagen;
            String strDescripcion;
            double dPrecioUnidad;
            int iUnidades;
            int iIdCategoria;
            int iIdEmpresa;
            
            ProductoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombreProducto = CResult.getString("nombreproducto");
                    strImagen = CResult.getString("imagen");
                    strDescripcion = CResult.getString("descripcion");
                    dPrecioUnidad = CResult.getDouble("preciounidad");
                    iUnidades = CResult.getInt("unidades");
                    iIdCategoria = CResult.getInt("idcategoria");
                    iIdEmpresa = CResult.getInt("idempresa");
                    
                    if(strImagen.equals("")){
                        strImagen = "productodefault.png";
                    }
                    
                    CTemp = new ProductoObj(iId, strNombreProducto, strImagen, strDescripcion, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteProductoRows(int p_iId) 
    {
        //delete from travelsys.client where id=0;
        DatabaseX database = getDatabase();
        String strSql = "delete from ocplataformaweb.producto "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ProductoObj getProductoById(int p_iId) 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.producto where id= "+p_iId+" ;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProductoObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombreProducto;
            String strImagen;
            String strDescripcion;
            double dPrecioUnidad;
            int iUnidades;
            int iIdCategoria;
            int iIdEmpresa;
            
            try 
            {
                while(CResult.next())
                {
                     iId = CResult.getInt("id");
                    strNombreProducto = CResult.getString("nombreproducto");
                    strImagen = CResult.getString("imagen");
                    strDescripcion = CResult.getString("descripcion");
                    dPrecioUnidad = CResult.getDouble("preciounidad");
                    iUnidades = CResult.getInt("unidades");
                    iIdCategoria = CResult.getInt("idcategoria");
                    iIdEmpresa = CResult.getInt("idempresa");
                    
                    if(strImagen.equals("")){
                        strImagen = "productodefault.png";
                    }
                    
                    CTemp = new ProductoObj(iId, strNombreProducto, strImagen, strDescripcion, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateProductoRows(int p_iId, String p_strNombreProducto, String p_strDescripcion, double p_dPrecioUnidad, int p_iUnidades, int p_iIdCategoria, int p_iIdEmpresa) 
    {
        
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.producto set nombreproducto= '"+p_strNombreProducto+"' , preciounidad = "+p_dPrecioUnidad+", unidades = "+ p_iUnidades +", "
                + "idcategoria = "+ p_iIdCategoria +", idempresa = "+p_iIdEmpresa+" WHERE id= "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }    
    
    public int updateImagenProductoRows(int p_iId, String p_strImagen) 
    {
        DatabaseX database = getDatabase();
        String strSql = "UPDATE ocplataformaweb.producto" +
                        " SET imagen = '"+ p_strImagen +
                        "' WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public ArrayList<ProductoObj> getAllProductosByCategoria(int iIdCategoria) 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.producto where idcategoria = "+iIdCategoria+"; ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombreProducto;
            String strImagen;
            String strDescripcion;
            double dPrecioUnidad;
            int iUnidades;
            int iIdEmpresa;
            
            ProductoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombreProducto = CResult.getString("nombreproducto");
                    strImagen = CResult.getString("imagen");
                    strDescripcion = CResult.getString("descripcion");
                    dPrecioUnidad = CResult.getDouble("preciounidad");
                    iUnidades = CResult.getInt("unidades");
                    iIdEmpresa = CResult.getInt("idempresa");
                    
                    if(strImagen.equals("")){
                        strImagen = "productodefault.png";
                    }
                    
                    CTemp = new ProductoObj(iId, strNombreProducto, strImagen, strDescripcion, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    public ArrayList<ProductoObj> getAllProductosByEmpresa(int iIdEmpresa) 
    {
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM ocplataformaweb.producto where idempresa = "+iIdEmpresa+"; ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombreProducto;
            String strImagen;
            String strDescripcion;
            double dPrecioUnidad;
            int iUnidades;
            int iIdCategoria;
            
            ProductoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombreProducto = CResult.getString("nombreproducto");
                    strImagen = CResult.getString("imagen");
                    strDescripcion = CResult.getString("descripcion");
                    dPrecioUnidad = CResult.getDouble("preciounidad");
                    iUnidades = CResult.getInt("unidades");
                    iIdCategoria = CResult.getInt("idcategoria");
                    
                    if(strImagen.equals("")){
                        strImagen = "productodefault.png";
                    }
                    
                    CTemp = new ProductoObj(iId, strNombreProducto, strImagen, strDescripcion, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
}
