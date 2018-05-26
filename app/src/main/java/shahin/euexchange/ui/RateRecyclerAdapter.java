package shahin.euexchange.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import shahin.euexchange.R;
import shahin.euexchange.models.Rates;

//Created by Mohamed Shahin on 07/08/2017.

public class RateRecyclerAdapter extends RecyclerView.Adapter<RateRecyclerAdapter.RatesHolder> {

    private List<Rates> ratesList;

    public RateRecyclerAdapter(List<Rates> rateList) {
        this.ratesList = rateList;
    }

    @NonNull
    @Override
    public RatesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rate_item_recycler_view, parent, false);
        return new RatesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesHolder holder, int position) {

        Rates rates = ratesList.get(position);

        holder.iv_country.setImageResource(rates.getImageId());
        holder.tv_symbol.setText(rates.getSymbol());
        holder.tv_currency.setText(rates.getCurrency());
        holder.tv_rate.setText(rates.getRate());

    }

    @Override
    public int getItemCount() {
        return ratesList.size();
    }


    public class RatesHolder extends RecyclerView.ViewHolder {

        private ImageView iv_country;
        private TextView tv_symbol;
        private TextView tv_currency;
        private TextView tv_rate;

        public RatesHolder(View itemView) {
            super(itemView);
            iv_country = itemView.findViewById(R.id.iv_country);
            tv_symbol = itemView.findViewById(R.id.tv_symbol);
            tv_currency = itemView.findViewById(R.id.tv_currency);
            tv_rate = itemView.findViewById(R.id.tv_rate);
        }
    }

    public void updateList(List<Rates> list){
        ratesList = list;
        notifyDataSetChanged();
    }

}
