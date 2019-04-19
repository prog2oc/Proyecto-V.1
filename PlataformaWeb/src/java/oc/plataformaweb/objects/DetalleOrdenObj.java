package oc.plataformaweb.objects;

public class DetalleOrdenObj {
    
     private int m_iIdproducto;
        private int m_iIdorden;
        private int m_iCantidad;
        private double m_dDescuento;
       
        // CONSTRUCTOR
        public DetalleOrdenObj(int p_iIdproducto, int p_iIdorden, int p_iCantidad, double p_dDescuento)
            {

                setIdproducto(p_iIdproducto);
                setIdorden(p_iIdorden);
                setCantidad(p_iCantidad);
                setDescuento(p_dDescuento);
            }
        
        // GET & SET
        public int getIdproducto() 
            {
             return m_iIdproducto;
            }

        private void setIdproducto(int p_iIdproducto) 
            {
             m_iIdproducto = p_iIdproducto;
            }

        public int getIdorden() 
            {
             return m_iIdorden;
            }

        private void setIdorden(int p_iIdorden) 
            {
                m_iIdorden = p_iIdorden;
            }

        public int getCantidad() 
            {
               return m_iCantidad;
            }

        private void setCantidad(int p_iCantidad) 
            {
              m_iCantidad = p_iCantidad;
            }

        public double getDescuento() 
            {
                return m_dDescuento;
            }

        private void setDescuento(double p_dDescuento) 
            {
                m_dDescuento = p_dDescuento;
            }
    
}
