package oc.plataformaweb.objects;

public class TipoPublicidadObj {
    private int m_Iid;
    private String m_strName;
    private String m_strDescripcion;

    public TipoPublicidadObj(int p_Iid, String p_strName, String p_strDescripcion) {
        setid(p_Iid);
        setName(p_strName);
        setDescripcion(p_strDescripcion);
    }
   

    public int getid() {
        return m_Iid;
    }

    private void setid(int p_Iid) {
        m_Iid = p_Iid;
    }

    public String getName() {
        return m_strName;
    }

    private void setName(String p_strName) {
        m_strName = p_strName;
    }

    public String getDescripcion() {
        return m_strDescripcion;
    }

    private void setDescripcion(String p_strDescripcion) {
        m_strDescripcion = p_strDescripcion;
    }

    
}