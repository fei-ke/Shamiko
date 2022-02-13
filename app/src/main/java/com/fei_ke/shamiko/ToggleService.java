package com.fei_ke.shamiko;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

@TargetApi(Build.VERSION_CODES.N)
public class ToggleService extends TileService {

    @Override
    public void onClick() {
        super.onClick();

        int oldState = getQsTile().getState();
        if (oldState == Tile.STATE_ACTIVE) {
            setState(Tile.STATE_INACTIVE);
        } else {
            setState(Tile.STATE_ACTIVE);
        }

        Shamiko.toggleWhitelist(this, oldState == Tile.STATE_INACTIVE);
    }


    private void setState(int state) {
        Tile tile = getQsTile();
        tile.setState(state);
        tile.updateTile();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        boolean whitelistModeOn = Shamiko.isWhitelistModeOn();
        setState(whitelistModeOn ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
    }
}