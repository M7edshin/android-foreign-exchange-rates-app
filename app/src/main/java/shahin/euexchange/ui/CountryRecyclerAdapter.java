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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import shahin.euexchange.R;
import shahin.euexchange.models.Country;

public class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.CountryHolder> implements Filterable {

    private List<Country> countryList;
    private List<Country> countryListFiltered;
    private CurrencyAdapterListener listener;
    private Context context;

    public CountryRecyclerAdapter(Context context, List<Country> countryList, CurrencyAdapterListener listener) {
        this.context = context;
        this.countryList = countryList;
        this.countryListFiltered = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item_recycler_view, parent, false);
        return new CountryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {

        Country country = countryListFiltered.get(position);


        Picasso.get()
                .load(country.getFlagPng())
                .placeholder(R.drawable.ic_not_applicable)
                .error(R.drawable.ic_not_applicable)
                .into(holder.iv_c_flag);

    }

    @Override
    public int getItemCount() {
        return countryListFiltered.size();
    }


    public class CountryHolder extends RecyclerView.ViewHolder {

        private ImageView iv_c_flag;
        private TextView tv_c_name;
        private TextView tv_c_native_name;


        public CountryHolder(View itemView) {
            super(itemView);
            iv_c_flag = itemView.findViewById(R.id.iv_c_flag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCurrencySelected(countryListFiltered.get(getAdapterPosition()));
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onCurrencyLongClickListener(countryListFiltered.get(getAdapterPosition()));
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
                    countryListFiltered = countryList;
                } else {
                    List<Country> filteredList = new ArrayList<>();
                    for(Country c: countryList){
                        if (c.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(c);
                        }
                    }
                    countryListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = countryListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                countryListFiltered = (ArrayList<Country>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface CurrencyAdapterListener{
        void onCurrencySelected(Country country);
        void onCurrencyLongClickListener(Country country);
    }


}
