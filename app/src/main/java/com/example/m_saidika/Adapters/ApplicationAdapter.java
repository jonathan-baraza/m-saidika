package com.example.m_saidika.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m_saidika.Models.ApplicationItem;
import com.example.m_saidika.Models.FoodItem;
import com.example.m_saidika.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder>{

    public Context mContext;
    public List<ApplicationItem> allApplicationItems;
    private FirebaseUser fUser;

    public ApplicationAdapter(Context mContext, List<ApplicationItem> allApplicationItems) {
        this.mContext = mContext;
        this.allApplicationItems = allApplicationItems;
        this.fUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.application_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationAdapter.ViewHolder holder, int position) {
        ApplicationItem applicationItem = allApplicationItems.get(position);
        holder.appCompanyName.setText(applicationItem.getCompanyName());
        holder.appServiceType.setText(applicationItem.getServiceType());

        holder.appCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, applicationItem.getCompanyName()+" selected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return allApplicationItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView appCompanyName, appServiceType;
        public CardView appCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            appCompanyName=itemView.findViewById(R.id.appCompanyName);
            appServiceType=itemView.findViewById(R.id.appServiceType);
            appCard=itemView.findViewById(R.id.appCard);
        }
    }
}