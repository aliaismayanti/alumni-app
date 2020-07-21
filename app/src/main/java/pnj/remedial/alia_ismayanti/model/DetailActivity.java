package pnj.remedial.alia_ismayanti.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import pnj.remedial.alia_ismayanti.DatabaseMahasiswa;
import pnj.remedial.alia_ismayanti.R;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "EditDataActivity";
    EditText editnim, editnama, editlahir, tgllahir, alamat, agama, tlp, tahunmasuk,tahunlulus, pekerjaan, jabatan;

    Button buttonsimpan, buttonhapus;
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();


        editnim = findViewById(R.id.editnim);
        editnama = findViewById(R.id.editnama);
        editlahir = findViewById(R.id.editlahir);
        tgllahir = findViewById(R.id.tgllahir);
        alamat = findViewById(R.id.alamat);
        agama = findViewById(R.id.agama);
        tlp = findViewById(R.id.tlp);
        tahunmasuk = findViewById(R.id.tahunmasuk);
        tahunlulus = findViewById(R.id.tahunlulus);
        pekerjaan = findViewById(R.id.pekerjaan);
        jabatan = findViewById(R.id.jabatan);
        buttonsimpan = findViewById(R.id.buttonsimpan);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        DetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        tgllahir.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });



    }
    }

