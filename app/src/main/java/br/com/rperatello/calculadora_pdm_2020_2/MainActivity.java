package br.com.rperatello.calculadora_pdm_2020_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;
    private String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visorTv = findViewById(R.id.visorTv);
        visorTv.setText(getString(R.string.zero));
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