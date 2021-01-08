package br.com.rperatello.calculadora_pdm_2020_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;
    private String value = "";
    private Double result = 0.0;
    private String op = "";

    //constante_para salvamento/restauração da variável de instãncia
    private final String VALOR_VISOR_TV = "VALOR_VISOR_TV";
    private final String RESULT = "RESULT";
    private final String OPERATION = "OPERATION";
    private final String ADVANCED = "ADVANCED";

    // Constantes para solicitação de permissões
    private final int CALL_PHONE_PERMISSION_REQUEST_CODE = 0;
    private final int CONFIGURACOES_REQUEST_CODE = 1;

    // Constante para o envio de parâmetros para a ConfiguracoesActivity
    public static final String EXTRA_CONFIGURACOES = "EXTRA_CONFIGURACOES";

    // Referência para objeto que armazena as configurações
    private Configuracoes configuracoes = new Configuracoes(false);

    protected void calculateResult() {
        if (!visorTv.getText().equals("0")){
            switch (this.op) {
                case "+":
                    this.result = result + Double.parseDouble(visorTv.getText().toString());
                    visorTv.setText(this.result.toString());
                    this.result = 0.0;
                    break;
                case "-":
                    this.result = result - Double.parseDouble(visorTv.getText().toString());
                    visorTv.setText(this.result.toString());
                    this.result = 0.0;
                    break;
                case "X":
                    this.result = result * Double.parseDouble(visorTv.getText().toString());
                    visorTv.setText(this.result.toString());
                    this.result = 0.0;
                    break;
                case "/":
                    this.result = result / Double.parseDouble(visorTv.getText().toString());
                    visorTv.setText(this.result.toString());
                    this.result = 0.0;
                    break;
            }
        } else {
            return;
        }
    }

    protected void sum(){
        if (!visorTv.getText().toString().equals("") && result == 0.0) {
            result = result + Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("=")) {
            result = Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("+")) {
            result = result + Double.parseDouble(visorTv.getText().toString());
        } else {
            this.fillDisplay(String.valueOf(result));
        }
        op = getString(R.string.sum);
        fillDisplay(getString(R.string.zero));
    }

    protected void sub(){
        if (!visorTv.getText().toString().equals("") && result == 0.0) {
            result = result + Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("=")) {
            result = Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("-")) {
            result = result - Double.parseDouble(visorTv.getText().toString());
        } else {
            this.fillDisplay(String.valueOf(result));
        }
        op = getString(R.string.sub);
        fillDisplay(getString(R.string.zero));
    }

    protected void mult(){
        if (!visorTv.getText().toString().equals("") && result == 0.0) {
            result = result + Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("=")) {
            result = Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("X")) {
            result = result * Double.parseDouble(visorTv.getText().toString());
        } else {
            this.fillDisplay(String.valueOf(result));
        }
        op = getString(R.string.mult);
        fillDisplay(getString(R.string.zero));
    }

    protected void div(){
        if (!visorTv.getText().toString().equals("") && result == 0.0) {
            result = result + Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("=")) {
            result = Double.parseDouble(visorTv.getText().toString());
        } else if (!visorTv.getText().toString().equals("") && result != 0.0 && op.equals("/")) {
            try {
            result = result / Double.parseDouble(visorTv.getText().toString());
            } catch (Exception error){
                fillDisplay("Erro");
            }
        } else {
            this.fillDisplay(String.valueOf(result));
        }
        op = getString(R.string.div);
        fillDisplay(getString(R.string.zero));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo completo");
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);
        if(savedInstanceState != null){
            //visorTv.setText(getString(R.string.zero));
            visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV, "0"));
        }

//        getSupportActionBar().setSubtitle("Tela Principal");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name), "onStart executado - iniciado ciclo visível");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name), "onResume executado - iniciado ciclo em primeiro plano");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name), "onPause executado - finalizado ciclo em primeiro plano");
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(getString(R.string.app_name), "onSaveInstanceState executado - salvando dados de instância");
        outState.putString(VALOR_VISOR_TV, visorTv.getText().toString());
        outState.putDouble(RESULT, result);
        outState.putString(OPERATION, op);
        outState.putBoolean(ADVANCED, configuracoes.getAvancada());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(getString(R.string.app_name), "onRestoreInstanceState executado - restaurando dados de instância");
        //visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV, getString(R.string.zero)));
        fillDisplay(savedInstanceState.getString(VALOR_VISOR_TV, getString(R.string.zero)));
        result = savedInstanceState.getDouble(RESULT, 0.0);
        op = savedInstanceState.getString(OPERATION, "");
        if(savedInstanceState.getBoolean(ADVANCED) && configuracoes != null){
            configuracoes.setAvancada(true);
            findViewById(R.id.raizQuadradaBt).setVisibility(View.VISIBLE);
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracoesMI:
//                Intent configuracoesIntent = new Intent(this, ConfiguracoesActivity.class);
//                startActivity(configuracoesIntent);
                Intent configuracoesIntent = new Intent("CONFIGURACOES");
                configuracoesIntent.putExtra(EXTRA_CONFIGURACOES, configuracoes);
                startActivityForResult(configuracoesIntent, CONFIGURACOES_REQUEST_CODE);
                return true;

            case R.id.siteIFSPMi:
                Uri site = Uri.parse("http://www.ifsp.edu.br");
                Intent siteIf = new Intent(Intent.ACTION_VIEW, site);
                startActivity(siteIf);
                return true;

            case R.id.chamarIFSPMi:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        Log.v(getString(R.string.app_name), "pronto para chamar requestPermission");
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSION_REQUEST_CODE);
                    }
                }
                Log.v(getString(R.string.app_name), "pronto para chamarIfsp");
                chamarIfsp();
                return true;

            case R.id.sairMI:
                finish();
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PHONE_PERMISSION_REQUEST_CODE){
            for (int resultado: grantResults) {
                if (resultado != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permissão necessária não concedida", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            chamarIfsp();
        }
    }

    private void chamarIfsp() {
        // Coloquei um ACTION_DIAL para que funcione em versões anteriores da 23.
        Uri phone = Uri.parse("tel:1137754501");
        Log.v(getString(R.string.app_name), "pronto para discar");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                Intent chamarIfIntent = new Intent(Intent.ACTION_CALL, phone);
                startActivity(chamarIfIntent);
            }
        }
        else {
            try {
                Intent chamarIfIntent = new Intent(Intent.ACTION_DIAL, phone);
                startActivity(chamarIfIntent);
            }
            catch(Exception e) {
                Toast.makeText(this, "Permissão necessária não concedida", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CONFIGURACOES_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            configuracoes = data.getParcelableExtra(EXTRA_CONFIGURACOES);
            if (configuracoes != null && configuracoes.getAvancada()){
                findViewById(R.id.raizQuadradaBt).setVisibility(View.VISIBLE);
            }
            else {
                findViewById(R.id.raizQuadradaBt).setVisibility(View.GONE);
            }
        }
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
            case R.id.pointBt:
                if(value.equals("0")){
                    fillDisplay("0.");
                } else if(value.contains(".")){
                    fillDisplay(value);
                } else {
                    fillDisplay( value + (getString(R.string.point)));
                }
                break;
            case R.id.raizQuadradaBt:
                String res = String.valueOf(Math.pow(Double.parseDouble(visorTv.getText().toString()), (1.0/2)));
                this.value = "0";
                visorTv.setText(res);
                break;
            case R.id.limparBt:
                fillDisplay(getString(R.string.zero));
                this.result = 0.0;
                break;
            case R.id.sumBt:
                this.sum();
                break;
            case R.id.subBt:
                this.sub();
                break;
            case R.id.multBt:
                this.mult();
                break;
            case R.id.divBt:
                this.div();
                break;
            case R.id.resBt:
                this.calculateResult();
                break;
        }
    }
}