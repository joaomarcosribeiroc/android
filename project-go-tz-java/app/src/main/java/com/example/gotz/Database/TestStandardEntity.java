package com.example.gotz.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TestStandardEntity {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private int StandardGerminacao;
    private int StandardVigor;

    public int getStandardGerminacao() {
        return StandardGerminacao;
    }

    public void setStandardGerminacao(int standardGerminacao) {
        StandardGerminacao = standardGerminacao;
    }

    public int getStandardVigor() {
        return StandardVigor;
    }

    public void setStandardVigor(int standardVigor) {
        StandardVigor = standardVigor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    //CONSTRUCTOR

    public TestStandardEntity(int standardGerminacao, int standardVigor) {
        StandardGerminacao = standardGerminacao;
        StandardVigor = standardVigor;
    }

    public TestStandardEntity() {
    }
}
