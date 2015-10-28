package supportapp.jp.ac.nagaoka_ct.ec25110y.ec25;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{
    private List<CardInfo> mItems;
    public String[][][] subjects = {{{"計算機システム","1,2限"},{"確率","3,4限"},{"保健体育","5,6限"},{"英語A","7,8限"}}
            ,{{"電磁気学","1,2限"},{"オーラル","3限"},{"微分積分","5,6限"},{"物理","7,8限"}}
            ,{{"機械力学","1,2限"},{"電気回路","3限"},{"実験","5,6,7,8限"}}
            ,{{"メカトロニクス","1,2限"},{"工業数学","3,4限"},{"論理回路","5,6限"},{"特別活動","7限"}}
            ,{{"英語B","1,2限"},{"電子回路","3,4限"},{"国語","5,6限"},{"物理演習","7,8限"}}};

    public CardAdapter() {
        super();
        Calendar calendar = Calendar.getInstance();
        //Debug
//        calendar.add(Calendar.DAY_OF_MONTH, 7);

        int am_pm = calendar.get(Calendar.AM_PM);
        int week;
        int i,j;
        if (am_pm == 1){
            //PM
            week = calendar.get(Calendar.DAY_OF_WEEK)-1;  //明日の曜日
        }else{
            //AM
            week = calendar.get(Calendar.DAY_OF_WEEK)-2;    //今日の曜日
        }

        if (!(week>=0 && week<=4)) week=0;

//        i=0;
//        i = subjects[i].length;
//        Log.d("dev",Integer.toString(week));
//        Log.d("dev",Integer.toString(i));
//        Log.d("dev", subjects[0][0][1]);

        mItems = new ArrayList<CardInfo>();

        for (i = 0; i < subjects[week].length; i++){
            j = 0;

            CardInfo cardInfo = new CardInfo();
            cardInfo.setSjTitle(subjects[week][i][j]);
            j++;
            cardInfo.setTime(subjects[week][i][j]);
            cardInfo.setOther("課題予定:未実装");
            mItems.add(cardInfo);
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(CardViewHolder contactViewHolder, int i) {
        CardInfo ci = mItems.get(i);
        contactViewHolder.vTitle.setText(ci.getSjTitle());
        contactViewHolder.vTime.setText(ci.getTime());
        contactViewHolder.vOther.setText(ci.getOther());
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);

        return new CardViewHolder(itemView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView vTitle;
        protected TextView vTime;
        protected TextView vOther;

        public CardViewHolder(View v) {
            super(v);
            vTitle =  (TextView) v.findViewById(R.id.cTitle);
            vTime = (TextView)  v.findViewById(R.id.cTime);
            vOther = (TextView)  v.findViewById(R.id.cOther);
        }
    }
}
