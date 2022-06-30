package com.example.homework9comp181;


import static com.example.homework9comp181.MainActivity.priceInput;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class itemListAdapter extends RecyclerView.Adapter<itemListVH>  {

List<String> items;


    public itemListAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public itemListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_format, parent, false);
        return new itemListVH(view).linkAdapter(this) ;
    }

    @Override
    public  void onBindViewHolder(@NonNull itemListVH holder, int position) {
        holder.itemName.setText(items.get(position).trim());


        holder.priceName.setText("$" + MainActivity.prices.get(position).toString());
        Log.d("Position:",MainActivity.prices.get(position).toString() + "");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
class itemListVH extends RecyclerView.ViewHolder{
    private itemListAdapter adapter;


    TextView itemName;
    TextView priceName;
    Button delete_button;



    public itemListVH(@NonNull View itemView) {
        super(itemView);


        priceName = itemView.findViewById(R.id.priceName);
        itemName = itemView.findViewById(R.id.itemName);

        delete_button = itemView.findViewById(R.id.delete_button);

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                adapter.items.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());


                MainActivity.prices.remove(getLayoutPosition());

                Log.d("Position:",getLayoutPosition() + "");



            }
        });



    }

    public itemListVH linkAdapter(itemListAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}

