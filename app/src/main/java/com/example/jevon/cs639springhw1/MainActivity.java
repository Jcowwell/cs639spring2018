package com.example.jevon.cs639springhw1;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        Button myButton = (Button) findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), AnimalDisplayFragment.class);
                startActivity(myIntent);
            }
        });

        */
    }

    boolean animalIsSelected = false;
    RadioButton animalButton;

    public void onAnimalButtonsClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        animalButton = ((RadioButton) view);
        animalIsSelected = checked;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.bird_button:
                if (checked)
                    System.out.println("Bird");
                    //Show Text_View
                    show(findViewById(R.id.bird_text));
                    break;
            case R.id.cat_button:
                if (checked)
                    System.out.println("Cat");
                show(findViewById(R.id.cat_text));
                    break;
            case R.id.dog_button:
                if (checked)
                    System.out.println("Dog");
                show(findViewById(R.id.dog_text));
                    break;
        }
    }


    public void onColorButtonsClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (!animalIsSelected) {
            Toast.makeText(getApplication().getBaseContext(),R.string.toast_message, Toast.LENGTH_SHORT).show();
            return;
        }
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.red_color:
                if (checked)
                    System.out.println("Red");
                    changeColor(R.color.red);
                break;
            case R.id.blue_color:
                if (checked)
                    System.out.println("Blue");
                    changeColor(R.color.blue);
                break;
            case R.id.green_color:
                if (checked)
                    System.out.println("Green");
                    changeColor(R.color.green);
                break;
            case R.id.purple_color:
                if (checked)
                    System.out.println("Purple");
                    changeColor(R.color.purple);
                break;
            case R.id.yellow_color:
                if (checked)
                    System.out.println("Yellow");
                    changeColor(R.color.yellow);
                break;
        }
    System.out.println("Success");
    }



    public void show(View view) {
        LinearLayout PapaLayout = findViewById(R.id.fact_box);
        for(int i=0; i < PapaLayout.getChildCount(); i++) {
            TextView txtView = (TextView) PapaLayout.getChildAt(i);
            System.out.println(txtView.getText());
            txtView.setVisibility(View.INVISIBLE);
        }
        TextView txtView = (TextView)findViewById(view.getId());
        //Toggle
        if (txtView .getVisibility() == View.INVISIBLE)
            txtView.setVisibility(View.VISIBLE);
    }

    public void changeColor(int color) {
        animalButton.getBackground().setColorFilter(getResources().getColor(color),
                PorterDuff.Mode.SRC_ATOP);

    }
}
