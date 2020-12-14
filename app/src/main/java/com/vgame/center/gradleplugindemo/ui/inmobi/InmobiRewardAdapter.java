package com.vgame.center.gradleplugindemo.ui.inmobi;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;

import java.util.Map;

public class InmobiRewardAdapter{
    private static final boolean isPrintLog = true;
    private static final String TAG = "InmobiRewardAdapter";
    private boolean isCompleteAd = false;
    private InmobiReward inMobReward;

    public void requestAd(Context context) {
        inMobReward = getInMobiReward(context);

        inMobReward.setInterstitialAdEventListener(new InterstitialAdEventListener() {

            @Override
            public void onAdDisplayed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo adMetaInfo) {
                isCompleteAd = false;
                if (isPrintLog) {
                    Log.i(TAG, "onAdDisplayed-> creative id:" + adMetaInfo.getCreativeID());
                }
            }

            @Override
            public void onAdDismissed(@NonNull InMobiInterstitial inMobiInterstitial) {

                if (isPrintLog) {
                    Log.i(TAG, "onAdDismissed->");
                }
            }

            @Override
            public void onAdLoadSucceeded(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo adMetaInfo) {

                if (isPrintLog) {
                    Log.i(TAG, "onAdLoadSucceeded->");
                }
            }

            @Override
            public void onAdLoadFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                if (isPrintLog) {
                    Log.i(TAG, "onAdLoadFailed-> code:" + inMobiAdRequestStatus.getStatusCode()
                            + ", msg:" + inMobiAdRequestStatus.getMessage());
                }
            }

            @Override
            public void onAdClicked(@NonNull InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                if (isPrintLog) {
                    Log.i(TAG, "onAdClicked->");
                    for (Object key: map.keySet()) {
                        Object value = map.get(key);
                        Log.i(TAG, "onAdClicked " + value + " " + key);
                    }
                }
            }

            @Override
            public void onAdFetchFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                if (isPrintLog) {
                    Log.i(TAG, "onAdFetchFailed->code:" + inMobiAdRequestStatus.getStatusCode()
                            + ", msg:" + inMobiAdRequestStatus.getMessage());
                }
            }

            @Override
            public void onRequestPayloadCreationFailed(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                if (isPrintLog) {
                    Log.i(TAG, "onRequestPayloadCreationFailed->code:" + inMobiAdRequestStatus.getStatusCode()
                            + ", msg:" + inMobiAdRequestStatus.getMessage());
                }
            }

            @Override
            public void onAdWillDisplay(@NonNull InMobiInterstitial inMobiInterstitial) {
                if (isPrintLog) {
                    Log.i(TAG, "onAdWillDisplay->");
                }
            }

            @Override
            public void onAdDisplayFailed(@NonNull InMobiInterstitial inMobiInterstitial) {
                if (isPrintLog) {
                    Log.i(TAG, "onAdDisplayFailed->");
                }
            }

            @Override
            public void onUserLeftApplication(@NonNull InMobiInterstitial inMobiInterstitial) {
                if (isPrintLog) {
                    Log.i(TAG, "onUserLeftApplication->");
                }
            }

            @Override
            public void onRewardsUnlocked(@NonNull InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                if (isPrintLog) {
                    Log.i(TAG, "onRewardsUnlocked->");
                    for (Object key: map.keySet()) {
                        Object value = map.get(key);
                        Log.i(TAG, "Unlocked " + value + " " + key);
                    }
                }
                isCompleteAd = true;
            }
        });

        inMobReward.loadAd();
    }

    public void showAd(Activity context) {
        if (inMobReward != null) {
            inMobReward.showAd(context);
        }
    }

    private InmobiReward getInMobiReward(Context context) {
        return new InmobiReward(context, "90000000000000");
    }

}
