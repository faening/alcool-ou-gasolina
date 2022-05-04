package com.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText ep;
    private TextInputEditText gp;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ep = findViewById(R.id.text_ethanol);
        gp = findViewById(R.id.text_gasoline);
        res = findViewById(R.id.text_result);
    }

    public void calc(View v) {
        if (ep.toString().isEmpty() || gp.toString().isEmpty()) {
            res.setText("Campo obrigatório não preenchido!");
        }

        double e = Double.parseDouble(ep.getText().toString().replace(",", "."));
        double g = Double.parseDouble(gp.getText().toString().replace(",", "."));
        String m;

        if (e <= 0.0 || Double.isNaN(e) ||
            g <= 0.0 || Double.isNaN(g)) {
            m = "Preço de Venda não pode ser inferior a R$ 0.0";
        } else {
            m = "Melhor escolha: ";
            m += e / g < 0.7 ? "Etanol" : "Gasolina";
        }

        res.setText(m);
    }

    public void clear(View v) {
        ep.setText("");
        gp.setText("");
        res.setText("");
        ep.requestFocus();
    }
}