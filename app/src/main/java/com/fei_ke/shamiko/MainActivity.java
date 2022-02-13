package com.fei_ke.shamiko;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends Activity {

    private Switch whiteListSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whiteListSwitch = findViewById(R.id.whiteListSwitch);
        whiteListSwitch.setOnCheckedChangeListener((compoundButton, checked) -> {
            Shamiko.toggleWhitelist(this, checked);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean switchOn = Shamiko.isWhitelistModeOn();
        if (switchOn != whiteListSwitch.isChecked()) {
            whiteListSwitch.setChecked(switchOn);
        }
    }
}