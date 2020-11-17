package com.vgame.center.gradleplugindemo.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.vgame.center.gradleplugindemo.R;
import com.vgame.center.gradleplugindemo.ui.coordinator.TestAppbarNoChildAct;
import com.vgame.center.gradleplugindemo.ui.slot.SlotActivity;
import com.vgame.center.gradleplugindemo.ui.touch.TouchActivity;
import com.vgame.center.gradleplugindemo.ui.web.WebActivity;

public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private NotificationsViewModel notificationsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.open_slot_btn).setOnClickListener(this);
        view.findViewById(R.id.open_coordinator_btn).setOnClickListener(this);
        view.findViewById(R.id.open_test_touch_btn).setOnClickListener(this);
        view.findViewById(R.id.open_test_web_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.open_slot_btn) {
            SlotActivity.launch(getActivity());
        } else if (v.getId() == R.id.open_coordinator_btn) {
            TestAppbarNoChildAct.launch(getActivity());
        } else if (v.getId() == R.id.open_test_touch_btn) {
            TouchActivity.start(getActivity());
        } else if (v.getId() == R.id.open_test_web_btn) {
            WebActivity.start(getActivity());
        }
    }
}