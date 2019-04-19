package oc.plataformaweb.objects;
/**
 * @author Gabriela Centeno
 */
    public class UsuarioObj 
    {
    
    private int m_iId;   
    private String m_strNombre;
    private String m_strApellido;
    private String m_strNombreUsuario;
    private String m_strGenero;
    private String m_strFechaNacimiento;
    private String m_strCorreo;
    private String m_strContrasena;
    private String m_strDepartamento;
    private String m_strDireccion;

        public UsuarioObj(int p_iId, String p_strNombre, String p_strApellido, String p_strNombreUsuario, String p_strGenero, String p_strFechaNacimiento, String p_strCorreo, String p_strContrasena, String p_strDepartamento, String p_strDireccion) {
            setId(p_iId);
            setNombre(p_strNombre);
            setApellido(p_strApellido);
            setNombreUsuario(p_strNombreUsuario);
            setGenero(p_strGenero);
            setFechaNacimiento(p_strFechaNacimiento);
            setCorreo(p_strCorreo);
            setContrasena(p_strContrasena);
            setDepartamento(p_strDepartamento);
            setDireccion(p_strDireccion);
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
        public String getFechaNacimiento() {
            return m_strFechaNacimiento;
        }

        private void setFechaNacimiento(String p_strFechaNacimiento) {
            m_strFechaNacimiento = p_strFechaNacimiento;
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

        public String getDepartamento() {
            return m_strDepartamento;
        }

        private void setDepartamento(String p_strDepartamento) {
            m_strDepartamento = p_strDepartamento;
        }

        public String getDireccion() {
            return m_strDireccion;
        }

        private void setDireccion(String p_strDireccion) {
            m_strDireccion = p_strDireccion;
        }
        
    }
    
    



