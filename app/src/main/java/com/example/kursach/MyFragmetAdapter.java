package com.example.kursach;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmetAdapter  extends FragmentStateAdapter {
    public MyFragmetAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public MyFragmetAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MyFragmetAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new Calc1Fragment();
        }
        return new Calc2Fragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
