package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends AppCompatActivity {

    //Creamos los dos objetos de tipo EditText para el correo y la contraseña
    private EditText correo, password;
    private static Connection conn;//Añadida


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "Aplicacion iniciada: Login", Toast.LENGTH_LONG).show();
        this.setTitle("Iniciar sesión");

        //Relacionamos los dos obtejos EditText con el id correspondiente
        correo = (EditText)findViewById(R.id.emailLogin);
        password = (EditText)findViewById(R.id.passLogin);
    }

    /**
     * Metodo asociado al boton iniciarSesion para mandar a la activity MainActivity
     * Falta la comprobacion de que los datos sean correctos
     * @param view
     */
    public void iniciarSesion(View view){

        //Zona conexion a BD
        /**
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConectorMySql.establecerConexion();
            }
            try{
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario where usuario='"+correo.getText().toString()+"'");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("usuario_id");
                    String nombre = prs.getNString("nombre");
                    Toast.makeText(this, "OK1", Toast.LENGTH_SHORT).show();
                }

            }catch (SQLException e){
                System.out.println("Se ha producido una SQLException:" + e.getMessage());
            }
            finally {
                if (conn != null) {
                    ConectorMySql.cerrarConexion();
                }
            }
            Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        if(true){
            Intent login_MainActivity = new Intent(this, MainActivity.class);
            startActivity(login_MainActivity);
        }
        else{
            Toast.makeText(this, "Datos introducidos erroneos", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Metodo asociado al boton Registro el cual mandara a la activity Registro
     * @param view
     */
    public void toRegistro(View view){
            Intent login_registro = new Intent(this, Registro.class);
            startActivity(login_registro);
    }

    //Seguir por aqui

    /**
     * Ideas
     *      Obtener el id del usuario y comprobarlo con un toast para ver si funciona
     *      Crear un objeto usuario el cual tenga datos que podamos ver y tocar
     *      Obtener el id del usuario y mientras se inicia cargar los datos de ese usuario 
     * @return
     */
    public int compExistenciaUsuario(){
        try {
            if(conn==null || conn.isClosed()){
                conn=ConectorMySql.establecerConexion();
            }
            PreparedStatement pstmt = null;
            pstmt=conn.prepareStatement("SELECT * from usuario where ");
            ResultSet prs=pstmt.executeQuery();
            while(prs.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

