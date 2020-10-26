package br.com.rperatello.calculadora_pdm_2020_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            //linha 1
            case R.id.l1zeroBt:
                visorTv.setText(getString(R.string.l1zero));
                Log.v(getString(R.string.app_name), getString(R.string.l1zero));
                break;
            case R.id.l1umBt:
                visorTv.setText(getString(R.string.l1um));
                break;
            case R.id.l1doisBt:
                visorTv.setText(getString(R.string.l1dois));
                break;
            //linha 2
            case R.id.l2zeroBt:
                visorTv.setText(getString(R.string.l2zero));
                Log.v(getString(R.string.app_name), getString(R.string.l2zero));
                break;
            case R.id.l2umBt:
                visorTv.setText(getString(R.string.l2um));
                break;
            case R.id.l2doisBt:
                visorTv.setText(getString(R.string.l2dois));
                break;
            //linha 3
            case R.id.l3zeroBt:
                visorTv.setText(getString(R.string.l3zero));
                Log.v(getString(R.string.app_name), getString(R.string.l3zero));
                break;
            case R.id.l3umBt:
                visorTv.setText(getString(R.string.l3um));
                break;
            case R.id.l3doisBt:
                visorTv.setText(getString(R.string.l3dois));
                break;
            //linha 4
            case R.id.limparBt:
                visorTv.setText("");
                break;
        }
    }
}