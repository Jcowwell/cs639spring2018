package com.example.jevon.cs639springhw1;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Detects if Animal Radio Button is Selected */
    boolean animalIsSelected = false;

    /* Stores Selected/Checked Animal Radio Button */
    RadioButton animalButton;

    /* Method Handler for when an Animal RadioButton is Selected/Checked */
    public void onAnimalButtonsClicked(View view) {

        // Determines if button is Selected/Checked
        boolean selected = ((RadioButton) view).isChecked();

        // Storing of Selected/Checked Button for changeColor()
        animalButton = ((RadioButton) view);

        // Stores 'selected' value for onColorButton()
        animalIsSelected = selected;

        // Checks which radio button was clicked
        switch(view.getId()) {
            case R.id.bird_button:
                if (selected)
                    //Show Bird Text_View
                    showText(findViewById(R.id.bird_text));
                    break;
            case R.id.cat_button:
                if (selected)
                    //Show Bird Text_View
                    showText(findViewById(R.id.cat_text));
                    break;
            case R.id.dog_button:
                if (selected)
                    //Show Bird Text_View
                    showText(findViewById(R.id.dog_text));
                    break;
        }
    }

    public void showText(View view) {

        //Get Parent Layout View of TextViews
        LinearLayout PapaLayout = findViewById(R.id.fact_box);

        // Loop through Children TextViews in LinearView and make them all invisible
        for(int i=0; i < PapaLayout.getChildCount(); i++) {
            TextView txtView = (TextView) PapaLayout.getChildAt(i);
            txtView.setVisibility(View.INVISIBLE);
        }

        //Get the Selected/Checked Corresponding (RadioButton-TextView) TextView
        TextView txtView = findViewById(view.getId());

        //Make TextView Visible.
        if (txtView .getVisibility() == View.INVISIBLE)
            txtView.setVisibility(View.VISIBLE);

    }

    /* Method Handler for when a Color RadioButton is Selected/Checked */

    public void onColorButtonsClicked(View view) {

        // Determines if button is Selected/Checked
        boolean selected = ((RadioButton) view).isChecked();

        // Ensures user has selected/checked an Animal RadioButton via Toast Notification Message
        if (!animalIsSelected) {
            Toast.makeText(getApplication().getBaseContext(),R.string.toast_message, Toast.LENGTH_SHORT).show();
            return;
        }
        // Checks which radio button was clicked and executes color change
        switch(view.getId()) {
            case R.id.red_color:
                if (selected)
                    changeColor(R.color.red);
                break;
            case R.id.blue_color:
                if (selected)
                    changeColor(R.color.blue);
                break;
            case R.id.green_color:
                if (selected)
                    changeColor(R.color.green);
                break;
            case R.id.purple_color:
                if (selected)
                    changeColor(R.color.purple);
                break;
            case R.id.yellow_color:
                if (selected)
                    changeColor(R.color.yellow);
                break;
        }
    }

    public void changeColor(int color) {
        animalButton.getBackground().setColorFilter(getResources().getColor(color),
                PorterDuff.Mode.SRC_ATOP);

    }
}

/* Developer Note (DN): I was unsure if whether or not you wanted the Animals to be "deselectable" or not so
  * I opted not to for simplicity sake (I'm sure an ActionListener for when RadioButtons are deselected and working for there would be enough to rectify this "feature" but since im clutch for time
   * for submitting this I'll work it in for HW#2. In hindsight, a Scroll Layout (with initial scrolling capabilities deactivated)
   * would be more appropriate for modularity and more efficient code expansion. I opted for using an Activity over a Fragment
   * and I fear that performance may suffer as a result.
   * */