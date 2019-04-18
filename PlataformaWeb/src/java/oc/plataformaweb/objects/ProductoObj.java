package oc.plataformaweb.objects;

public class ProductoObj 
{
    private int m_iId;
    private String m_strNombreProducto;
    private double m_dPrecioUnidad;
    private int m_iUnidades;
    private int m_iIdCategoria;
    private int m_iIdEmpresa;

    public ProductoObj(int p_iId, String p_strNombreProducto, double p_dPrecioUnidad, int p_iUnidades, int p_iIdCategoria, int p_iIdEmpresa) 
    {
        setId(p_iId);
        setNombreProducto(p_strNombreProducto);
        setPrecioUnidad(p_dPrecioUnidad);
        setUnidades(p_iUnidades);
        setIdCategoria(p_iIdCategoria);
        setIdEmpresa(p_iIdEmpresa);
    }
    
    

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getNombreProducto() {
        return m_strNombreProducto;
    }

    private void setNombreProducto(String p_strNombreProducto) {
        m_strNombreProducto = p_strNombreProducto;
    }

    public double getPrecioUnidad() {
        return m_dPrecioUnidad;
    }

    private void setPrecioUnidad(double p_dPrecioUnidad) {
        m_dPrecioUnidad = p_dPrecioUnidad;
    }

    public int getUnidades() {
        return m_iUnidades;
    }

    private void setUnidades(int p_iUnidades) {
        m_iUnidades = p_iUnidades;
    }

    public int getIdCategoria() {
        return m_iIdCategoria;
    }

    private void setIdCategoria(int p_iIdCategoria) {
        m_iIdCategoria = p_iIdCategoria;
    }

    public int getIdEmpresa() {
        return m_iIdEmpresa;
    }

    private void setIdEmpresa(int p_iIdEmpresa) {
        m_iIdEmpresa = p_iIdEmpresa;
    }
    
    
    
}
