package com.example.poka.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.os.Vibrator;


public class Calculator01 extends Activity {

    //Déclaration des variables
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonC;
    Button buttonEgal;
    Button buttonPoint;
    //Button buttonVerbose;
    int nbrVerbose = 0;     //Décompte du nombre de verbose effectué
    int vibeSec = 60;       //Durée de la vibration des touches
    EditText ecran;         //Objet écran
    Vibrator vibe;          //Objet vibreur

    private double chiffre1;    //Chiffre
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    // Appelé lorsque l'activité est lancé pour la première fois
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator01);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //On lie nos variables aux ID de l'interface graphique
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonDiv = (Button) findViewById(R.id.buttonDivision);
        buttonMul = (Button) findViewById(R.id.buttonMultiplier);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        //buttonVerbose = (Button) findViewById(R.id.action_verbose);

        ecran = (EditText) findViewById(R.id.EditText01);

        //Attribution des écouteurs d'évènement à tous les boutons
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

        /*buttonVerbose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickVerbose();
            }
        });*/
    }

    //Methode lorsqu'on clique sur un chiffre
    public void chiffreClick(String str) {
        vibe.vibrate(vibeSec);
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0"))
                str = ecran.getText() + str;
        }
        ecran.setText(str);
    }

    //Lorsqu'on clique sur le bouton +
    public void plusClick(){
        vibe.vibrate(vibeSec);
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            if(ecran.getText().toString().isEmpty()); else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;}
        }
        operateur = "+";
        update = true;
    }

    //Lorsqu'on clique sur le bouton -
    public void moinsClick(){
        vibe.vibrate(vibeSec);
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            if(ecran.getText().toString().isEmpty()); else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;}
        }
        operateur = "-";
        update = true;
    }

    //Lorsqu'on clique sur le bouton *
    public void mulClick(){
        vibe.vibrate(vibeSec);
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            if(ecran.getText().toString().isEmpty()); else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;}
        }
        operateur = "*";
        update = true;
    }

    //Lorsqu'on clique sur le bouton /
    public void divClick(){
        vibe.vibrate(vibeSec);
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            if(ecran.getText().toString().isEmpty()); else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;}
        }
        operateur = "/";
        update = true;
    }

    //Lorsqu'on clique sur le bouton =
    public void egalClick(){
        vibe.vibrate(vibeSec);
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            if(ecran.getText().toString().isEmpty()); else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;}
        }
        operateur = "=";
        update = true;
        chiffre1 = 0;
    }

    //Lorsqu'on clique sur le bouton C
    public void resetClick(){
        vibe.vibrate(vibeSec);
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }

    //Methode de calcul
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")) {
            try {
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } catch (ArithmeticException e) {
                ecran.setText("0");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_verbose) {
            nbrVerbose++;
            System.out.println("Verbose N° " + nbrVerbose);
            System.out.println("clicOperateur = " + clicOperateur);
            System.out.println("update = " + update);
            System.out.println("chiffre1 = " + chiffre1);
            System.out.println("operateur = " + operateur);
            System.out.println("Contenu de l'écran = " + ecran.getText().toString());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
