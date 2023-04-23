package it.jacopogaggiotti.intentalarmclock;

import static android.Manifest.permission.SET_ALARM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String[] permissions = {SET_ALARM};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), SET_ALARM) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(permissions,0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Sveglia impostata dall'applicazione di Jacopo");
                intent.putExtra(AlarmClock.EXTRA_HOUR,18);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,35);

                if(intent.resolveActivity(getPackageManager()) != null) {
                    if(ContextCompat.checkSelfPermission(getApplicationContext(), SET_ALARM) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(intent);
                    } else {
                        requestPermissions(permissions,1);
                    }
                }
            }
        });
    }
}
