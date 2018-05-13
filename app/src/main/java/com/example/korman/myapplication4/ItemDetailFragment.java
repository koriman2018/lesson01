package com.example.korman.myapplication4;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Окно детальной информации
 */
public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private ItemListActivity.ContactItem mItem;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // ввбираем данные по id
            mItem = ItemListActivity.CONTACTS_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                // задаем имя заголовка для расширенных данных
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // показываем расширенные данные
        if (mItem != null) {
            StringBuffer allContent = new StringBuffer();
            allContent.append("e-mail: ").append(mItem.email).append("\nphone: ").append(mItem.phone);
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(allContent);
        }
        return rootView;
    }
}
