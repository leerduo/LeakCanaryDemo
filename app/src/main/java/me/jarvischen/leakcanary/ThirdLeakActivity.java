package me.jarvischen.leakcanary;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

public class ThirdLeakActivity extends AppCompatActivity {

    private Button btn_test03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btn_test03 = (Button) findViewById(R.id.test3);
        btn_test03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViewGroup();
            }
        });
    }

    private void check(ViewGroup ll) {
        RefWatcher watcher = MyApp.getRefWatcher(this);
        watcher.watch(ll);
    }

    private void removeViewGroup() {
        ViewGroup ll1 = (ViewGroup) findViewById(R.id.ll1);
        ViewGroup ll2 = (ViewGroup) findViewById(R.id.ll2);
        ll2.setLayoutTransition(new LayoutTransition());

        TextView someView = new TextView(this);
        someView.setText("heiehei");
        ll2.addView(someView);

        ll1.removeView(ll2); // (3)

        check(ll2);

    }
}
