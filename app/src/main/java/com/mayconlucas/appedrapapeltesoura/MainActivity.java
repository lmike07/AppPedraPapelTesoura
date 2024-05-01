package com.mayconlucas.appedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra (View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel (View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura (View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoria (){

        ImageView imagemApp = findViewById(R.id.image_app);

        String [] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        String EscolhaApp = opcoes[numeroAleatorio];
        switch ( EscolhaApp ){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return EscolhaApp;

    }

    private void verificarGanhador(String escolhaUsuario){
        String EscolhaApp = gerarEscolhaAleatoria();
        TextView textoResutaldo = findViewById(R.id.text_resultado);

        if(
            (EscolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (EscolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (EscolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){
            textoResutaldo.setText("Você perdeu :(");
        }
        else if (
            (escolhaUsuario == "pedra" && EscolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && EscolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && EscolhaApp == "papel")

        ){
            textoResutaldo.setText("Você Ganhou!!! :)");
        }
        else {
            textoResutaldo.setText("EMPATAMOS ;=;");
        }
    }

}