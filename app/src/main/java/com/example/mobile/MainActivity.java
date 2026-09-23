package com.example.mobile;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(v -> {
            // Pegamos o texto que o usuário digitou
            String email = editEmail.getText().toString().trim();
            String senha = editSenha.getText().toString().trim();

            // Validação simples de campos vazios
            if (TextUtils.isEmpty(email)) {
                editEmail.setError("O e-mail é obrigatório!");
                editEmail.requestFocus();
                return;
            }

            if (TextUtils.isEmpty(senha)) {
                editSenha.setError("A senha é obrigatória!");
                editSenha.requestFocus();
                return;
            }

            // Exemplo de verificação fixa (Mock)
            if (email.equals("teste@email.com") && senha.equals("123456")) {
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show();
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}