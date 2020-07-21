package pnj.remedial.alia_ismayanti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import pnj.remedial.alia_ismayanti.R;

import pnj.remedial.alia_ismayanti.adapter.AdapterMahasiswa;
import pnj.remedial.alia_ismayanti.model.DetailActivity;
import pnj.remedial.alia_ismayanti.model.MahasiswaData;

public class ListMahasiswaActivity extends AppCompatActivity {

    ListView listView;
    AdapterMahasiswa adapterMahasiswa;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listView = findViewById(R.id.listView);
        adapterMahasiswa = new AdapterMahasiswa(this, R.layout.item_list_mahasiswa);
        listView.setAdapter(adapterMahasiswa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MahasiswaData data = (MahasiswaData) parent.getAdapter().getItem(position);

                Intent intent = new Intent(ListMahasiswaActivity.this, DetailActivity.class);
                intent.putExtra("nim", data.getNim());
                intent.putExtra("nama", data.getNama());


                startActivity(intent);
            }
        });


        buatData();

    }

    void buatData() {
        ArrayList<MahasiswaData> datas = new ArrayList<>();
        database = new  DatabaseMahasiswa(this).getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from tb_alumni", null);

        if (cursor.moveToFirst()){
            do {
                MahasiswaData data = new  MahasiswaData();
                data.setNim(""+cursor.getInt(0));
                data.setNama(""+cursor.getString(1));

                datas.add(data);
            }while (cursor.moveToNext());
        }

 //       for (int i=0; i<20; i++){
   //         MahasiswaData data = new MahasiswaData();
     //       data.setNama("Alia Ismayanti"+i);
       //     data.setNim("4817070304"+i);
         //   data.setJurusan("TIK");

           // datas.add(data);

     //   }

        adapterMahasiswa.addAll(datas);
        adapterMahasiswa.notifyDataSetChanged();
    }
}
