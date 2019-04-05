
package oc.plataformaweb.objects;

public class EmpresaObj 
{
    private int m_iId;
    private String m_strNombre;
    private String m_strDescripcion;
    private byte m_bImagen;
    private String m_strCorreo;
    private String m_strTelefono;
    private String m_strContrasena;
    private int m_iIdDireccion;

    public EmpresaObj(int p_iId, String p_strNombre, String p_strDescripcion, byte p_bImagen, String p_strCorreo, 
            String p_strTelefono, String p_strContrasena, int p_iIdDireccion) {
        setId(p_iId);
        setNombre(p_strNombre);
        setDescripcion(p_strDescripcion);
        setImagen(p_bImagen);
        setCorreo(p_strCorreo);
        setTelefono(p_strTelefono);
        setContrasena(p_strContrasena);
        setIdDireccion(p_iIdDireccion);
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

    public byte getImagen() {
        return m_bImagen;
    }

    private void setImagen(byte p_bImagen) {
        m_bImagen = p_bImagen;
    }

    public String getCorreo() {
        return m_strCorreo;
    }

    private void setCorreo(String p_strCorreo) {
        m_strCorreo = p_strCorreo;
    }

    public String getTelefono() {
        return m_strTelefono;
    }

    private void setTelefono(String p_strTelefono) {
        m_strTelefono = p_strTelefono;
    }

    public String getContrasena() {
        return m_strContrasena;
    }

    private void setContrasena(String p_strContrasena) {
        m_strContrasena = p_strContrasena;
    }

    public int getIdDireccion() {
        return m_iIdDireccion;
    }

    private void setIdDireccion(int p_iIdDireccion) {
        m_iIdDireccion = p_iIdDireccion;
    }
    
    
    
}
