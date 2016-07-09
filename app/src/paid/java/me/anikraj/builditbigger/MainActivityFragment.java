package me.anikraj.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import me.anikraj.androidjokelibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {

    ProgressDialog pd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        pd=new ProgressDialog(getContext());
        pd.setMessage("Loading");

        Button telljoke=(Button)root.findViewById(R.id.telljoke);

        telljoke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getjoke();
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
}
