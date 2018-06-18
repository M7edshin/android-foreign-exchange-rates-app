package shahin.euexchange.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.R;

public class FavoriteActivity extends AppCompatActivity {

    @BindView(R.id.rv_favorite) RecyclerView rv_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);
    }
}
