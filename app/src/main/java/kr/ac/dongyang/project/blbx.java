package kr.ac.dongyang.project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class blbx extends AppCompatActivity {
    Button btnmain, btn1;
    private VideoView videoView; // 비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; // 재생이나 정지와 같은 미디어 제어 버튼부를 담당
    public final static String videoURL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"; //무조건 https로 시작하세요!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blbx);

        videoView = findViewById(R.id.blackbox); // 비디오 뷰 아이디 연결
        mediaController = new MediaController(this);
        //Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        //videoView.setVideoURI(uri); // 비디오 뷰의 주소를 설정
        //videoView.requestFocus();
        //videoView.start(); // 비디오 실행 !

        //mainactivity로 이동
        btnmain = findViewById(R.id.btnmain);
        btnmain.setOnClickListener((v) -> {
            //인텐트 선언 -> 현재 액티비티, 넘어갈 액티비티
            Intent intent6 = new Intent(this, MainActivity.class);
            startActivity(intent6);
            finish();
        });
        //버튼 기능 추가 : 누르면 URL을 URI로 바꾸고 재생
        btn1 = findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVideoURI(Uri.parse(videoURL));
                videoView.requestFocus();
                videoView.start();
            }
        });
        //Error 메세지 표시
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                String message;

                switch (what) {
                    case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                        message = "MEDIA_ERROR_UNKNOWN";
                        break;
                    case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                        message = "MEDIA_ERROR_SERVER_DIED";
                        break;
                    default:
                        message = "No What";
                }
                switch (extra) {
                    case MediaPlayer.MEDIA_ERROR_IO:
                        message += ", MEDIA_ERROR_IO";
                        break;
                    case MediaPlayer.MEDIA_ERROR_MALFORMED:
                        message += ", MEDIA_ERROR_MALFORMED";
                        break;
                    case MediaPlayer.MEDIA_ERROR_UNSUPPORTED:
                        message += ", MEDIA_ERROR_UNSUPPORTED";
                        break;
                    default:
                        message += ", No extra";
                }
                Log.e("error Tag : ", message);
                return true;
            }
        });
    }
}

