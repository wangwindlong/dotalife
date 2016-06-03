package xyz.abcapp.dotalife.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.abcapp.dotalife.R;
import xyz.abcapp.dotalife.ui.Activity_Main;
import xyz.abcapp.dotalife.ui.MainThemeActivity;
import xyz.abcapp.dotalife.ui.RetrofitActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        root.findViewById(R.id.theme_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainThemeActivity.class));
            }
        });
        root.findViewById(R.id.pedometor_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Activity_Main.class));
            }
        });
        root.findViewById(R.id.rxjava_retrofit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RetrofitActivity.class));
            }
        });
        return root;
    }
}
