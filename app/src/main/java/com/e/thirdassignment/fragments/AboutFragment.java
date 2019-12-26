package com.e.thirdassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.e.thirdassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }
WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        webView=view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);//enable javascript
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://softwarica.edu.np/about-softwarica/");

        return view;
    }

}
