package oc.plataformaweb.objects;

public class PublicidadObj {
       private int m_iId;
       private String m_strImagen;
       private int m_iIdTipoPublicidad;
       private int m_iIdEmpresa;

    public PublicidadObj(int p_iId, String p_strImagen, int p_iIdTipoPublicidad, int p_iIdEmpresa) {
        setId(p_iId);
        setImagen(p_strImagen);
        setIdTipoPublicidad(p_iIdTipoPublicidad);
        setIdEmpresa(p_iIdEmpresa);
    }        

    public int getId() {
        return m_iId;
    }

    private void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public String getImagen() {
        return m_strImagen;
    }

    private void setImagen(String m_strImagen) {
        this.m_strImagen = m_strImagen;
    }

    public int getIdTipoPublicidad() {
        return m_iIdTipoPublicidad;
    }

    private void setIdTipoPublicidad(int m_iIdTipoPublicidad) {
        this.m_iIdTipoPublicidad = m_iIdTipoPublicidad;
    }

    public int getIdEmpresa() {
        return m_iIdEmpresa;
    }

    private void setIdEmpresa(int m_iIdEmpresa) {
        this.m_iIdEmpresa = m_iIdEmpresa;
    }
    
}
       


    