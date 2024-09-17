package com.geeks.secondapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;

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

        Log.d("shamal", "onCreate - Hello world");


        HashSet<String> namesHashSet = new HashSet<>();
        namesHashSet.add("John");
        namesHashSet.add("Alex");
        namesHashSet.add("Chris");
        namesHashSet.add("Alex");
        namesHashSet.add("Leo");

        Log.d("ololo", "namesHashSet = " + namesHashSet);

        Button button = findViewById(R.id.button);
        CardView cardView = findViewById(R.id.card_view);


        button.setOnClickListener(view -> {
            // обработка клика
            if (cardView.getAlpha() == 1){
                cardView.animate().alpha(0).setDuration(1000);
            }else {
                cardView.animate().alpha(1);
            }
        });

        Button bigButton = findViewById(R.id.big_button);
        LinearLayout container = findViewById(R.id.container);

        bigButton.setOnClickListener(view -> {
            if (container.getVisibility() == View.VISIBLE){
                container.setVisibility(View.GONE);
            }else {
                container.setVisibility(View.VISIBLE);
            }
        });


        EditText editText = findViewById(R.id.edit_text);

        findViewById(R.id.btn_oval).setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();
        });

    }
}