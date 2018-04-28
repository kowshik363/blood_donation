package com.example.mohidulislam.blooddonator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Member>{
    private Context context;
    private List<Member>members;

    public MemberAdapter(@NonNull Context context,List<Member>members) {
        super(context, R.layout.member_row, members);
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.member_row,parent,false);
        TextView nameTV = convertView.findViewById(R.id.nameLTV);
        TextView cityTV = convertView.findViewById(R.id.cityLTV);
        nameTV.setText(members.get(position).getName());
        String city = members.get(position).getCity()+" / "+members.get(position).getBloodGroup();
        cityTV.setText(city);
        return convertView;
    }
}
