package com.calculatorapplication;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.os.Vibrator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.calculatorapplication.databinding.ActivityMainBinding;

import org.mariuszgromada.math.mxparser.Expression;



import android.os.VibrationEffect;
import android.os.Vibrator;
import android.content.Context;

import android.os.VibrationEffect;
 import android.os.Vibrator;
 import android.content.Context;
 import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {






    String Number;

    ActivityMainBinding mainBinding;

    int countParOn=0;

    int countParof=0;

    boolean operator=false;

    boolean dotcontrole=false;

    String result;

    boolean buttonEqualControl = false ;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.textResult.setText("0");

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        sharedPreferences=this.getSharedPreferences(" com.calculatorapplication", Context.MODE_PRIVATE);


        int[] buttonIds = {R.id.btnEqual, R.id.btnParOff, R.id.btnParOn, R.id.btnAdd, R.id.btnDel, R.id.btnSub, R.id.btnMulti, R.id.btnDiv, R.id.btnDec, R.id.btnAc, R.id.btn2}; // Add all your button IDs
        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnLongClickListener(v -> {

                Toast.makeText(this, button.getText(), Toast.LENGTH_SHORT).show();
                return true;
            });
        }


        mainBinding.btn1.setOnClickListener(v -> {

            onNumberClicked("1");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn2.setOnClickListener(v -> {

            onNumberClicked("2");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn3.setOnClickListener(v -> {

            onNumberClicked("3");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn4.setOnClickListener(v -> {

            onNumberClicked("4");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });


        mainBinding.btn5.setOnClickListener(v -> {

            onNumberClicked("5");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn6.setOnClickListener(v -> {

            onNumberClicked("6");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn7.setOnClickListener(v -> {

            onNumberClicked("7");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn8.setOnClickListener(v -> {

            onNumberClicked("8");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        mainBinding.btn9.setOnClickListener(v -> {

            onNumberClicked("9");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });


//        mainBinding.btn00.setOnClickListener(v -> {
//
//            onNumberClicked("00");
//
//
//            if (vibrator != null) {
//                // Vibrate for a small duration (50ms)
//                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
//            }
//        });

        mainBinding.btn2.setOnClickListener(v -> {

            onNumberClicked("2");


            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });


        mainBinding.btnParOn.setOnClickListener(v -> {

            onParClicked("(");

            if (vibrator != null) {
                // Vibrate for a small duration (50ms)
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            }

            countParOn++;

        });


        mainBinding.btnParOff.setOnClickListener(v -> {

            if (countParof < countParOn) {

                onParClicked(")");

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }

                countParof++;

            }

        });


        mainBinding.btnAdd.setOnClickListener(v -> {

            if (!operator && !dotcontrole) {

                if (Number == null) {

                    Number = "0+";
                } else if (buttonEqualControl) {

                    Number = result + "+";

                } else {

                    Number += "+";
                }

                mainBinding.textResult.setText(Number);
                operator = true;
                dotcontrole = true;
                buttonEqualControl = false;
                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            }


        });



        mainBinding.btnSub.setOnClickListener(v -> {

            if (!operator && !dotcontrole) {

                if (Number == null) {

                    Number = "0-";
                } else if (buttonEqualControl) {

                    Number = result + "-";

                } else {

                    Number += "-";
                }

                mainBinding.textResult.setText(Number);
                operator = true;
                dotcontrole = true;
                buttonEqualControl = false;
                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }


            }


        });


        mainBinding.btnMulti.setOnClickListener(v -> {

            if (!operator && !dotcontrole) {

                if (Number == null) {

                    Number = "0*";
                } else if (buttonEqualControl) {

                    Number = result + "/";

                } else {

                    Number += "*";
                }
                mainBinding.textResult.setText(Number);
                operator = true;
                dotcontrole = true;
                buttonEqualControl = false;

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            }


        });


        mainBinding.btnDiv.setOnClickListener(v -> {

            if (!operator && !dotcontrole) {

                if (Number == null) {

                    Number = "0/";
                } else if (buttonEqualControl) {

                    Number = result + "/";

                } else {

                    Number += "/";
                }

                mainBinding.textResult.setText(Number);
                operator = true;
                dotcontrole = true;
                buttonEqualControl = false;

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            }


        });


        mainBinding.btnDec.setOnClickListener(v -> {

            if (!operator && !dotcontrole) {

                if (buttonEqualControl) {

                    if (!result.contains(".")) {


                        Number = result + ".";

                        mainBinding.textResult.setText(Number);
                        dotcontrole = true;
                        buttonEqualControl = false;
                    }

                } else {

                    if (Number == null) {

                        Number = "0.";

                        mainBinding.textResult.setText(Number);
                        operator = true;

                        dotcontrole = true;
                    } else {

                        String expressionAfterLastOperator = "";
                        String lastCharecter;

                        dotloop:
                        for (int i = Number.length() - 1; i >= 0; i--) {


                            lastCharecter = String.valueOf(Number.charAt(i));
                            switch (lastCharecter) {
                                case "+":
                                case "-":
                                case "*":
                                case "/":
                                    break dotloop;
                                default:
                                    expressionAfterLastOperator = lastCharecter.concat(expressionAfterLastOperator);
                                    break;


                            }
                        }

                        if (!expressionAfterLastOperator.contains(".")) {

                            Number += ".";

                            mainBinding.textResult.setText(Number);
                            operator = true;

                            dotcontrole = true;
                        }


                    }


                }

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }


            }


        });



        mainBinding.btnAc.setOnClickListener(v -> onButtonClickedAc());



        mainBinding.btnDel.setOnClickListener(v -> {

            if (Number == null || Number.length() == 1) {


                onButtonClickedAc();
            } else {

                String lastChar;

                lastChar = String.valueOf(Number.charAt(Number.length() - 1));

                switch (lastChar) {

                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case ".":
                        operator = false;
                        dotcontrole = false;
                        break;
                    case "(":
                        countParOn--;
                        break;
                    case ")":
                        countParof--;
                        break;
                }

                Number = Number.substring(0, Number.length() - 1);
                mainBinding.textResult.setText(Number);

                lastChar = String.valueOf(Number.charAt(Number.length() - 1));

                switch (lastChar) {

                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case ".":
                        operator = true;
                        dotcontrole = true;
                        break;
                }

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            }
        });


        mainBinding.btnEqual.setOnClickListener(v -> {

            String expressionForCalculate = mainBinding.textResult.getText().toString();


            int diffrence = countParOn - countParof;

            if (diffrence > 0) {

                for (int i = 0; i < diffrence; i++) {

                    expressionForCalculate = expressionForCalculate.concat(")");
                }
            }

            Expression expression = new Expression(expressionForCalculate);
            result = String.valueOf(expression.calculate());


            if (result.equals("NaN")) {

                checkDivisor(expressionForCalculate);


            } else {

                int indexOfDot = result.indexOf(".");
                String expressionAfterDot = result.substring(indexOfDot + 1);

                if (expressionAfterDot.equals("0")) {

                    result = result.substring(0, indexOfDot);
                }


                mainBinding.textResult.setText(result);
                mainBinding.textHistory.setText(expressionForCalculate.concat("=").concat(result));


                buttonEqualControl = true;
                operator = false;
                dotcontrole = false;
                countParof = 0;
                countParOn = 0;

                if (vibrator != null) {
                    // Vibrate for a small duration (50ms)
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }


            }


        });


        mainBinding.toolbar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.menuItem) {

                //intent

                Intent intent = new Intent(MainActivity.this,ChangeThemes.class);
                startActivity(intent);

                return true;


            }else {

                return false;
            }


        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor=sharedPreferences.edit();

        String textResultToSave=mainBinding.textResult.getText().toString();
        String textHistoryToSave=mainBinding.textHistory.getText().toString();
        String resultToSave= result;
        String numberToSave= Number;
        boolean operatorToSave= operator;
        boolean dotControlToSave= dotcontrole;
        boolean buttonEqualToSave= buttonEqualControl;
        int countOpenPar= countParOn;
        int countClosepar= countParof;

        editor.putString("resultText",textResultToSave);
        editor.putString("history",textHistoryToSave);
        editor.putString("result",resultToSave);
        editor.putString("number",numberToSave);
        editor.putBoolean("operator",operatorToSave);
        editor.putBoolean("equals",buttonEqualToSave);
        editor.putBoolean("dotControl",dotControlToSave);
        editor.putInt("countParOn",countOpenPar);
        editor.putInt("countParOf",countClosepar);

        editor.apply();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mainBinding.textResult.setText(sharedPreferences.getString("resultText","0"));
        mainBinding.textHistory.setText(sharedPreferences.getString("history","0"));
        result=sharedPreferences.getString("result","0");
        Number=sharedPreferences.getString("number","0");
        operator=sharedPreferences.getBoolean("operator",false);
        buttonEqualControl=sharedPreferences.getBoolean("equals",false);
        dotcontrole=sharedPreferences.getBoolean("dotControl",false);

        countParOn=sharedPreferences.getInt("countParOn",0);
        countParof=sharedPreferences.getInt("countParOf",0);


    }

    @Override
  protected void onResume() {
        super.onResume();


        sharedPreferences = this.getSharedPreferences("com.calculatorapplication", Context.MODE_PRIVATE);

      boolean isDarkMode =  sharedPreferences.getBoolean("switch",false);
      int currentMode= AppCompatDelegate.getDefaultNightMode();

      if( isDarkMode) {

          if (isDarkMode) {
              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


          } else {

              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
          }

      }
    }

  




    public void onNumberClicked(String clickedNumber) {

        if (Number == null || buttonEqualControl) {

            Number = clickedNumber;
            buttonEqualControl=false;

        } else {


            Number += clickedNumber;
        }

        mainBinding.textResult.setText(Number);

        operator=false;

        dotcontrole=false;


    }


    public void onParClicked(String clickedNumber) {

        if (Number == null || buttonEqualControl) {

            Number = clickedNumber;
            buttonEqualControl=false;


        } else {


            Number += clickedNumber;
        }

        mainBinding.textResult.setText(Number);


    }
    public void onButtonClickedAc(){

        Number=null;

        mainBinding.textResult.setText("0");
        mainBinding.textHistory.setText("");
        dotcontrole=false;
        operator=false;
        countParOn=0;
        countParof=0;
        buttonEqualControl=false;
        result="";

        Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (vibrator != null) {
            // Vibrate for a small duration (50ms)
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        }

    }

    @SuppressLint("SetTextI18n")
    public void checkDivisor(String expressionForCalcuate){

        if(expressionForCalcuate.contains("/")){
            int indexOfSlash =expressionForCalcuate.indexOf("/");
            String expressionAfterSlash=expressionForCalcuate.substring(indexOfSlash+1);
            Expression expression= new Expression(expressionAfterSlash);

            String newResult= String.valueOf( expression.calculate());

            if(newResult.contains("0.0")){

                mainBinding.textHistory.setText("Divisor cannot be zero");
            }else{

                checkDivisor(expressionAfterSlash);

            }

        }
        else {

            mainBinding.textHistory.setText("Syntex Error");
        }


    }


}