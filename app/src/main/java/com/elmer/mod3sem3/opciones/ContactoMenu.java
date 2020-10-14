package com.elmer.mod3sem3.opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.elmer.mod3sem3.mail.JavaMailAPI;
import com.elmer.mod3sem3.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ContactoMenu extends AppCompatActivity {

    TextInputEditText tiNombre;
    TextInputEditText tiCorreo;
    TextInputEditText tiMensaje;
    MaterialButton btnCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_menu);

        MaterialToolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tiNombre = findViewById(R.id.tiNombre);
        tiCorreo = findViewById(R.id.tiCorreo);
        tiMensaje = findViewById(R.id.tiMensaje);
        btnCorreo = findViewById(R.id.btnCorreo);

        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        String email = tiCorreo.getText().toString();
        String mensaje = tiMensaje.getText().toString();
        String subject = tiNombre.getText().toString();

        //send email
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, email, subject, mensaje);
        javaMailAPI.execute();
    }
}