package oc.plataformaweb.objects;


public class CategoriaObj 
{
    private int m_iId;
    private String m_strNombre;
    private String m_strDescripcion;

    public CategoriaObj(int p_iId, String p_strNombre, String p_strDescripcion) {
        setId(p_iId);
        setNombre(p_strNombre);
        setDescripcion(p_strDescripcion);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getNombre() {
        return m_strNombre;
    }

    private void setNombre(String p_strNombre) {
        m_strNombre = p_strNombre;
    }

    public String getDescripcion() {
        return m_strDescripcion;
    }

    private void setDescripcion(String p_strDescripcion) {
        m_strDescripcion = p_strDescripcion;
    }
    
    
    
    
}
