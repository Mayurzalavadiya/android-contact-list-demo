package com.example.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ContactModel> contactsModalArrayList;

    public ContactAdapter(Context context, ArrayList<ContactModel> contactsModalArrayList) {
        this.context = context;
        this.contactsModalArrayList = contactsModalArrayList;
    }

    public void filterList(ArrayList<ContactModel> filterlist) {
        contactsModalArrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        ContactModel modal = contactsModalArrayList.get(position);
        holder.contactTV.setText(modal.getUserName());
        holder.contacnumber.setText(modal.getContactNumber());
        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        int color = generator.getRandomColor();

        TextDrawable drawable2 = TextDrawable.builder().beginConfig()
                .width(100)
                .height(100)
                .endConfig()
                .buildRound(modal.getUserName().substring(0, 1), color);
        holder.contactIV.setImageDrawable(drawable2);
    }

    @Override
    public int getItemCount() {
        return contactsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView contactIV;
        private TextView contactTV;
        private TextView contacnumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactIV = itemView.findViewById(R.id.idIVContact);
            contactTV = itemView.findViewById(R.id.idTVContactName);
            contacnumber = itemView.findViewById(R.id.idTVContacnumber);
        }
    }

}
