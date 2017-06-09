package com.example.alumnedam.recuperaciom8uf1;

/**
 * Created by ALUMNEDAM on 09/06/2017.
 */

public class Cliente {
    private int idCliente;
    private String producto1,producto2,producto3;

    public Cliente(int idCliente, String producto1, String producto2, String producto3) {
        this.idCliente = idCliente;
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProducto1() {
        return producto1;
    }

    public void setProducto1(String producto1) {
        this.producto1 = producto1;
    }

    public String getProducto2() {
        return producto2;
    }

    public void setProducto2(String producto2) {
        this.producto2 = producto2;
    }

    public String getProducto3() {
        return producto3;
    }

    public void setProducto3(String producto3) {
        this.producto3 = producto3;
    }
}
