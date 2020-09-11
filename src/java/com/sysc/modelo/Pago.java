
package com.sysc.modelo;


public class Pago {
    private int id;
    private Double montoCanc; //referente ha uma quantidade ( montante) de informações que se por ventura for cancelada a compra - pgto

    public Pago() {
    }

    public Pago(int id, Double montoCanc) {
        this.id = id;
        this.montoCanc = montoCanc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMontoCanc() {
        return montoCanc;
    }

    public void setMontoCanc(Double montoCanc) {
        this.montoCanc = montoCanc;
    }
    
    
    
    
    
}
