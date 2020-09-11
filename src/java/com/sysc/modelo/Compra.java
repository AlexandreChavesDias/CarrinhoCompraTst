
package com.sysc.modelo;

import java.util.List;


public class Compra {
    
    private int id; 
    private Cliente cliente;
    private int idpago;
    private String dataCompra;
    private Double monto;
    private String estado;   

    private List<Carrinho> detalheCompra; //para sincronizar com a classe Carrinho

    public Compra() {
    }

    public Compra( Cliente cliente, int idpago, String dataCompra, Double monto, String estado, List<Carrinho> detalheCompra) {
        this.cliente = cliente;
        this.idpago = idpago;
        this.dataCompra = dataCompra;
        this.monto = monto;
        this.estado = estado;
        this.detalheCompra = detalheCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carrinho> getDetalheCompra() {
        return detalheCompra;
    }

    public void setDetalheCompra(List<Carrinho> detalheCompra) {
        this.detalheCompra = detalheCompra;
    }
    
    
    
    
    
}
