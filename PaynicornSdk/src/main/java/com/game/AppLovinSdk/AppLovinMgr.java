package com.game.AppLovinSdk;
//
//import android.app.Activity;
//import android.content.Context;
//import android.util.Log;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//
//import com.applovin.mediation.MaxAd;
//import com.applovin.mediation.MaxAdFormat;
//import com.applovin.mediation.MaxAdListener;
//import com.applovin.mediation.MaxAdViewAdListener;
//import com.applovin.mediation.MaxError;
//import com.applovin.mediation.MaxReward;
//import com.applovin.mediation.MaxRewardedAdListener;
//import com.applovin.mediation.ads.MaxAdView;
//import com.applovin.mediation.ads.MaxInterstitialAd;
//import com.applovin.mediation.ads.MaxRewardedAd;
//import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
//import com.applovin.sdk.AppLovinPrivacySettings;
//import com.applovin.sdk.AppLovinSdk;
//import com.applovin.sdk.AppLovinSdkConfiguration;
//import com.applovin.sdk.AppLovinSdkSettings;
//import com.applovin.sdk.AppLovinSdkUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AppLovinMgr {
//
//
//    private String TAG = "AppLovinMgr";
//    private static  AppLovinMgr _instance = null;
//    public static AppLovinMgr getsInstance() {
//        if(AppLovinMgr._instance == null)
//        {
//            AppLovinMgr._instance = new AppLovinMgr();
//        }
//        return AppLovinMgr._instance;
//    }
//    private AppLovinMgr() {
//        Log.e(TAG,"AppLovinMgr");
//    }
//    /***********************************广告sdk***************************************************/
//    public void initAd(Context var1,List<String> id,boolean isDebugger)
//    {
//        if(isDebugger == true)
//        {
//            AppLovinSdk.getInstance( var1 ).showMediationDebugger();
//        }
//
//        AppLovinPrivacySettings.setHasUserConsent( true, var1 );
//        AppLovinSdkSettings settings = new AppLovinSdkSettings( var1 );
//        List<String> adUnitIds = new ArrayList<>();
//        for(int i=0;i<id.size();i++)
//        {
//            adUnitIds.add( id.get(i));
//        }
////
//        settings.setInitializationAdUnitIds( adUnitIds );
//        settings.setVerboseLogging( true );
//
//        AppLovinSdk sdk = AppLovinSdk.getInstance( settings, var1 );
//        sdk.setMediationProvider( "max" );
//        sdk.initializeSdk( new AppLovinSdk.SdkInitializationListener() {
//            @Override
//            public void onSdkInitialized(final AppLovinSdkConfiguration config) {
//                Log.e(TAG,"onSdkInitialized");
//            }
//        } );
//    }
//    public void setHasUserConsent(boolean var0,Context var1)
//    {
//        AppLovinPrivacySettings.setHasUserConsent( var0, var1 );
//    }
//    public void setIsAgeRestrictedUser(boolean var0,Context var1)
//    {
//        AppLovinPrivacySettings.setIsAgeRestrictedUser( var0, var1 );
//    }
//    public void setDoNotSell(boolean var0,Context var1)
//    {
//        AppLovinPrivacySettings.setDoNotSell( var0, var1 );
//    }
//    public void InterstitialAd(Activity var1,String var2)
//    {
//        MaxInterstitialAd interstitialAd = new MaxInterstitialAd( var2, var1 );
//        interstitialAd.setListener( new MaxAdListener(){
//
//            @Override
//            public void onAdLoaded(MaxAd maxAd) {
//                Log.e(TAG,"InterstitialAd onAdLoaded");
//                interstitialAd.showAd();
//            }
//
//            @Override
//            public void onAdDisplayed(MaxAd maxAd) {
//                Log.e(TAG,"onAdDisplayed");
//            }
//
//            @Override
//            public void onAdHidden(MaxAd maxAd) {
//                Log.e(TAG,"InterstitialAd onAdHidden");
//            }
//
//            @Override
//            public void onAdClicked(MaxAd maxAd) {
//                Log.e(TAG,"InterstitialAd onAdClicked");
//            }
//
//            @Override
//            public void onAdLoadFailed(String s, MaxError maxError) {
//                Log.e(TAG,"InterstitialAd onAdLoadFailed "+";code="+maxError.getCode()+";Message="+maxError.getMessage());
//                // Interstitial ad failed to load
//                // AppLovin recommends that you retry with exponentially higher delays up to a maximum delay (in this case 64 seconds)
//                interstitialAd.loadAd();
//            }
//
//            @Override
//            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
//                Log.e(TAG,"InterstitialAd onAdDisplayFailed");
////                interstitialAd.loadAd();
//            }
//        } );
//
//        interstitialAd.loadAd();
//    }
//    public void RewardedAd(Activity var1,String var2 )
//    {
//        MaxRewardedAd rewardedAd = MaxRewardedAd.getInstance( var2, var1 );
//        rewardedAd.setListener( new MaxRewardedAdListener(){
//            // MAX Ad Listener
//            @Override
//            public void onAdLoaded(final MaxAd maxAd)
//            {
//                Log.e(TAG,"RewardedAd onAdLoaded");
//                rewardedAd.showAd();
//            }
//
//            @Override
//            public void onAdLoadFailed(final String adUnitId, final MaxError error)
//            {
//                Log.e(TAG,"RewardedAd onAdLoadFailed");
////                rewardedAd.loadAd();
//            }
//
//            @Override
//            public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error)
//            {
//                Log.e(TAG,"RewardedAd onAdDisplayFailed");
//            }
//
//            @Override
//            public void onAdDisplayed(final MaxAd maxAd) {
//                Log.e(TAG,"RewardedAd onAdDisplayed");
//            }
//
//            @Override
//            public void onAdClicked(final MaxAd maxAd) {
//                Log.e(TAG,"RewardedAd onAdClicked");
//            }
//
//            @Override
//            public void onAdHidden(final MaxAd maxAd)
//            {
//                Log.e(TAG,"RewardedAd onAdHidden");
//                // rewarded ad is hidden. Pre-load the next ad
//            }
//
//            @Override
//            public void onRewardedVideoStarted(final MaxAd maxAd) {
//                Log.e(TAG,"RewardedAd onRewardedVideoStarted");
//            } // deprecated
//
//            @Override
//            public void onRewardedVideoCompleted(final MaxAd maxAd) {
//                Log.e(TAG,"RewardedAd onRewardedVideoCompleted");
//            }
//
//            @Override
//            public void onUserRewarded(final MaxAd maxAd, final MaxReward maxReward)
//            {
//                // Rewarded ad was displayed and user should receive the reward
//                Log.e(TAG,"RewardedAd onUserRewarded");
//            }
//        } );
//
//        rewardedAd.loadAd();
//    }
//    public void BannerAd(Activity var1,String var2)
//    {
//        MaxAdView bannerAd = new MaxAdView( var2, var1 );
//        bannerAd.setListener(new MaxAdViewAdListener(){
//            // MAX Ad Listener
//            @Override
//            public void onAdLoaded(final MaxAd maxAd) {
//                Log.e(TAG,"BannersAd onAdLoaded");
//            }
//
//            @Override
//            public void onAdLoadFailed(final String adUnitId, final MaxError error) {
//                Log.e(TAG,"BannersAd onAdLoadFailed");
//            }
//
//            @Override
//            public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error) {
//                Log.e(TAG,"BannersAd onAdDisplayFailed");
//            }
//
//            @Override
//            public void onAdClicked(final MaxAd maxAd) {
//                Log.e(TAG,"BannersAd onAdClicked");
//                ViewGroup rootView = var1.findViewById( android.R.id.content );
//                rootView.removeView(bannerAd);
//            }
//
//            @Override
//            public void onAdExpanded(final MaxAd maxAd) {
//                Log.e(TAG,"BannersAd onAdExpanded");
//            }
//
//            @Override
//            public void onAdCollapsed(final MaxAd maxAd) {
//                Log.e(TAG,"BannersAd onAdCollapsed");
//            }
//
//            @Override
//            public void onAdDisplayed(final MaxAd maxAd) {
//                /* use this for impression tracking */
//                Log.e(TAG,"BannersAd onAdDisplayed");
//            }
//
//            @Override
//            public void onAdHidden(final MaxAd maxAd) {
//                /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */
//                Log.e(TAG,"BannersAd onAdHidden");
//            }
//
//        });
//        int width = ViewGroup.LayoutParams.MATCH_PARENT;
//        int heightPx = AppLovinSdkUtils.dpToPx( var1, 128 );
//        bannerAd.setLayoutParams( new FrameLayout.LayoutParams( width, heightPx ) );
//        ViewGroup rootView =  var1.findViewById( android.R.id.content );
//        rootView.addView( bannerAd );
//        bannerAd.loadAd();
//    }
//    public MaxAdView  MRecAd(Activity var1,String var2)
//    {
//        MaxAdView mrecAd = new MaxAdView( var2, MaxAdFormat.MREC, var1 );
//        mrecAd.setExtraParameter( "content_url", "VALUE" );
//        mrecAd.setPlacement( "MY_ADVIEW_PLACEMENT" );
//        mrecAd.loadAd();
//        return mrecAd;
//    }
//    public MaxNativeAdLoader  NativeAd(Activity var1,String var2)
//    {
//        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( var2, var1 );
//        nativeAdLoader.setExtraParameter( "content_url", "VALUE" );
//        nativeAdLoader.setPlacement( "MY_NATIVE_PLACEMENT" );
//        return nativeAdLoader;
//    }
//    public void setMuted(boolean var0,Activity var1)
//    {
//        AppLovinSdk sdk = AppLovinSdk.getInstance( var1 );
//        sdk.getSettings().setMuted( var0 );
//    }
//    public void setVerboseLogging(Activity var1)
//    {
//        AppLovinSdk.getInstance( var1 ).getSettings().setVerboseLogging( true );
//    }
//
//}
