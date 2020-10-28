package br.com.rperatello.calculadora_pdm_2020_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;
    private String value = "";

    //constante_visor
    //private final VALOR_VISOR_TV =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo completo");
        setContentView(R.layout.activity_main);
        visorTv = findViewById(R.id.visorTv);
        if(savedInstanceState == null)
            visorTv.setText(getString(R.string.zero));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name), "onStart executado - iniciado ciclo visível");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getString(R.string.app_name), "onStop executado - finalizado ciclo visível");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getString(R.string.app_name), "onDestroy executado - finalizado ciclo completo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name), "onPause executado - finalizado ciclo em primeiro plano");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name), "onResume executado - iniciado ciclo em primeiro plano");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(getString(R.string.app_name), "onSaveInstanceState executado - salvando dados de instância");
        outState.putString(value, visorTv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(getString(R.string.app_name), "onRestoreInstanceState executado - restaurando dados de instância");
        visorTv.setText(savedInstanceState.getString(value, "0"));
    }

    public void fillDisplay(String value){
        this.value = value;
        visorTv.setText(value);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            //linha 1
            case R.id.zeroBt:
                if(!value.equals("") && !value.equals("0")){
                    fillDisplay( value + (getString(R.string.zero)));
                    Log.v(getString(R.string.app_name), getString(R.string.zero));
                }
                break;
            case R.id.oneBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.one));
                } else {
                    fillDisplay( value + (getString(R.string.one)));
                }
                break;
            case R.id.twoBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.two));
                } else {
                    fillDisplay( value + (getString(R.string.two)));
                }
                break;
            //linha 2
            case R.id.threeBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.three));
                } else {
                    fillDisplay( value + (getString(R.string.three)));
                }
                break;
            case R.id.fourBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.four));
                } else {
                    fillDisplay( value + (getString(R.string.four)));
                }
                break;
            case R.id.fiveBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.five));
                } else {
                    fillDisplay( value + (getString(R.string.five)));
                }
                break;
            //linha 3
            case R.id.sixBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.six));
                } else {
                    fillDisplay( value + (getString(R.string.six)));
                }
                Log.v(getString(R.string.app_name), getString(R.string.six));
                break;
            case R.id.sevenBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.seven));
                } else {
                    fillDisplay( value + (getString(R.string.seven)));
                }
                break;
            case R.id.eightBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.eight));
                } else {
                    fillDisplay( value + (getString(R.string.eight)));
                }
                break;
            case R.id.nineBt:
                if(value.equals("0")){
                    fillDisplay(getString(R.string.nine));
                } else {
                    fillDisplay( value + (getString(R.string.nine)));
                }
                break;
            //linha 4
            case R.id.limparBt:
                fillDisplay(getString(R.string.zero));
                break;
        }
    }
}