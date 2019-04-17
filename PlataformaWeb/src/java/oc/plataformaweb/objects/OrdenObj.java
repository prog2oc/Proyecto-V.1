package oc.plataformaweb.objects;
/**
 * @author Gabriela Centeno
 */
public class OrdenObj 
{
    private int m_id;
    private int m_fecha_orden;
    private int m_fecha_entrega;
    private int m_idusuario;
    
    // constructor

    public OrdenObj(int p_id, int p_fecha_orden, int p_fecha_entrega, int p_idusuario) {
        
        setId(p_id);
        setFecha_orden(p_fecha_orden);
        setFecha_entrega(p_fecha_entrega);
        setIdusuario(p_idusuario);
    }
    
    // GET & SET

    public int getId() {
        return m_id;
    }

    public void setId(int p_id) {
        m_id = p_id;
    }

    public int getFecha_orden() {
        return m_fecha_orden;
    }

    public void setFecha_orden(int p_fecha_orden) {
        m_fecha_orden = p_fecha_orden;
    }

    public int getFecha_entrega() {
        return m_fecha_entrega;
    }

    public void setFecha_entrega(int p_fecha_entrega) {
        m_fecha_entrega = p_fecha_entrega;
    }

    public int getIdusuario() {
        return m_idusuario;
    }

    public void setIdusuario(int p_idusuario) {
        m_idusuario = p_idusuario;
    }

       
}
