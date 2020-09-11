
package com.sysc.modelo;

import java.io.InputStream;

public class Carrinho {
    int item;
    int idProduto;
    String nomes;
    String imagem;
    String descricao;
    double precoCompra;
    int quantidade;
    double subTotal;

    public Carrinho() {
    }

    public Carrinho(int item, int idProduto, String nomes, String imagem, String descricao, double precoCompra, int quantidade, double subTotal) {
        this.item = item;
        this.idProduto = idProduto;
        this.nomes = nomes;
        this.imagem = imagem;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    
    
    
    
}
