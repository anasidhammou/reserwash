package com.example.reservecarwash_mobile_android.view.AutoClean.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservecarwash_mobile_android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private List<Calendar> dates;
    private Context context;

    public CalendarAdapter(Context context, List<Calendar> dates) {
        this.context = context;
        this.dates = dates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.calendar_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Calendar calendar = dates.get(position);

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.getDefault());

        holder.tvDayOfWeek.setText(dayFormat.format(calendar.getTime()));
        holder.tvDay.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDayOfWeek, tvDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDayOfWeek = itemView.findViewById(R.id.tvDayOfWeek);
            tvDay = itemView.findViewById(R.id.tvDay);
        }
    }
}
