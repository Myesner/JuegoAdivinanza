package com.example.juegoadivinanza;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int NumeroS;
    private int attempts = 0;
    private TextView TvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumeroS = generateRandomNumber();
        TvInfo = findViewById(R.id.tvInfo);

        Button BtnA = findViewById(R.id.BtnA);
        BtnA.setOnClickListener(view -> Adivinar());

    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100 - 1 + 1) + 1;
    }

    @SuppressLint("SetTextI18n")
    private void Adivinar() {
        EditText etNumero = findViewById(R.id.etNumero);
        String guessText = etNumero.getText().toString();

        if (!guessText.isEmpty()) {
            int guess = Integer.parseInt(guessText);
            attempts++;

            if (guess < NumeroS) {
                TvInfo.setText("Demasiado bajo. Intento #" + attempts);
            } else if (guess > NumeroS) {
                TvInfo.setText("Demasiado alto. Intento #" + attempts);
            } else {
                TvInfo.setText("¡Felicidades! Adivinaste el número en " + attempts + " intentos.");
            }
        }


    }

}