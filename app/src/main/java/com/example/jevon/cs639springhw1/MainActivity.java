/**
 * Created by Jcowell on 2/15/2018.
 */

package com.example.jevon.cs639springhw1;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayList<Animal> animalDataitems = new ArrayList<>();
    AnimalDisplayListViewAdapter animalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.animal_list);

        /* Add Colors */
        View red = (View) findViewById(R.id.red);
        View blue = (View) findViewById(R.id.blue);
        View green = findViewById(R.id.green);
        View purple = (View) findViewById(R.id.purple);
        View yellow = (View) findViewById(R.id.yellow);
        Button addFact = (Button) findViewById(R.id.button);

        animalAdapter = new AnimalDisplayListViewAdapter(getBaseContext(), getDataSet(), new OnClickListener() {
            /* Next Fact & Delete Fact onClick Listeners*/
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.next_fact:
                        //If Next Fact Button
                        int v = (int) view.getTag();
                        Animal item = (Animal) animalAdapter.getItem(v);
                        item.getNextIndex();
                        break;
                    case R.id.delete_fact:
                        //If Delete Fact Button
                        int v1 = (int) view.getTag();
                        Animal item1 = (Animal) animalAdapter.getItem(v1);
                        //Check if last item
                        if (item1.deleteFact())
                            Toast.makeText(getBaseContext(), R.string.item_deleted, Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getBaseContext(), R.string.delete_fails, Toast.LENGTH_SHORT).show();
                }
                animalAdapter.notifyDataSetChanged();
            }
        });
        //Notify List that Data has Changed
        animalAdapter.notifyDataSetChanged();
        mListView.setAdapter(animalAdapter);
        mListView.setItemsCanFocus(false);

        //Row onCLickListener
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // return the position of the clicked item to the adapter
                animalAdapter.setmSelectedPosition(i);
                animalAdapter.notifyDataSetChanged();
            }
        });

        //Color Click Listener
        View.OnClickListener colorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get selected item from the adapter
                int mSelectedImage = animalAdapter.getSelectedPosition();
                int viewBackgroundColor = ((ColorDrawable) view.getBackground()).getColor();
                Animal i = (Animal) animalAdapter.getItem(mSelectedImage);
                //change the value of mcolorFilter in the DataItem
                i.setmColor(viewBackgroundColor);
                animalAdapter.notifyDataSetChanged();
            }
        };
        //Assigning Colors onCLickListener.
        red.setOnClickListener(colorListener);
        blue.setOnClickListener(colorListener);
        green.setOnClickListener(colorListener);
        purple.setOnClickListener(colorListener);
        yellow.setOnClickListener(colorListener);

        //New Fact onCLickListener
        addFact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText factField = (EditText) findViewById(R.id.fact_edit_text_view);
                factField.requestFocus();
                int mPos = animalAdapter.getSelectedPosition();
                String newFact = factField.getText().toString().trim();
                //Check if the field is empty
                if (TextUtils.isEmpty(newFact))
                    Toast.makeText(getBaseContext(), R.string.enter_fact, Toast.LENGTH_SHORT).show();
                    //Check if animal is selected
                else if (mPos == -1)
                    Toast.makeText(getBaseContext(), R.string.select_animal, Toast.LENGTH_SHORT).show();
                else {
                    // Add new fact to the DataItem ArrayList
                    Animal addFactItem = (Animal) animalAdapter.getItem(mPos);
                    addFactItem.addNewFact(newFact);
                    factField.getText().clear();
                    factField.setEnabled(false);
                    Toast.makeText(getBaseContext(), R.string.fact_add_success, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // //Populatse Animal List Data with Animals
    private ArrayList<Animal> getDataSet() {
        animalDataitems.add(new Animal(R.drawable.bird, "Bird", "This is bird fact"));
        animalDataitems.add(new Animal(R.drawable.cat, "Cat", "This is cat fact"));
        animalDataitems.add(new Animal(R.drawable.dog, "Dog", "This is dog fact"));
        animalDataitems.add(new Animal(R.drawable.bug, "Bug", "This is bug fact"));
        animalDataitems.add(new Animal(R.drawable.duck, "Duck", "This is duck fact"));
        animalDataitems.add(new Animal(R.drawable.fish, "Fish", "This is fish fact"));
        animalDataitems.add(new Animal(R.drawable.frog, "Frog", "This is frog fact"));
        animalDataitems.add(new Animal(R.drawable.octopus, "Octopus", "This is octopus fact"));
        animalDataitems.add(new Animal(R.drawable.monkey, "Monkey", "This is monkey fact"));
        animalDataitems.add(new Animal(R.drawable.snail, "Snail", "This is snail Fact"));
        return animalDataitems;
    }

}



/* Dev Note: For some reason I can't get the Keyboard to show up a second time. I tired editing the Manifest with no luck.
I think it has to do with the List View somehow overtaking the edit_text
 */