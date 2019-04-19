
package oc.plataformaweb.objects;

public final class EmpresaObj {
    
    private int m_iId;
    private String m_strNombre;
    private String m_strDireccion;
    private String m_strDepartamento;
    private String m_strCiudad;
    private String m_strTelefono;
    private String m_strSitioWeb;

    public EmpresaObj(int p_iId, String p_strNombre, String p_strDireccion, String p_strDepartamento, String p_strCiudad, String p_strTelefono, String p_strSitioWeb) {
        setId(p_iId);
        setNombre(p_strNombre);
        setDireccion(p_strDireccion);
        setDepartamento(p_strDepartamento);
        setCiudad(p_strCiudad);
        setTelefono(p_strTelefono);
        setSitioWeb(p_strSitioWeb);
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

    public String getDireccion() {
        return m_strDireccion;
    }

    private void setDireccion(String p_strDireccion) {
        m_strDireccion = p_strDireccion;
    }

    public String getDepartamento() {
        return m_strDepartamento;
    }

    public void setDepartamento(String p_strDepartamento) {
        m_strDepartamento = p_strDepartamento;
    }

    public String getCiudad() {
        return m_strCiudad;
    }

    public void setCiudad(String p_strCiudad) {
        m_strCiudad = p_strCiudad;
    }

    public String getTelefono() {
        return m_strTelefono;
    }

    public void setTelefono(String p_strTelefono) {
        m_strTelefono = p_strTelefono;
    }

    public String getSitioWeb() {
        return m_strSitioWeb;
    }

    public void setSitioWeb(String p_strSitioWeb) {
        m_strSitioWeb = p_strSitioWeb;
    }
    
    
}
