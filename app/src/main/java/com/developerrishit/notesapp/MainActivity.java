package com.developerrishit.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    EditText editText1;
    Button save;
    Button delete;

    TextView text2;
    EditText editText2;
    Button save2;
    Button delete2;
    TextView text3;
    EditText editText3;
    TextView line1;
    TextView line2;
    Button save3;
    Button delete3;
    int counter3 = 0;
    int counter = 0;
    int counter2 = 0;
    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        boolean firstStart = pref.getBoolean("firstStart", true);
        if (firstStart) {
            welcomeDialog();
        }
        text1 = findViewById(R.id.text);
        line1 = findViewById(R.id.line1);
        editText1 = findViewById(R.id.editText);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        SharedPreferences getcounter = getSharedPreferences("demo",MODE_PRIVATE);
        counter = getcounter.getInt("check",0);
        if(counter%2==0 || counter==0){
            save.setAlpha(1);
            editText1.setAlpha(1);
            text1.setAlpha(0);
            line1.setAlpha(0);
            delete.setAlpha(0);
        } else
        {
            save.setAlpha(0);
            editText1.setAlpha(0);
            text1.setAlpha(1);
            line1.setAlpha(1);
            delete.setAlpha(1);
        }
        editText1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (view.getId() == R.id.editText) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction()&MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                String n1 = editText1.getText().toString();
                if (n1.equals("")){
                    n1="Write Something";
                }
                SharedPreferences shrd1 = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor= shrd1.edit();
                editor.putInt("check",Integer.valueOf(counter));
                editor.putString("str1",n1);
                editor.apply();
                save.setAlpha(0);
                editText1.setAlpha(0);
                editText1.setText("");
                text1.setAlpha(1);
                text1.setText(n1);
                line1.setAlpha(1);
                delete.setAlpha(1);
            }
        });
        SharedPreferences getShared1 = getSharedPreferences("demo", MODE_PRIVATE);
        String value = getShared1.getString("str1", " Write Something");
        text1.setText(value);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                SharedPreferences del = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor delEdit = del.edit().remove("str1");
                delEdit.putInt("check",Integer.valueOf(counter));
                delEdit.apply();
                text1.setAlpha(0);
                editText1.setAlpha(1);
                save.setAlpha(1);
                line1.setAlpha(0);
                delete.setAlpha(0);
                text1.setText("");
            }
        });


        text2 = findViewById(R.id.textb);
        editText2 = findViewById(R.id.editTextb);
        save2 = findViewById(R.id.saveb);
        line2=findViewById(R.id.line2);
        delete2 = findViewById(R.id.deleteb);
        SharedPreferences getcounter2 = getSharedPreferences("dem",MODE_PRIVATE);
        counter2 = getcounter2.getInt("check",0);
        if(counter2%2==0 || counter2==0){
            save2.setAlpha(1);
            editText2.setAlpha(1);
            text2.setAlpha(0);
            line2.setAlpha(0);
            delete2.setAlpha(0);
        } else
        {
            save2.setAlpha(0);
            editText2.setAlpha(0);
            text2.setAlpha(1);
            line2.setAlpha(1);
            delete2.setAlpha(1);
        }
        editText2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (view.getId() == R.id.editTextb) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction()&MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                String n2 = editText2.getText().toString();
                if (n2.equals("")){
                    n2="Write Something";
                }
                SharedPreferences shrd2 = getSharedPreferences("dem", MODE_PRIVATE);
                SharedPreferences.Editor editor= shrd2.edit();
                editor.putInt("check",Integer.valueOf(counter2));
                editor.putString("str2",n2);
                editor.apply();
                save2.setAlpha(0);
                editText2.setAlpha(0);
                editText2.setText("");
                text2.setAlpha(1);
                text2.setText(n2);
                line2.setAlpha(1);
                delete2.setAlpha(1);
            }
        });
        SharedPreferences getShared2 = getSharedPreferences("dem", MODE_PRIVATE);
        String value2 = getShared2.getString("str2", " Write Something");
        text2.setText(value2);

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                SharedPreferences del2 = getSharedPreferences("dem", MODE_PRIVATE);
                SharedPreferences.Editor delEdit = del2.edit().remove("str2");
                delEdit.putInt("check",Integer.valueOf(counter2));
                delEdit.apply();
                text2.setAlpha(0);
                editText2.setAlpha(1);
                save2.setAlpha(1);
                line2.setAlpha(0);
                delete2.setAlpha(0);
                text2.setText("");
            }
        });

        text3 = findViewById(R.id.textc);
        editText3 = findViewById(R.id.editTextc);
        save3 = findViewById(R.id.savec);
        delete3 = findViewById(R.id.deletec);
        SharedPreferences getcounter3 = getSharedPreferences("demo3",MODE_PRIVATE);
        counter3 = getcounter3.getInt("check",0);
        if(counter3%2==0 || counter3==0){
            save3.setAlpha(1);
            editText3.setAlpha(1);
            text3.setAlpha(0);
            delete3.setAlpha(0);
        } else
        {
            save3.setAlpha(0);
            editText3.setAlpha(0);
            text3.setAlpha(1);
            delete3.setAlpha(1);
        }
        editText3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (view.getId() == R.id.editTextc) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction()&MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                String n3 = editText3.getText().toString();
                if (n3.equals("")){
                    n3="Write Something";
                }
                SharedPreferences shrd3 = getSharedPreferences("demo3", MODE_PRIVATE);
                SharedPreferences.Editor editor= shrd3.edit();
                editor.putInt("check",Integer.valueOf(counter3));
                editor.putString("str3",n3);
                editor.apply();
                save3.setAlpha(0);
                editText3.setAlpha(0);
                editText3.setText("");
                text3.setAlpha(1);
                text3.setText(n3);
                delete3.setAlpha(1);
            }
        });
        SharedPreferences getShared3 = getSharedPreferences("demo3", MODE_PRIVATE);
        String value3 = getShared3.getString("str3", " Write Something");
        text3.setText(value3);

        delete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                SharedPreferences del3 = getSharedPreferences("demo3", MODE_PRIVATE);
                SharedPreferences.Editor delEdit = del3.edit().remove("str3");
                delEdit.putInt("check",Integer.valueOf(counter3));
                delEdit.apply();
                text3.setAlpha(0);
                editText3.setAlpha(1);
                save3.setAlpha(1);
                delete3.setAlpha(0);
                text3.setText("");
            }
        });


    }

    public void welcomeDialog() {
        AlertDialog.Builder ImageDialog = new AlertDialog.Builder(MainActivity.this);
        ImageDialog.setTitle("WELCOME");
        ImageView showImage = new ImageView(MainActivity.this);
        showImage.setImageResource(R.drawable.relogo);
        ImageDialog.setMessage("\n\nIn this App you can write and store Quick Notes");
        ImageDialog.setView(showImage);

        ImageDialog.setNegativeButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                writeDialog();
            }
        });
        ImageDialog.show();
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }
    public void writeDialog() {
        AlertDialog.Builder ImageDialog2 = new AlertDialog.Builder(MainActivity.this);
        ImageDialog2.setTitle("Quick Notes");
        ImageDialog2.setIcon(R.drawable.relogo);
        ImageView showImage2 = new ImageView(MainActivity.this);
        showImage2.setImageResource(R.drawable.write);
        ImageDialog2.setView(showImage2);
        ImageDialog2.setMessage("\n\nYou can write your note here and \n SAVE it for future use");

        ImageDialog2.setNegativeButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                shortDialog();
            }
        });
        ImageDialog2.show();
    }
    public void shortDialog() {
        AlertDialog.Builder ImageDialog3 = new AlertDialog.Builder(MainActivity.this);
        ImageDialog3.setTitle("Quick Notes");
        ImageDialog3.setIcon(R.drawable.relogo);
        ImageView showImage3 = new ImageView(MainActivity.this);
        showImage3.setImageResource(R.drawable.shortnote);
        ImageDialog3.setView(showImage3);
        ImageDialog3.setMessage("\n\nWhenever you will open your app \n Your Note will be present here\n You can DELETE it anytime");

        ImageDialog3.setNegativeButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                longDialog();
            }
        });
        ImageDialog3.show();
    }
    public void longDialog() {
        AlertDialog.Builder ImageDialog4 = new AlertDialog.Builder(MainActivity.this);
        ImageDialog4.setTitle("Quick Notes");
        ImageDialog4.setIcon(R.drawable.relogo);
        ImageView showImage4 = new ImageView(MainActivity.this);
        showImage4.setImageResource(R.drawable.longnotes);
        ImageDialog4.setView(showImage4);
        ImageDialog4.setMessage("\n\nYou can write Short as well as Long Multiple lines Notes\n ");

        ImageDialog4.setPositiveButton("Get Started", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        ImageDialog4.show();
    }

}