package com.fei_ke.shamiko;

import android.content.Context;
import android.widget.Toast;

import com.topjohnwu.superuser.io.SuFile;

import java.io.File;
import java.io.IOException;

class Shamiko {
    private static final String FLAG_FILE = "/data/adb/shamiko/whitelist";

    public static void toggleWhitelist(Context context, boolean checked) {
        File flagFile = SuFile.open(FLAG_FILE);
        if (checked) {
            try {
                flagFile.createNewFile();
            } catch (IOException e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        } else {
            flagFile.delete();
        }
    }

    public static boolean isWhitelistModeOn() {
        File flagFile = SuFile.open(FLAG_FILE);
        return flagFile.exists();
    }
}
