package escuadronWeb.objects;

public class UsuarioObj 
{
    private String m_strNombre;
    private String m_strApellido;
    private int m_iEdad;
    private String m_strNombreUsuario;
    private String m_strCorreo;
    private String m_strContra;

    // Constructor

    public UsuarioObj(String p_strNombre, String p_strApellido, int p_iEdad, String p_strNombreUsuario, String p_strCorreo, String p_strContra) {
        setNombre(p_strNombre);
        setApellido(p_strApellido);
        setEdad(p_iEdad);
        setNombreUsuario(p_strNombreUsuario);
        setCorreo(p_strCorreo);
        setContra(p_strContra);
    }

    // Get & Set
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

    public int getEdad() {
        return m_iEdad;
    }

    private void setEdad(int p_iEdad) {
        m_iEdad = p_iEdad;
    }

    public String getNombreUsuario() {
        return m_strNombreUsuario;
    }

    private void setNombreUsuario(String p_strNombreUsuario) {
        m_strNombreUsuario = p_strNombreUsuario;
    }

    public String getCorreo() {
        return m_strCorreo;
    }

    private void setCorreo(String p_strCorreo) {
        m_strCorreo = p_strCorreo;
    }

    public String getContra() {
        return m_strContra;
    }

    private void setContra(String p_strContra) {
        m_strContra = p_strContra;
    }
        
}

