package com.da08.animation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;


public class SunsetFragment extends Fragment {

    public SunsetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sunset, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.sea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hae = view.findViewById(R.id.sun);
                View sea = view.findViewById(R.id.sea);
                View sky = view.findViewById(R.id.sky);
                int skyColor = v.getContext().getResources().getColor(R.color.blue_sky);
                int sunsetColor = v.getContext().getResources().getColor(R.color.sunset_sky);
                int nigjtColor = v.getContext().getResources().getColor(R.color.night_sky);

                ObjectAnimator animator = ObjectAnimator
                        .ofFloat(hae,"y",hae.getTop(),sea.getTop())
                        .setDuration(6000);
//                animator.start();
                ObjectAnimator colorAnimator = ObjectAnimator
                        .ofInt(sky,"backgroundColor",skyColor,sunsetColor)
                        .setDuration(6000);

                colorAnimator.setEvaluator(new ArgbEvaluator());
                colorAnimator.setInterpolator(new AccelerateInterpolator()); // 가속
//                colorAnimator.start();
                ObjectAnimator nightColorAnimator = ObjectAnimator
                        .ofInt(sky,"backgroundColor",sunsetColor,nigjtColor)
                        .setDuration(3000);
                nightColorAnimator.setEvaluator(new ArgbEvaluator());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator).with(colorAnimator).before(nightColorAnimator);
                animatorSet.start();
            }
        });
    }
}
