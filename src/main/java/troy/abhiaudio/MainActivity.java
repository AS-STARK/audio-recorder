package troy.abhiaudio;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button startbtn;
    Button stopbtn;
    MediaRecorder recorder;
    String path="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbtn = (Button)findViewById(R.id.startButton);
        stopbtn = (Button)findViewById(R.id.stopButton);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/My Recording.mp3";
                recorder.setOutputFile(path);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                try{
                    recorder.prepare();
                    recorder.start();
                    Toast.makeText(MainActivity.this,"Recording Started",Toast.LENGTH_LONG).show();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Recording Stopped",Toast.LENGTH_LONG).show();
                recorder.stop();
            }
        });


    }
}
