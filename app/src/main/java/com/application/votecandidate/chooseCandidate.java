package com.application.votecandidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class chooseCandidate extends AppCompatActivity {
    EditText edName;
    EditText edID;
    Spinner sp;
    TextView tx;
    TextView tx1;

    int uniqueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_candidate);
        edName=findViewById(R.id.editTextName);
        edID=findViewById(R.id.editTextID);
        sp=findViewById(R.id.spinnerArray);
        tx1=findViewById(R.id.choose1);


    }

    public void choose(View view) {
        MainActivity.txMain=sp.getSelectedItem().toString();
        ArrayList<Integer> IDs=getIntent().getIntegerArrayListExtra("IDs");
        uniqueID=Integer.valueOf(edID.getText().toString());
        System.out.println("hahahahahha " + IDs.size());
        if(IDs == null || !IDs.contains(uniqueID)){
            IDs.add(uniqueID);
            
        }
        else{
            tx1.setText("Please Enter the new ID");
            System.out.println(uniqueID);


        }

        tx1.setText("Thanks for your voting !! You have selected "+MainActivity.txMain);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",MainActivity.txMain);
        returnIntent.putExtra("uniqueID",uniqueID);
        setResult(MainActivity.RESULT_OK,returnIntent);
        finish();


    }


}
