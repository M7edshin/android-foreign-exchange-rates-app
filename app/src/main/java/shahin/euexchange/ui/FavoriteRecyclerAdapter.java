package shahin.euexchange.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import shahin.euexchange.R;
import shahin.euexchange.models.Country;


public class FavoriteRecyclerAdapter extends RecyclerView.Adapter<FavoriteRecyclerAdapter.CountryViewHolder> {

    private FavoriteAdapterListener favoriteAdapterListener;

    private List<Country> countryList;
    private Context mContext;

    public FavoriteRecyclerAdapter(Context context, FavoriteAdapterListener listener) {
        mContext = context;
        favoriteAdapterListener = listener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.favorite_country_recycler_item, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {

        Country country = countryList.get(position);

        String countryName = country.getName();
        holder.tv_country_name.setText(countryName);

        Picasso.get()
                .load(country.getFlagPng())
                .placeholder(R.drawable.ic_not_applicable)
                .error(R.drawable.ic_not_applicable)
                .into(holder.iv_country_flag);
    }


    @Override
    public int getItemCount() {
        if (countryList == null) {
            return 0;
        }
        return countryList.size();
    }

    public List<Country> getCountryList(){
        return countryList;
    }


    public void setCountries(List<Country> countries) {
        countryList = countries;
        notifyDataSetChanged();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_country_flag;
        TextView tv_country_name;

        public CountryViewHolder(View itemView) {
            super(itemView);

            iv_country_flag = itemView.findViewById(R.id.iv_fav_country_flag);
            tv_country_name = itemView.findViewById(R.id.tv_fav_country_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favoriteAdapterListener.onCurrencySelected(countryList.get(getAdapterPosition()));
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    favoriteAdapterListener.onCurrencyLongClickListener(countryList.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }

    public interface FavoriteAdapterListener{
        void onCurrencySelected(Country country);
        void onCurrencyLongClickListener(Country country);
    }


}
