package com.example.astrorehber;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacAdapter.ZodiacViewHolder> {

    private List<Zodiac> zodiacList;

    public ZodiacAdapter(List<Zodiac> zodiacList) {
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zodiac, parent, false);
        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder holder, int position) {
        Zodiac zodiac = zodiacList.get(position);

        holder.tvName.setText(zodiac.getName());
        holder.tvDate.setText(zodiac.getDateRange());

        holder.ivIcon.setImageResource(zodiac.getIconResId());

        holder.itemView.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("ZODIAC_OBJECT", zodiac);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }

    public static class ZodiacViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate;
        ImageView ivIcon;

        public ZodiacViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvZodiacName);
            tvDate = itemView.findViewById(R.id.tvZodiacDate);
            ivIcon = itemView.findViewById(R.id.ivZodiacIcon);
        }
    }
}