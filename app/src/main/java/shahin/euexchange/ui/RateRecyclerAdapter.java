package shahin.euexchange.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import shahin.euexchange.R;
import shahin.euexchange.models.Rates;

//Created by Mohamed Shahin on 07/08/2017.

public class RateRecyclerAdapter extends RecyclerView.Adapter<RateRecyclerAdapter.RatesHolder> implements Filterable{

    private List<Rates> ratesList;
    private List<Rates> ratesListFiltered;
    private CurrencyAdapterListener listener;
    private Context context;

    public RateRecyclerAdapter(Context context, List<Rates> ratesList, CurrencyAdapterListener listener) {
        this.context = context;
        this.ratesList = ratesList;
        this.ratesListFiltered = ratesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RatesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rate_item_recycler_view, parent, false);
        return new RatesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesHolder holder, int position) {

        Rates rates = ratesListFiltered.get(position);

        holder.iv_country.setImageResource(rates.getImageId());
        holder.tv_symbol.setText(rates.getSymbol());
        holder.tv_currency.setText(rates.getCurrency());
        holder.tv_rate.setText(rates.getRate());

    }

    @Override
    public int getItemCount() {
        return ratesListFiltered.size();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 listener.onCurrencySelected(ratesListFiltered.get(getAdapterPosition()));
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onCurrencyLongClickListener(ratesListFiltered.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    ratesListFiltered = ratesList;
                } else {
                    List<Rates> filteredList = new ArrayList<>();
                    for(Rates r: ratesList){
                        if (r.getCurrency().toLowerCase().contains(charString.toLowerCase())|| r.getCountry().toLowerCase().contains(charSequence)) {
                            filteredList.add(r);
                        }
                    }
                    ratesListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = ratesListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                ratesListFiltered = (ArrayList<Rates>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface CurrencyAdapterListener{
        void onCurrencySelected(Rates rates);
        void onCurrencyLongClickListener(Rates rates);
    }
}
