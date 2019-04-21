package oc.plataformaweb.objects;

public class PublicidadObj {
       private int m_iId;
       private String m_DestinoDeImagen;
       private int m_costo;

    public PublicidadObj(int p_iId, String p_DestinoDeImagen, int p_costo) {
        setId(p_iId);
        setDestinoDeImagen(p_DestinoDeImagen);
        setcosto(p_costo);
    }

       
       
       
       
    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getDestinoDeImagen() {
        return m_DestinoDeImagen;
    }

    private void setDestinoDeImagen(String p_DestinoDeImagen) {
        m_DestinoDeImagen = p_DestinoDeImagen;
    }

    public int getcosto() {
        return m_costo;
    }

    private void setcosto(int p_costo) {
        m_costo = m_costo;
    }
       
       
}
