package pnj.remedial.alia_ismayanti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class TambahmahasiswaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editnim, editnama, editlahir, tgllahir, alamat, agama, tlp, tahunmasuk,tahunlulus, pekerjaan, jabatan;
    Button buttonsimpan;
    DatePickerDialog.OnDateSetListener setListener;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmahasiswa);

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
        buttonsimpan.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);

        tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TambahmahasiswaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        tgllahir.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (editnim.getText().toString().length() > 0 && editnama.getText().toString().length() > 0 && editlahir.getText().toString().length() > 0 && tgllahir.getText().toString().length() > 0 && alamat.getText().toString().length() > 0 && agama.getText().toString().length() > 0 && tlp.getText().toString().length() > 0 && tahunmasuk.getText().toString().length() > 0 && tahunlulus.getText().toString().length() > 0 && pekerjaan.getText().toString().length() > 0 && jabatan.getText().toString().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nim", Integer.parseInt(editnim.getText().toString()));
            contentValues.put("nama", editnama.getText().toString());
            contentValues.put("lahir", editlahir.getText().toString());
            contentValues.put("tgllahir", tgllahir.getText().toString());
            contentValues.put("alamat", alamat.getText().toString());
            contentValues.put("agama", agama.getText().toString());
            contentValues.put("tlp", tlp.getText().toString());
            contentValues.put("thnmasuk", tahunmasuk.getText().toString());
            contentValues.put("thnlulus", tahunlulus.getText().toString());
            contentValues.put("pekerjaan", pekerjaan.getText().toString());
            contentValues.put("jabatan", jabatan.getText().toString());

            database = new DatabaseMahasiswa(this).getWritableDatabase();
            long insert = database.insert("tb_alumni", null, contentValues);
            //database.update("tb_mahasiswa", contentValues, "nim=7 or nama=?", new String[]{"12345","alia"});
            // database.delete("tb_mahasiswa", "nim=? or nama=?", new String[]{"1234", "Fina"}));
            if (insert != -1) {
                Toast.makeText(this, "Database berhasil disimpan", Toast.LENGTH_SHORT).show();

database.close();
finish();
        } else {
            Toast.makeText(this, "Database GAGAL disimpan", Toast.LENGTH_SHORT).show();
        }

    }else {
        Toast.makeText(this, "Mohon lengkapi inputan anda", Toast.LENGTH_SHORT).show();
    }
}
}