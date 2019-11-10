/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.db;

/**
 *
 * @author gabrielprieto
 */
public class Lista {
    private int customer_id;
    private int product_id;

    public Lista(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCliente_id() {
        return customer_id;
    }

    public void setCliente_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
}
