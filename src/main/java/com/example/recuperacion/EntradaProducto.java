package com.example.recuperacion;



public class EntradaProducto {

    private float pventa;
    private float pcompra;
    private float cantidad;

    public EntradaProducto(float pventa, float pcompra, float cantidad) {
        this.pventa = pventa;
        this.pcompra = pcompra;
        this.cantidad = cantidad;
    }

    public float calcularPrecioVenta(){
        float rVenta = pventa * cantidad;
        return rVenta;
    }
    public float calcularPrecioCompra(){
        float rCompra = pcompra * cantidad;
        return rCompra;
    }
    public float calcularGanacia(float venta, float compra){
        float rGanancia = venta - compra;
        return rGanancia;
    }

}

