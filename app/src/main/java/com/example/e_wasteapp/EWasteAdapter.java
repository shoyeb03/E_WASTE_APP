package com.example.e_wasteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EWasteAdapter extends RecyclerView.Adapter<EWasteAdapter.WasteViewAdapter> {

    private java.util.List<EWasteData> List;
    private Context context;
    private String category;

    public EWasteAdapter(java.util.List<EWasteData> list, Context context, String category) {
        this.List = list;
        this.context = context;
        this.category = category;
    }



    @NonNull
    @Override
    public WasteViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.waste_item_layout,parent,false);
        return new WasteViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WasteViewAdapter holder, int position) {

        EWasteData item = List.get(position);
        holder.Name.setText(item.getName());
        holder.Phone.setText(item.getPhone());
        holder.Email.setText(item.getEmail());
        holder.Address.setText(item.getAddress());
        holder.Condition.setText(item.getCondition());
        holder.Brand.setText(item.getBrand());
        holder.Quantity.setText(item.getQuantity());
        holder.Model.setText(item.getModel());

    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class WasteViewAdapter extends RecyclerView.ViewHolder {

        private TextView Name,Phone,Address,Email,Condition,Brand,Quantity,Model;

        public WasteViewAdapter(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.Name1);
            Phone = itemView.findViewById(R.id.Phone1);
            Address = itemView.findViewById(R.id.Address1);
            Email = itemView.findViewById(R.id.Email1);
            Condition = itemView.findViewById(R.id.Condition1);
            Brand = itemView.findViewById(R.id.Brand1);
            Quantity = itemView.findViewById(R.id.Quantity1);
            Model = itemView.findViewById(R.id.Model1);
        }
    }
}
