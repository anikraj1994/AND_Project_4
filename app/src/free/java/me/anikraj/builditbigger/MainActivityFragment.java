package me.anikraj.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import me.anikraj.androidjokelibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {
    InterstitialAd mInterstitialAd;
    ProgressDialog pd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                getjoke();
            }
        });

        requestNewInterstitial();

        pd=new ProgressDialog(getContext());
        pd.setMessage("Loading");

        Button telljoke=(Button)root.findViewById(R.id.telljoke);

        telljoke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    getjoke();
                }
            }
        });

        return root;
    }
    void getjoke(){
        pd.show();
        new EndpointsAsyncTask().execute(this);
    }

    @Override
    public void onReceived(String joke) {
        pd.dismiss();
        startActivity(new Intent(getContext(),JokeActivity.class).putExtra(JokeActivity.JOKEEXTRA, joke));
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
