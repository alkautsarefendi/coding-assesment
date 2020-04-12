package com.example.testcoddingalkautsar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class AndroidDataAdapter extends RecyclerView.Adapter<AndroidDataAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> arrayList;
    private Context mcontext;

    public AndroidDataAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.arrayList = android;
        this.mcontext = context;
    }

    @Override
    public void onBindViewHolder(AndroidDataAdapter.ViewHolder holder, int i) {

        holder.textView.setText(arrayList.get(i).getrecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(i).getrecyclerViewImage());
    }

    @Override
    public AndroidDataAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {

        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.row_layout, vGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }

}
