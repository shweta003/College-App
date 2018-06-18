package helper;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ACER on 02/06/2016.
 */
public class DownloadFiles extends AsyncTask<String, Void, Void> {



    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Void doInBackground(String... strings) {
        String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
        String fileName = strings[1];
        String local_path=strings[2];

        // -> maven.pdf
        File destination = new File(local_path);

        if (!destination.exists())
            destination.mkdirs();


        File file = new File(destination, fileName);

        FileOutputStream fo;



        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileDownloader.downloadFile(fileUrl, file);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
