package pnj.remedial.alia_ismayanti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pnj.remedial.alia_ismayanti.R;
import pnj.remedial.alia_ismayanti.model.MahasiswaData;

public class AdapterMahasiswa extends ArrayAdapter<MahasiswaData> {

    Context context;
    int resource;

    public AdapterMahasiswa(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //MENYIMPAN VIEW
        Holder holder;

        if (convertView==null) {
            holder = new Holder();

            convertView = LayoutInflater.from(context)
                            .inflate(resource,parent, false);

            holder.avatar = convertView.findViewById(R.id.avatar);
            holder.nim = convertView.findViewById(R.id.nim);
            holder.nama = convertView.findViewById(R.id.nama);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.nim.setText(getItem(position).getNim());
        holder.nama.setText(getItem(position).getNama());

        return convertView;
    }

    class Holder{
        ImageView avatar;
        TextView nim, nama;

    }
}
