package oc.plataformaweb.objects;

public class DetalleOrdenObj {
    
    private int m_iId;
    private int m_iIdArticulo1;
    private int m_iIdArticulo2;
    private int m_iIdArticulo3;
    private int m_iIdArticulo4;
    private int m_iIdArticulo5;
    private int m_iIdArticulo6;
    private int m_iIdArticulo7;
    private int m_iIdArticulo8;
    private int m_iIdArticulo9;
    private int m_iIdArticulo10;
    private double m_dTotal;

    public DetalleOrdenObj(int p_iId, int p_iIdArticulo1 , double p_dTotal, int p_iIdArticulo2, int p_iIdArticulo3, int p_iIdArticulo4, int p_iIdArticulo5, int p_iIdArticulo6, int p_iIdArticulo7, int p_iIdArticulo8, int p_iIdArticulo9, int p_iIdArticulo10) {
        setId(p_iId);
        setIdArticulo1(p_iIdArticulo1);
        setIdArticulo2(p_iIdArticulo2);
        setIdArticulo3(p_iIdArticulo3);
        setIdArticulo4(p_iIdArticulo4);
        setIdArticulo5(p_iIdArticulo5);
        setIdArticulo6(p_iIdArticulo6);
        setIdArticulo7(p_iIdArticulo7);
        setIdArticulo8(p_iIdArticulo8);
        setIdArticulo9(p_iIdArticulo9);
        setIdArticulo10(p_iIdArticulo10);
        setTotal(p_dTotal);
    }
    
    

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getIdArticulo1() {
        return m_iIdArticulo1;
    }

    private void setIdArticulo1(int p_iIdArticulo1) {
        m_iIdArticulo1 = p_iIdArticulo1;
    }

    public int getIdArticulo2() {
        return m_iIdArticulo2;
    }

    private void setIdArticulo2(int p_iIdArticulo2) {
        m_iIdArticulo2 = p_iIdArticulo2;
    }

    public int getIdArticulo3() {
        return m_iIdArticulo3;
    }

    private void setIdArticulo3(int p_iIdArticulo3) {
        m_iIdArticulo3 = p_iIdArticulo3;
    }

    public int getIdArticulo4() {
        return m_iIdArticulo4;
    }

    private void setIdArticulo4(int p_iIdArticulo4) {
        m_iIdArticulo4 = p_iIdArticulo4;
    }

    public int getIdArticulo5() {
        return m_iIdArticulo5;
    }

    private void setIdArticulo5(int p_iIdArticulo5) {
        m_iIdArticulo5 = p_iIdArticulo5;
    }

    public int getIdArticulo6() {
        return m_iIdArticulo6;
    }

    private void setIdArticulo6(int p_iIdArticulo6) {
        m_iIdArticulo6 = p_iIdArticulo6;
    }

    public int getIdArticulo7() {
        return m_iIdArticulo7;
    }

    private void setIdArticulo7(int p_iIdArticulo7) {
        m_iIdArticulo7 = p_iIdArticulo7;
    }

    public int getIdArticulo8() {
        return m_iIdArticulo8;
    }

    private void setIdArticulo8(int p_iIdArticulo8) {
        m_iIdArticulo8 = p_iIdArticulo8;
    }

    public int getIdArticulo9() {
        return m_iIdArticulo9;
    }

    private void setIdArticulo9(int p_iIdArticulo9) {
        m_iIdArticulo9 = p_iIdArticulo9;
    }

    public int getIdArticulo10() {
        return m_iIdArticulo10;
    }

    private void setIdArticulo10(int p_iIdArticulo10) {
        this.m_iIdArticulo10 = p_iIdArticulo10;
    }

    public double getTotal() {
        return m_dTotal;
    }

    private void setTotal(double p_dTotal) {
        m_dTotal = p_dTotal;
    }
    
    
        
        
    
}
