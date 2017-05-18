package music.c19.tapbpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView mainText = (TextView)this.findViewById(R.id.mainText);
        mainText.setText("BPM - 140");

        final Button tapButton = (Button)this.findViewById(R.id.tapButton);
        tapButton.setText("Tap Here");

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("BPM - 190");

            }
        });
    }
}
