package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {
    private TextView lblEntrada;
    private TextView lblVenta;
    private TextView lblCompra;
    private TextView lblGanancia;
    private Button btnCalcular;
    private Button btnRegresar;
    private float pventa;
    private float pcompra;
    private int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entradaproductoactivity);
        lblEntrada = (TextView) findViewById(R.id.lblEntrada);
        lblVenta = (TextView) findViewById(R.id.VarVenta);
        lblCompra = (TextView) findViewById(R.id.VarCompra);
        lblGanancia = (TextView) findViewById(R.id.VarGanancia);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        final Bundle datos = getIntent().getExtras();
        lblEntrada.setText(datos.getString("descripcion"));
        pventa = Float.parseFloat(datos.getString("pventa"));
        pcompra = Float.parseFloat(datos.getString("pcompra"));
        cantidad = Integer.parseInt(datos.getString("cantidad"));
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntradaProducto n = new EntradaProducto(pventa, pcompra, cantidad);
                float res1 = n.calcularPrecioVenta();
                float res2 = n.calcularPrecioCompra();
                lblVenta.setText(""+res1);
                lblCompra.setText(""+res2);
                lblGanancia.setText(""+n.calcularGanacia(res1,res2));
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });
    }

    private void Regresar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Regresar?");
        confirmar.setMessage("Se descartara toda la informacion ingresada");
        confirmar.setPositiveButton("Confirmar",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        confirmar.show();
    }
}
