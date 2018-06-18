package helper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConnectionClass extends SQLiteOpenHelper{
    public static final String db_name="mcc.sqlite";
    public static final String db_location="/data/data/com.mcc.myapplication/databases/";
    private Context mycontext;
    private SQLiteDatabase mydb;


    public ConnectionClass(Context context) {
        super(context, db_name, null, 1);
        this.mycontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createDB() throws IOException{
        //check db exist or not
        if(checkDB()){

        }else {
            //copy database
            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e){
                throw new Error("Error while copying database.");
            }
        }
    }

    public void openDatabase(){
        String path = db_location + db_name;
        mydb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public boolean checkDB(){
        SQLiteDatabase checkdb = null;
        try{
            String path = db_location + db_name;
            checkdb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){

        }
        if (checkdb != null){
            checkdb.close();
        }
        return checkdb != null ? true : false;
    }

    public void copyDatabase() throws IOException{
        try {
            InputStream is = mycontext.getAssets().open(db_name);
            String filename = db_location + db_name;
            OutputStream os = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer))>0){
                os.write(buffer, 0, length);
            }
            os.flush();
            os.close();
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
