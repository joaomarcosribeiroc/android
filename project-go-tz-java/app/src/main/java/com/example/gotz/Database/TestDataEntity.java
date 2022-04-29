package com.example.gotz.Database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.gotz.Converters;

import java.util.List;

@Entity
public class TestDataEntity {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String Cultivar;
    private String Lote;
    private String DataEHora;
    private String Resultado;

    @TypeConverters(Converters.class)
    List<Integer> DanosUmidade;
    @TypeConverters(Converters.class)
    List<Integer> DanosMecanico;
    @TypeConverters(Converters.class)
    List<Integer> DanosPercevejo;

    //Constructors

    public TestDataEntity(String cultivar, String lote, String dataEHora, String resultado, List<Integer> danosUmidade, List<Integer> danosMecanico, List<Integer> danosPercevejo) {
        Cultivar = cultivar;
        Lote = lote;
        DataEHora = dataEHora;
        Resultado = resultado;
        DanosUmidade = danosUmidade;
        DanosMecanico = danosMecanico;
        DanosPercevejo = danosPercevejo;
    }

    public  TestDataEntity(){}

    //Getters and Setters

    public String getCultivar() {
        return Cultivar;
    }
    public void setCultivar(String cultivar) {
        Cultivar = cultivar;
    }

    public String getLote() {
        return Lote;
    }
    public void setLote(String lote) {
        Lote = lote;
    }

    public String getDataEHora() {
        return DataEHora;
    }
    public void setDataEHora(String dataEHora) {
        DataEHora = dataEHora;
    }

    public String getResultado() {
        return Resultado;
    }
    public void setResultado(String resultado) {
        Resultado = resultado;
    }

    public List<Integer> getDanosUmidade() {
        return DanosUmidade;
    }
    public void setDanosUmidade(List<Integer> danosUmidade) {
        DanosUmidade = danosUmidade;
    }

    public List<Integer> getDanosMecanico() {
        return DanosMecanico;
    }
    public void setDanosMecanico(List<Integer> danosMecanico) {
        DanosMecanico = danosMecanico;
    }

    public List<Integer> getDanosPercevejo() {
        return DanosPercevejo;
    }
    public void setDanosPercevejo(List<Integer> danosPercevejo) {
        DanosPercevejo = danosPercevejo;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    //MÉTODOS PARA PERMITR PARSE A CLASSE

}
