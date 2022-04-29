package com.example.gotz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gotz.Database.TestDataEntity;

public class Relatorio extends AppCompatActivity {
    TextView Relatorio;
    TestDataEntity testDataEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        Relatorio = findViewById(R.id.TextViewRelatorio);

        testDataEntity = getTestData();

        throwRelatorioToScreen();
    }

    /**
     * Esse método vai gerar a String do relatório
     */
    private String makeRelatorio() {
        String relatorio =
                "Data de realização: " + testDataEntity.getDataEHora() + "\n" + "\n" +
                        "Cultivar: " + testDataEntity.getCultivar() + "\n" +
                        "Lote: " + testDataEntity.getLote() + "\n" +
                        testDataEntity.getResultado() + "\n" + "\n" +
                        "Seriedade de danos" + "\n" +
                        "   Umidade: " + defineGravidadeDeDano('U') + "\n" +
                        "   Mecânico: " + defineGravidadeDeDano('M') + "\n" +
                        "   Percevejo: " + defineGravidadeDeDano('P') + "\n" + "\n";

        relatorio = relatorio.concat("Distribuição dos danos por classe:\n");

        relatorio = relatorio.concat(" Umidade:\n");


        for (int i = 1; i <= 6; i++) {
            relatorio = relatorio.concat("  Classe " + i + ": " + (int)Activity_Testing.calculaNumeroDeDanosAPorClasseB('U', i)
            + " -> " + (int)(Activity_Testing.calculaNumeroDeDanosAPorClasseB('U', i)/calculaNumeroTotalDeDanos(Activity_Testing.MajorString)*100) +"%" +" \n");
        }

        relatorio = relatorio.concat(" Mecânico:\n");
        for (int i = 1; i <= 6; i++) {
            relatorio = relatorio.concat("  Classe " + i + ": " + (int)Activity_Testing.calculaNumeroDeDanosAPorClasseB('M', i) +
             " -> " + (int)(Activity_Testing.calculaNumeroDeDanosAPorClasseB('M', i)/calculaNumeroTotalDeDanos(Activity_Testing.MajorString)*100)+"%"+" \n");
        }

        relatorio = relatorio.concat(" Percevejo:\n");
        for (int i = 1; i <= 6; i++) {
            relatorio = relatorio.concat("  Classe " + i + ": " + (int)Activity_Testing.calculaNumeroDeDanosAPorClasseB('P', i) +
             " -> " + (int)(Activity_Testing.calculaNumeroDeDanosAPorClasseB('P', i)/calculaNumeroTotalDeDanos(Activity_Testing.MajorString)*100)+"%"+" \n");
        }
        return relatorio;
    }

    /**
     * Retorna uma string descrevendo a gravidade do dano de acordo com uma leitura da

     * MajorString
     */
    String defineGravidadeDeDano(char A) {
        String answer = "Erro";
        if (A == 'U') {
            if (testDataEntity.getDanosUmidade().get(5) <= 6) {
                answer = "Sem Restrição";
            } else if (testDataEntity.getDanosUmidade().get(5) <= 10) {
                answer = "Sério";
            } else if (testDataEntity.getDanosUmidade().get(5) > 10) {
                answer = "Muito Sério";
            }
            return answer;
        } else if (A == 'M') {
            if (testDataEntity.getDanosMecanico().get(5) <= 6) {
                answer = "Sem Restrição";
            } else if (testDataEntity.getDanosMecanico().get(5) <= 10) {
                answer = "Sério";
            } else if (testDataEntity.getDanosMecanico().get(5) > 10) {
                answer = "Muito Sério";
            }
        } else if (A == 'P') {
            if (testDataEntity.getDanosPercevejo().get(5) <= 6) {
                answer = "Sem Restrição";
            } else if (testDataEntity.getDanosPercevejo().get(5) <= 10) {
                answer = "Sério";
            } else if (testDataEntity.getDanosPercevejo().get(5) > 10) {
                answer = "Muito Sério";
            }
        }
        return answer;
    }

    void throwRelatorioToScreen() {
        this.Relatorio.setText(
                makeRelatorio()
        );
    }

    TestDataEntity getTestData() {
        testDataEntity = Activity_Testing.testCurrentDataEntity;
        return testDataEntity;
    }

    public float calculaNumeroTotalDeDanos(String MajorString){
        return MajorString.length()/2;
    }
}

