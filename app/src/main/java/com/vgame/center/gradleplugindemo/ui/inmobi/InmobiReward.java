package com.vgame.center.gradleplugindemo.ui.inmobi;

import android.app.Activity;
import android.content.Context;

import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;

public class InmobiReward {

    private InMobiInterstitial mInterstitialAd;
    private String mUnitId;
    private Context mContext;

    public InmobiReward(Context context, String unitId) {
        mContext = context;
        mUnitId = unitId;
    }

    public void setInterstitialAdEventListener(InterstitialAdEventListener listener) {
        mInterstitialAd = new InMobiInterstitial(mContext, Long.parseLong(mUnitId), listener);
    }

    public void showAd(Activity activity) {
        if (mInterstitialAd != null && mInterstitialAd.isReady()) {
            mInterstitialAd.show();
        }
    }

    public void loadAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.load();
        }
    }
}
