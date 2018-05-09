package shahin.euexchange;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Created by Mohamed Shahin on 07/08/2017.

public class CurrencyRatesAdapter extends ArrayAdapter<CurrencyRates> {

    public CurrencyRatesAdapter(Activity context, ArrayList<CurrencyRates> ratesArrayList) {
        super(context, 0, ratesArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CurrencyRates currentRate = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.item_rates_list_view, parent, false);

            viewHolder.imgCountry = convertView.findViewById(R.id.imgCountry);
            viewHolder.tvCurrencySymbol = convertView.findViewById(R.id.tvCurrencySymbol);
            viewHolder.tvCurrencyName = convertView.findViewById(R.id.tvCurrencyName);
            viewHolder.tvCountry = convertView.findViewById(R.id.tvCountry);
            viewHolder.tvRate = convertView.findViewById(R.id.tvRate);

            convertView.setTag(viewHolder);

        }

        viewHolder = (ViewHolder) convertView.getTag();

        if (currentRate != null) {
            viewHolder.imgCountry.setImageResource(currentRate.getCountryResourceId());
        }
        if (currentRate != null) {
            viewHolder.tvCurrencySymbol.setText(currentRate.getCurrencySymbol());
        }
        if (currentRate != null) {
            viewHolder.tvCurrencyName.setText(currentRate.getCurrencyName());
        }
        if (currentRate != null) {
            viewHolder.tvCountry.setText(currentRate.getCountry());
        }
        if (currentRate != null) {
            double rate = currentRate.getRate();
            String result = String.format("%.2f", rate);
            viewHolder.tvRate.setText(result);
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView imgCountry;
        TextView tvCurrencySymbol;
        TextView tvCurrencyName;
        TextView tvCountry;
        TextView tvRate;
    }

}
