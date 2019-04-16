
package oc.plataformaweb.objects;


public class UsuarioObj {
    private int m_iId;
    private String m_strNombre;
    private String m_strApellido;
    private String m_strNombreUsuario;
    private String m_strGenero;
    private String m_strCorreo;
    private String m_strContrasena;
    private String m_strDireccion;

    public UsuarioObj(int p_iId, String p_strNombre, String p_strApellido, String p_strNombreUsuario, String p_strGenero, String p_strCorreo, String p_strContrasena) {
        setId(p_iId);
        setNombre(p_strNombre);
        setApellido(p_strApellido);
        setNombreUsuario(p_strNombreUsuario);
        setGenero(p_strGenero);
        setCorreo(p_strCorreo);
        setContrasena(p_strContrasena);
    }

    public UsuarioObj(int iId, String strNombre, String strApellido, String strNombreUsuario, String strGenero, String strCorreo, String strContrasena, String strDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getApellido() {
        return m_strApellido;
    }

    private void setApellido(String p_strApellido) {
        m_strApellido = p_strApellido;
    }

    public String getNombreUsuario() {
        return m_strNombreUsuario;
    }

    private void setNombreUsuario(String p_strNombreUsuario) {
        m_strNombreUsuario = p_strNombreUsuario;
    }

    public String getGenero() {
        return m_strGenero;
    }

    private void setGenero(String p_strGenero) {
        m_strGenero = p_strGenero;
    }

    public String getCorreo() {
        return m_strCorreo;
    }

    private void setCorreo(String p_strCorreo) {
        m_strCorreo = p_strCorreo;
    }

    public String getContrasena() {
        return m_strContrasena;
    }

    private void setContrasena(String p_strContrasena) {
        m_strContrasena = p_strContrasena;
    }
    public String getDireccion() {
        return m_strDireccion;
    }

    private void setDireccion(String p_strDireccion) {
        m_strDireccion = p_strDireccion;
    }
}
