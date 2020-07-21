package pnj.remedial.alia_ismayanti;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseMahasiswa extends SQLiteOpenHelper {

    public DatabaseMahasiswa(Context context){
        super(context, "db_alumni", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_alumni(nim INTEGER PRIMARY KEY, nama TEXT, lahir TEXT, tgllahir TEXT, alamat TEXT, agama TEXT, tlp TEXT, thnmasuk TEXT, thnlulus TEXT, pekerjaan TEXT, jabatan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i!=i1){
            db.execSQL("DROP TABLE tb_alumni");
            db.execSQL("CREATE TABLE tb_alumni(nim INTEGER PRIMARY KEY, nama TEXT, lahir TEXT, tgllahir TEXT, alamat TEXT, agama TEXT, tlp TEXT, thnmasuk TEXT, thnlulus TEXT, pekerjaan TEXT, jabatan TEXT)");
        }
    }


}
