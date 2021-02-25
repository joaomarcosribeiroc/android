package com.example.gotz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gotz.Database.TestStandardEntity;

public class DefineStandard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_standard);
    }

    private boolean isOnlyNumbers(String s1, String s2){
        try {
            Integer.parseInt(s1);
            Integer.parseInt(s2);
        }catch (Exception e){
            Toast.makeText(this, R.string.WarnignOnlyNumbers,Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void saveOnRoom(View v){
               EditText editTextGerminacao = (EditText)findViewById(R.id.StandardGerminacaoEditText);
        EditText editTextVigor = (EditText)findViewById(R.id.StandardVigorEditText);

        boolean b = isOnlyNumbers(
                editTextGerminacao.getText().toString(),
                editTextVigor.getText().toString()
        );

        if(b) {
            MainActivity.mDB.testStandardDao().insertStandard(
                    new TestStandardEntity(
                            Integer.parseInt(editTextGerminacao.getText().toString()),
                            Integer.parseInt(editTextVigor.getText().toString()))
            );
            Toast.makeText(getApplicationContext(), R.string.QualityStandardSaved, Toast.LENGTH_LONG);
            this.finish();
        }else{
            clearScreen(editTextGerminacao, editTextVigor);
        }
    }

    private void clearScreen(EditText editText1, EditText editText2){
        editText1.clearComposingText();
        editText2.clearComposingText();
    }
}
