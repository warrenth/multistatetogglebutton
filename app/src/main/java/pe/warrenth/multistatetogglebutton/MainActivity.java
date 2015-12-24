package pe.warrenth.multistatetogglebutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import pe.warrenth.multitoggle.inter.OnItemChangedListener;
import pe.warrenth.multitoggle.widget.MultiToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view insert, default position,
        MultiToggleButton mtb = (MultiToggleButton) findViewById(R.id.multitogglebutton);
        mtb.setItemChangedListener(new OnItemChangedListener() {
            @Override
            public void onItemChanged(View v, int position) {
                Log.d("warrenth", "position : " + position);
            }
        });
    }
}
