package pnj.remedial.alia_ismayanti.fragmen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.remedial.alia_ismayanti.LoginActivity;
import pnj.remedial.alia_ismayanti.R;

public class Profile extends Fragment {
    EditText edtEmail, edtNama, edtNim, edtKelas;
    Button actionLogout;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtNama = view.findViewById(R.id.edtNama);
        edtNim = view.findViewById(R.id.edtNim);
        edtKelas = view.findViewById(R.id.edtKelas);
        actionLogout = view.findViewById(R.id.actionLogout);

        String email = sharedPreferences.getString("Email", "");
        String nim = sharedPreferences.getString("Nim", "");
        String nama = sharedPreferences.getString("Nama", "");
        String kelas = sharedPreferences.getString("Kelas", "");

        if (email!= null || nim!= null || nama!= null || kelas!= null  ){
            edtEmail.setText(email);
            edtNim.setText(nim);
            edtNama.setText(nama);
            edtKelas.setText(kelas);
        }



        actionLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}