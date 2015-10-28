package supportapp.jp.ac.nagaoka_ct.ec25110y.ec25;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    public static CardFragment newInstance(int sectionNumber) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_card, container, false);

        String viewDay = getViewDay();

        TextView cDay = (TextView)v.findViewById(R.id.cardDay);
        cDay.setText(viewDay);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.cardList);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter();
        mRecyclerView.setAdapter(mAdapter);


        // Inflate the layout for this fragment
        return v;
    }

    public String getViewDay(){
        String s;
        String[] week_name = {"日", "月", "火", "水",
                "木", "金", "土"};
        int week,am_pm;
        int flag=0;

        Calendar calendar = Calendar.getInstance();

        //Debug
//        calendar.add(Calendar.DAY_OF_MONTH, 2);

        am_pm = calendar.get(Calendar.AM_PM);
        if (am_pm == 1){
            //PM
            calendar.add(Calendar.DAY_OF_MONTH, 1);  //明日に変更
            flag = 1;
        }

        week = calendar.get(Calendar.DAY_OF_WEEK);

        //もし土日なら
        if (!(week>=2 && week<=6)){
            //月曜日に設定
            if (week==1){
                //日曜日=>月曜日
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                flag = 2;
            }else{
                //土曜日=>月曜日
                calendar.add(Calendar.DAY_OF_MONTH, 2);
                flag = 2;
            }

        }

        int month = calendar.get(Calendar.MONTH) +1;
        int day = calendar.get(Calendar.DATE);
        week = calendar.get(Calendar.DAY_OF_WEEK) -1;

        if (flag == 0){
            s = "今日 " + month + "月" + day + "日" + "（" + week_name[week] + "）";
        }else if (flag == 1){
            s = "明日 " + month + "月" + day + "日" + "（" + week_name[week] + "）";
        }else{
            s = "月曜日 " + month + "月" + day + "日" + "（" + week_name[week] + "）";
        }

        return s;
    }


}
