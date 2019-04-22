
package oc.plataformaweb.objects;

public class ArticuloObj 
{
    
    private int m_iId;
    private int m_iIdProducto;
    private int m_iCantidad;

    public ArticuloObj(int p_iId, int p_iIdProducto, int p_iCantidad) {
        setId(p_iId);
        setIdProducto(p_iIdProducto);
        setCantidad(p_iCantidad);
    }    
    
    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getIdProducto() {
        return m_iIdProducto;
    }

    private void setIdProducto(int p_iIdProducto) {
       m_iIdProducto = p_iIdProducto;
    }

    public int getCantidad() {
        return m_iCantidad;
    }

    private void setCantidad(int p_iCantidad) {
        m_iCantidad = p_iCantidad;
    }
    
    
    
}
