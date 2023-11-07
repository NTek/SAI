package com.aefyr.sai.analytics;

import android.content.Context;

import com.aefyr.sai.utils.PreferencesHelper;

public class DefaultAnalyticsProvider implements AnalyticsProvider {

    private static DefaultAnalyticsProvider sInstance;
    private Context mContext;
    private PreferencesHelper mPrefsHelper;

    public static synchronized DefaultAnalyticsProvider getInstance(Context context) {
        return sInstance != null ? sInstance : new DefaultAnalyticsProvider(context);
    }

    private DefaultAnalyticsProvider(Context context) {
        mContext = context.getApplicationContext();
        mPrefsHelper = PreferencesHelper.getInstance(mContext);
        sInstance = this;
    }

    @Override
    public boolean supportsDataCollection() {
        return true;
    }

    @Override
    public boolean isDataCollectionEnabled() {
        return mPrefsHelper.isAnalyticsEnabled();
    }

    @Override
    public void setDataCollectionEnabled(boolean enabled) {
        /* Disabled FBC
        FirebaseApp.getInstance().setDataCollectionDefaultEnabled(enabled);
        FirebaseAnalytics.getInstance(mContext).setAnalyticsCollectionEnabled(enabled);

        FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();
        crashlytics.deleteUnsentReports();
        crashlytics.setCrashlyticsCollectionEnabled(enabled);
        crashlytics.deleteUnsentReports();

        mPrefsHelper.setAnalyticsEnabled(enabled);
         */
    }
}
