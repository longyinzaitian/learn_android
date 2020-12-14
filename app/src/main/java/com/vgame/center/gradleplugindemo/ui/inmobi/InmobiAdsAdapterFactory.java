package com.vgame.center.gradleplugindemo.ui.inmobi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.SdkInitializationListener;

import org.json.JSONException;
import org.json.JSONObject;

public class InmobiAdsAdapterFactory {

    public static final String PLATFORM_NAME = "inmobi_sdk";
    private static final String TAG = "InmobiAdsAdapterFactory";

    @SuppressLint("Range")
    public InmobiAdsAdapterFactory(Context context) {
        JSONObject consentObject = new JSONObject();
        try {
            // Provide correct consent value to sdk which is obtained by User
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true);
            // Provide 0 if GDPR is not applicable and 1 if applicable
            consentObject.put("gdpr", "0");
            // Provide user consent in IAB format
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        InMobiSdk.init(context, "160000000000000000", consentObject, new SdkInitializationListener() {
            @Override
            public void onInitializationComplete(@Nullable Error error) {
                if (error != null) {
                    String err = error.getMessage();
                    Log.i(TAG, "on Initial complete. error: " + err);
                } else {
                    Log.i(TAG, "on Initial complete. Suc.");
                }
            }
        });
    }

    public InmobiRewardAdapter createAdAdapter() {
        return new InmobiRewardAdapter();
    }
}
