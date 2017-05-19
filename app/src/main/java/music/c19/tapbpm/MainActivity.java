package music.c19.tapbpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Long> timeStamps;
    ArrayList<Long> bpms;
    TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeStamps = new LinkedList<>();

        mainText = (TextView)this.findViewById(R.id.mainText);
        mainText.setText("BPM - " );

        Button tapButton = (Button)this.findViewById(R.id.tapButton);
        tapButton.setText("Tap Here");

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick();
            }
        });
    }

    private void buttonClick()
    {

        bpms = new ArrayList<>();
        long unixTime = System.currentTimeMillis();
        double sum = 0;
        double average = 0;
        Log.d("tapButton Clicked","Current time: " + unixTime);
        timeStamps.add(unixTime);
        if(timeStamps.size()>=2 ) //calculate the BPM
        {
            for(int i = 0; i<timeStamps.size()-1;i++)
            {
                double difference = timeStamps.get(i+1)-timeStamps.get(i);

                sum += 60/(difference/1000);


            }
            average = sum/timeStamps.size()-1;
            mainText.setText("BPM - " + average);
        }
    }
}
