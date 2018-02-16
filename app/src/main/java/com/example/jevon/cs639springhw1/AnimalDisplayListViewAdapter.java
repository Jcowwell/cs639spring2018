/**
 * Created by Jcowell on 2/15/2018.
 */
package com.example.jevon.cs639springhw1;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.List;


public class AnimalDisplayListViewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Animal> mAnimal;
    private View.OnClickListener onClickListener;
    private int mSelectedPosition= -1;

    //Adapter Constructor
    AnimalDisplayListViewAdapter(Context mContext, ArrayList<Animal> mAnimal, View.OnClickListener onClickListener) {
        Context mContext1 = mContext;
        this.mAnimal = mAnimal;
        this.onClickListener= onClickListener;
        this.mInflater= LayoutInflater.from(mContext);
    }
    //View Holder
    private class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        Button mNextFact;
        Button mDeleteFact;
        ViewHolder(View item){
            mImageView= (ImageView) item.findViewById(R.id.animal_img);
            mTextView= (TextView) item.findViewById(R.id.animal_fact_placeholder);
            mNextFact= (Button) item.findViewById(R.id.next_fact);
            mDeleteFact= (Button) item.findViewById(R.id.delete_fact);
            mNextFact.setOnClickListener(onClickListener);
            mDeleteFact.setOnClickListener(onClickListener);
            mNextFact.setFocusable(false);
            mDeleteFact.setFocusable(false);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        // for reuse of views
        if (convertView== null){
            convertView = mInflater.inflate(R.layout.list_item, null);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else viewHolder= (ViewHolder) convertView.getTag();
        Animal item= (Animal) getItem(position);

        //Attach the data to the viewHolder

        viewHolder.mTextView.setText(String.format("%s\n%s", item.getName(), item.getFacts()));
        viewHolder.mTextView.setVisibility(mSelectedPosition== position? View.VISIBLE: View.GONE);

        viewHolder.mImageView.setImageResource(item.getImageId());
        viewHolder.mImageView.setColorFilter(item.getmColor(), PorterDuff.Mode.SRC_IN);

        viewHolder.mNextFact.setTag(position);
        viewHolder.mNextFact.setVisibility(viewHolder.mTextView.getVisibility());

        viewHolder.mDeleteFact.setTag(position);
        viewHolder.mDeleteFact.setVisibility(viewHolder.mNextFact.getVisibility());

        return convertView;
    }

    @Override
    public int getCount() {
        return mAnimal.size();
    }
    @Override
    public Object getItem(int position) {
        return mAnimal.get(position);
    }
    @Override
    public long getItemId(int position) {
        return mAnimal.indexOf(getItem(position));
    }

    void setmSelectedPosition(int position){
        mSelectedPosition= position;
    }

    int getSelectedPosition(){
        return mSelectedPosition;
    }

}
