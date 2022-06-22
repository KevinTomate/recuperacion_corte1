package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnidad;
    private EditText txtPventa;
    private EditText txtPcompra;
    private EditText txtCantidad;
    private Button btnEnviar;
    private Button btnLimpiar;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtPventa = (EditText) findViewById(R.id.txtPventa);
        txtPcompra = (EditText) findViewById(R.id.txtPcompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("") || txtDescripcion.getText().toString().matches("") || txtUnidad.getText().toString().matches("") || txtPventa.getText().toString().matches("") || txtPcompra.getText().toString().matches("") || txtCantidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Existe un dato invalido",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, EntradaProductoActivity.class);
                    Bundle bundle = new Bundle();
                    //bundle.putSerializable("codigo", txtCodigo.getText().toString());
                    bundle.putSerializable("descripcion", txtDescripcion.getText().toString());
                    //bundle.putSerializable("unidad", txtUnidad.getText().toString());
                    bundle.putSerializable("pventa", txtPventa.getText().toString());
                    bundle.putSerializable("pcompra", txtPcompra.getText().toString());
                    bundle.putSerializable("cantidad", txtCantidad.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtPventa.setText("");
                txtPcompra.setText("");
                txtCantidad.setText("");
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cerrar();
            }
        });
    }

    private void Cerrar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Cerrar APP?");
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
