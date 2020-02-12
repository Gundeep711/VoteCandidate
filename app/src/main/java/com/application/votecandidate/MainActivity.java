package com.application.votecandidate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static String txMain;
    TextView txtView1;
    TextView txtView2;
    TextView txtView3;
    TextView tx;
    int v1,v2,v3;
    int secondActivity=1;
    ArrayList<Integer> IDs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView1=findViewById(R.id.countText1);
        txtView2=findViewById(R.id.countText2);
        txtView3=findViewById(R.id.countText3);
        tx=findViewById(R.id.txtDisplay);

    }

    public void nextActivity(View view){

        Intent intentNext=new Intent(this,chooseCandidate.class);
        intentNext.putIntegerArrayListExtra("IDs",IDs);
        startActivityForResult(intentNext,secondActivity);
        //startActivity(intentNext);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == secondActivity) {
            if(resultCode == this.RESULT_OK){
                String result=data.getStringExtra("result");
                int uniqueID = data.getIntExtra("uniqueID",0);
                if(txMain.equalsIgnoreCase("Candidate 1")){
                    v1++;
                    txtView1.setText(v1+ " Votes");
                    IDs.add(uniqueID);
                }

                else if(txMain.equalsIgnoreCase("Candidate 2")){
                    v2++;
                    txtView2.setText(v2+ " Votes");
                    IDs.add(uniqueID);
                }
                else if(txMain.equalsIgnoreCase("Candidate 3"))
                {
                    v3++;
                    txtView3.setText(v3+ " Votes");
                    IDs.add(uniqueID);
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tx.setText("Please make your selection");
            }
        }
    }//onActivityResult

   /* @Override
    protected void onRestart() {
        if(txMain.equalsIgnoreCase("Candidate 1")){
            v1++;
            txtView1.setText(v1+ " Votes");
        }
        else if(txMain.equalsIgnoreCase("Candidate 2")){
            v2++;
            txtView2.setText(v2+ " Votes");
        }
        else if(txMain.equalsIgnoreCase("Candidate 3"))
        {
            v3++;
            txtView3.setText(v3+ " Votes");
        }
        super.onRestart();
    }*/
}
