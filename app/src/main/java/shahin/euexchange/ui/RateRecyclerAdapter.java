package shahin.euexchange.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import shahin.euexchange.R;
import shahin.euexchange.models.Rate;

public class RateRecyclerAdapter extends RecyclerView.Adapter<RateRecyclerAdapter.RatesHolder> implements Filterable {

    private List<Rate> rateList;
    private List<Rate> rateListFiltered;
    private CurrencyAdapterListener listener;
    private Context context;

    public RateRecyclerAdapter(Context context, List<Rate> rateList, CurrencyAdapterListener listener) {
        this.context = context;
        this.rateList = rateList;
        this.rateListFiltered = rateList;
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

        Rate rates = rateListFiltered.get(position);

        holder.iv_country.setImageResource(rates.getImageId());
        holder.tv_symbol.setText(rates.getSymbol());
        holder.tv_currency.setText(rates.getCurrency());

        double rate = Double.parseDouble(rates.getRate());
        String roundedRate = String.format(Locale.ENGLISH, "%.2f", rate);
        holder.tv_rate.setText(roundedRate);

    }

    @Override
    public int getItemCount() {
        return rateListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    rateListFiltered = rateList;
                } else {
                    List<Rate> filteredList = new ArrayList<>();
                    for (Rate r : rateList) {
                        if (r.getCountry().toLowerCase().contains(charString.toLowerCase())
                                || r.getSymbol().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(r);
                        }
                    }
                    rateListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = rateListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                rateListFiltered = (ArrayList<Rate>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface CurrencyAdapterListener {
        void onCurrencySelected(Rate rate);

        void onCurrencyLongClickListener(Rate rate);
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

            itemView.setOnClickListener(view -> listener.onCurrencySelected(rateListFiltered.get(getAdapterPosition())));

            itemView.setOnLongClickListener(view -> {
                listener.onCurrencyLongClickListener(rateListFiltered.get(getAdapterPosition()));
                return true;
            });
        }
    }
}
