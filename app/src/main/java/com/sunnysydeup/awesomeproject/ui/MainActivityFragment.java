package com.sunnysydeup.awesomeproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunnysydeup.awesomeproject.R;

import java.util.Arrays;
import java.util.List;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    private void navigateToNavigationDrawer() {
        Intent intent = new Intent(getActivity(), NavigationDrawerActivity.class);
        startActivity(intent);
    }

    private void navigateToPermissions() {
        Intent intent = new Intent(getActivity(), PermissionsActivity.class);
        startActivity(intent);
    }

    private void navigateToWidgets() {
        Intent intent = new Intent(getActivity(), WidgetsActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        NavigationAdapter adapter = new NavigationAdapter(navigationMenu());
        recyclerView.setAdapter(adapter);
    }

    private List<String> navigationMenu() {
        return Arrays.asList(getResources().getStringArray(R.array.menu_items));
    }

    public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
        private List<String> items;

        public NavigationAdapter(List<String> items) {
            this.items = items;
        }

        @Override
        public NavigationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.view_navigation_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NavigationAdapter.ViewHolder holder, final int position) {
            String item = items.get(position);
            holder.title.setText(item);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            navigateToPermissions();
                            break;
                        case 1:
                            navigateToNavigationDrawer();
                            break;
                        case 2:
                            navigateToWidgets();
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            View container;
            TextView title;

            public ViewHolder(View itemView) {
                super(itemView);
                container = itemView.findViewById(R.id.container);
                title = (TextView) itemView.findViewById(R.id.title);
            }
        }
    }
}
