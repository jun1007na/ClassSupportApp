package supportapp.jp.ac.nagaoka_ct.ec25110y.ec25;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClassicFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    // TODO: Rename and change types and number of parameters
    public static ClassicFragment newInstance(int sectionNumber) {
        ClassicFragment fragment = new ClassicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ClassicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classic, container, false);
    }

}
