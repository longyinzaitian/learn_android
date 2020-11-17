package com.vgame.center.gradleplugindemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.vgame.center.gradleplugindemo.R;
import com.vgame.center.gradleplugindemo.adapter.FrmAdapter;
import com.vgame.center.gradleplugindemo.adapter.ListAdapter;
import com.vgame.center.gradleplugindemo.ui.dashboard.DashboardFragment;
import com.vgame.center.gradleplugindemo.ui.notifications.NotificationsFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);

        final String[] titles = new String[]{"111", "222", "333"};
        final Fragment[] fragments = new Fragment[]{new DashboardFragment(), new NotificationsFragment(), new NotificationsFragment()};

        final FrmAdapter frmAdapter = new FrmAdapter(getActivity().getSupportFragmentManager(), fragments);
        viewPager.setAdapter(frmAdapter);
        viewPager.setOffscreenPageLimit(fragments.length);

        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }

        final RecyclerView topList = root.findViewById(R.id.top_recycler_view);
        topList.setLayoutManager(new LinearLayoutManager(getContext()));
        topList.setAdapter(new ListAdapter());
        return root;
    }
}