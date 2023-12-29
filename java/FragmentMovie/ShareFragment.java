package androidx.constraintlayout.widget.FragmentMovie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.satset.R;
import androidx.fragment.app.Fragment;

public class ShareFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share, container, false);
    }
}
