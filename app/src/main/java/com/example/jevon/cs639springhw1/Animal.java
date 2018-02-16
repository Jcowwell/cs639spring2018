/**
 * Created by Jcowell on 2/15/2018.
 */

package com.example.jevon.cs639springhw1;


import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    // content of the animals item
    private int imageId;
    private String name;
    private List<String> facts;
    private int color;
    private int factIndex;

    // animal item constructor
    public Animal(int imageId, String animalName, String fact ) {
        this.name = animalName;
        this.imageId = imageId;
        this.facts = new ArrayList<String>();
        facts.add(fact);

        this.color = Color.BLACK;
        this.factIndex = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setmColor(int mColorFilter) {
        this.color = mColorFilter;
    }

    public int getmColor() { return color; }

    public void addNewFact(String newFact){
        facts.add(newFact);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFacts() {
        return facts.get(factIndex).trim();
    }

    public void setFacts(List<String> facts) { this.facts = facts; }

    //Animal Next Index
    public void getNextIndex(){
        if (factIndex >= facts.size()-1) factIndex = 0;
        else factIndex++;
    }
    // Animal Delete Fact
    public boolean deleteFact(){
        if (facts.size() <=1){
            return false;
        }
        else {
            facts.remove(factIndex);
            factIndex =0;
            return true;
        }
    }


}
