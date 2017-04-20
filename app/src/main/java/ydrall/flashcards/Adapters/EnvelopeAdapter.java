package ydrall.flashcards.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import ydrall.flashcards.R;
import ydrall.flashcards.model.Envelope;

public class EnvelopeAdapter extends RecyclerView.Adapter<EnvelopeAdapter.ViewHolder>{

    private ArrayList<Envelope> envelopeArrayList;
    private Context mContext;

    public EnvelopeAdapter(Context context) {
        this.mContext = context;
        envelopeArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            envelopeArrayList.add(Envelope.create(1,"", new Date(),new Date(),3, new Color()));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_coverflow,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.title.setText(envelopeArrayList.get(position).title());
    }

    @Override
    public int getItemCount() {
        return envelopeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.title_item_envelopelist);
        }
    }
}
