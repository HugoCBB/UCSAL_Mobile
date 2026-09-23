package com.example.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        Button btnCurso = findViewById(R.id.btnCurso);
        Button btnNota = findViewById(R.id.btnNota);
        Button btnHorario = findViewById(R.id.btnHorario);
        Button btnFinanceiro = findViewById(R.id.btnFinanceiro);
        Button btnCoordenacao = findViewById(R.id.btnCoordenacao);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnCurso.setOnClickListener(v -> aviso("Curso"));
        btnNota.setOnClickListener(v -> aviso("Minha nota"));
        btnHorario.setOnClickListener(v -> aviso("Horário"));
        btnFinanceiro.setOnClickListener(v -> aviso("Financeiro"));
        btnCoordenacao.setOnClickListener(v -> aviso("Coordenação"));

        // Voltar para o login
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void aviso(String tela) {
        Toast.makeText(this, "Abrindo " + tela, Toast.LENGTH_SHORT).show();
    }
}