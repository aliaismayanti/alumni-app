package pnj.remedial.alia_ismayanti.fragmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pnj.remedial.alia_ismayanti.R;
import pnj.remedial.alia_ismayanti.fragmen.DetailBerita;

public class BeritaFragment extends Fragment {
    ImageView berita1, berita2, berita3, berita4;


    public BeritaFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_berita, container, false);
    berita1 = v.findViewById(R.id.berita1);
    berita1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DetailBerita detailBerita = new DetailBerita();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, detailBerita);
            transaction.commit();
        }
    });
    return  v;

    }

}