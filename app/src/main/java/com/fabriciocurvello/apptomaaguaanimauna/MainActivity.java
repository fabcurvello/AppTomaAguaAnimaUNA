package com.fabriciocurvello.apptomaaguaanimauna;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvRelogio;
    private EditText etMensagem;
    private Button btCriarAlarme;

    private TimePickerDialog timePickerDialog;
    private Calendar calendar;

    private int hora;
    private int minuto;
    private String mensagem;


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

        iniciarComponentes();

    } // fim do onCreate()

    private void iniciarComponentes() {
        tvRelogio = findViewById(R.id.tv_relogio);
        etMensagem = findViewById(R.id.et_mensagem);
        btCriarAlarme = findViewById(R.id.bt_criar_alarme);
    }

    // Adiciona a View timePickerDialog para que o usuário defina a hora do alarme
    public void definirHoraAlarme(View view) {
        calendar = Calendar.getInstance();
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minuto = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaDoDia, int minutos) {
                String h = String.format("%02d", horaDoDia);
                String m = String.format("%02d", minutos);
                hora = Integer.parseInt(h);
                minuto = Integer.parseInt(m);
                tvRelogio.setText(h + ":" + m);
            }
        }, hora, minuto, true);
        timePickerDialog.show();
    } // fim do definirHoraAlarme()

    public void criarAlarme( View view ) {

        minimizaTeclado(btCriarAlarme);

        if ( !etMensagem.getText().toString().isEmpty() ) {
            mensagem = etMensagem.getText().toString();
        } else {
            mensagem = "!!! TOMA ÁGUA !!!";
        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minuto);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, mensagem);

        // Validação se existe app de alarme no celular
        if ( intent.resolveActivity(getPackageManager()) != null ) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Não existe app de alarme!", Toast.LENGTH_SHORT).show();
        }

    } // fim do criarAlarme()

    public void minimizaTeclado(Button button) {
        InputMethodManager imn = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imn.hideSoftInputFromWindow(button.getWindowToken(), 0);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


}