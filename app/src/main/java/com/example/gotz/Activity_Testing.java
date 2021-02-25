package com.example.gotz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gotz.Database.TestDataEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Activity_Testing extends AppCompatActivity {
    /**Armazenará todos os registros de danos de maneira sequêncial
     * EX.: P1P3M5...*/
    static String MajorString;
    /**Armazena resultado para exibir em tela: "Resultado 89/85"*/
    private String ResultString;
    /**TextView para mostrar o resultado em tela*/
    private TextView ResultTextView;
    private TextView textViewForMajorString;
    static TestDataEntity testCurrentDataEntity;
    List<Integer> ListaDanosUmidade = new ArrayList<>();
    List<Integer> ListaDanosMecanicos = new ArrayList<>();
    List<Integer> ListaDanosPercevejos = new ArrayList<>();
    List<View> TwoLastButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Verifica se o padrão de qualidade do ministério está armazenado no database
         * Se não há registro, orienta o usuário para registrar o padrão de qualidade
         * mostrando um botão para a tela de registro*/
        if (MainActivity.mDB.testStandardDao().getStandard() == null) {
            setContentView(R.layout.testingblocked);
        }
        /**Se já há um resgistro do padrão do ministério, iniciamos a tela de coleta*/
        else {
            setContentView(R.layout.testing);
            MajorString = "";
            ResultTextView = findViewById(R.id.Result);
            ResultTextView.setText(R.string.WithoutResultYet);

            textViewForMajorString = findViewById(R.id.TextViewMajorString);
        }
    }

    /**Método para lidar com os toques nos botões de resgistro de danos*/
    public void listenButtons(View v) {
        Button button = (Button) v;
        if (button.getText().equals("U1")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("U2")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("U3")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("U4")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("U5")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("U6")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M1")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M2")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M3")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M4")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M5")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("M6")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P1")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P2")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P3")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P4")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P5")) {
            concatMajorString(button.getText().toString());
        } else if (button.getText().equals("P6")) {
            concatMajorString(button.getText().toString());
        }
        updateResult(MajorString);
        textViewForMajorString.setText(MajorString);

        TwoLastButtons.add(v);
        if(TwoLastButtons.size()>=2){
            if(TwoLastButtons.size()>=3)TwoLastButtons.get(TwoLastButtons.size()-3).setBackgroundColor(getResources().getColor(R.color.ButtonColor1));
            TwoLastButtons.get(TwoLastButtons.size()-2).setBackgroundColor(getResources().getColor(R.color.SecondLastTouchedButtonColor));
            TwoLastButtons.get(TwoLastButtons.size()-1).setBackgroundColor(getResources().getColor(R.color.LastTouchedButtonColor));

        }
    }

    /**Método para concatenar resgistros de danos no final da String principal
     * de danos*/
    void concatMajorString(String s) {
        MajorString = MajorString.concat(s);
    }

    /**Atualiza a mensagem de resultado exibido em tela: Resultado 95/90.
     * Retorna 0 se a string principal de registro de danos está vazia.
     * Retorna 1 se a atualização ocorreu com sucesso*/
    private int updateResult(String MajorString) {
        if (MajorString.isEmpty()) {
            Toast.makeText(this,R.string.UseButtons, Toast.LENGTH_LONG).show();
            return 0;
        }

        calculaPorcentagemDeDanos();

        ResultString = getString(R.string.Result) + ": " + calculaGerminacao(MajorString) + "/" + calculaVigor(MajorString);
        ResultTextView.setText(ResultString);
        Toast.makeText(this,R.string.ResultUpdated, Toast.LENGTH_SHORT).show();
        return  1;
    }

    /**Efetua o cálculo da germinação de acordo com a MajorString.
     * Apenas danos nas classes 6, 7 e 8 afetam a germinação*/
    int calculaGerminacao(String MajorString) {
        int NaoNascem = 0;
        for (int i = 0; i < MajorString.length(); i++) {
            if (MajorString.charAt(i) == '6') {
                NaoNascem++;
            }
        }
        return 100 - NaoNascem;
    }

    /**Efetua o cálculo do vigor de acordo com a MajorString.
     * Apenas danos nas classes 6, 5 e 4 afetam o vigor*/
    int calculaVigor(String MajorString) {
        int NaoVingam = 0;
        for (int i = 0; i < MajorString.length(); i++) {
            if (MajorString.charAt(i) == '6' || MajorString.charAt(i) == '5' || MajorString.charAt(i) == '4') {
                NaoVingam++;
            }
        }
        return 100 - NaoVingam;
    }

    /**Método para chamar a Activity pela qual se define o padrão de qualidade*/
    public void callDefineStandard(View v){
        Intent intent = new Intent(this, DefineStandard.class);
        startActivity(intent);
        this.finish();
    }

    /**Verifica se as informações do teste foram preenchidas*/
    private boolean isTestInformationEmpty(){
        EditText NomeCultivar = findViewById(R.id.CultivarEditText);
        EditText LoteCultivar = findViewById(R.id.LoteEditText);

        if(NomeCultivar.getText().toString().isEmpty() ||
           LoteCultivar.getText().toString().isEmpty()){
            return true;
        }else return false;
    }

    /**Método usado para salvar resultados do teste no database*/
    public void saveTestClone(View saveButton){
        saveTest();
    }
    public int saveTest(){
        /**Retorna 0 se a string principal de registro de danos está vazia*/
        if(updateResult(MajorString)==0){
            return 0;
        }
        /**Retorna 0 se as informações de teste estão vazias*/
        if(isTestInformationEmpty()){
            Toast.makeText(this, getString(R.string.TypeTheTestInformation), Toast.LENGTH_LONG).show();
            return 0;
        }

        EditText NomeCultivar = findViewById(R.id.CultivarEditText);
        EditText LoteCultivar = findViewById(R.id.LoteEditText);

        /**Registrando data e hora do teste*/
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = localDateTime.format(myFormatObj);

        testCurrentDataEntity = new TestDataEntity(
                NomeCultivar.getText().toString(),
                LoteCultivar.getText().toString(),
                formattedDate,
                ResultString,
                ListaDanosUmidade,
                ListaDanosMecanicos,
                ListaDanosPercevejos
        );
        MainActivity.mDB.testDataDao().insertTest(testCurrentDataEntity);
        return 1;
    }
    /**Método para voltar para a Activity inicial sem salvar dados do teste*/
    public void discardTest(View discardButton){
        Toast.makeText(this, getString(R.string.DiscardedResult),Toast.LENGTH_LONG).show();
        this.finish();
    }

    /**Calcular a quantidade de danos de acordo(int B) com o tipo e a classe(char A)*/
    static public float calculaNumeroDeDanosAPorClasseB(char A, int B){
        int answer=0;
        for(int i = 0; i<MajorString.length();i++){
            if(MajorString.charAt(i) == A && String.valueOf(MajorString.charAt(i+1)).equals(String.valueOf(B))){
                answer++;
            }
        }
        return answer;
    }
/**Método calcula a porcentagem de danos para cada classe, e registra isso nas listas de porcetagem de danos*/
    void calculaPorcentagemDeDanos(){

        for(int i = 1; i<=6;i++) {
            ListaDanosUmidade.add((int)calculaNumeroDeDanosAPorClasseB('U', i));
        }
        for(int i = 1; i<=6;i++) {
            ListaDanosMecanicos.add((int)calculaNumeroDeDanosAPorClasseB('M', i));
        }
        for(int i = 1; i<=6;i++) {
            ListaDanosPercevejos.add((int)calculaNumeroDeDanosAPorClasseB('P', i));
        }

    }

    /**Método para abrir a activity com o relatório gerado*/
    public void gerarRelatório(View v){
        if(!(saveTest()==0)) {
            saveTest();
            Intent intent = new Intent(this, Relatorio.class);
            startActivity(intent);
        }
    }


}