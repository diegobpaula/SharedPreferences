package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.blocodenotas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        binding.fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecuperado = binding.edtAnotacao.getText().toString();
                if (textoRecuperado.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Preencha a anotação.", Toast.LENGTH_SHORT).show();
                }else{
                    preferencias.salvar(textoRecuperado);
                    Toast.makeText(getApplicationContext(), "Salvo com sucesso.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // RECUPERAR ANOTACAO
        String anotacao = preferencias.recuperar();

        if (!anotacao.isEmpty()){
            binding.edtAnotacao.setText(anotacao);
        }
    }
}