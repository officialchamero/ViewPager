package com.example.viewpager.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.viewpager.R;

public class SpeedDialFragment extends Fragment {

  private static final String TAG = "SpeedDial";

  private PageViewModel pageViewModel;

  public SpeedDialFragment() {
    // Required empty public constructor
  }

  /**
   * @return A new instance of fragment SpeedDialFragment.
   */
  public static SpeedDialFragment newInstance() {
    return new SpeedDialFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    pageViewModel.setIndex(TAG);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_main, container, false);
    final TextView textView = root.findViewById(R.id.section_label);
    pageViewModel.getText().observe(this, new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}
