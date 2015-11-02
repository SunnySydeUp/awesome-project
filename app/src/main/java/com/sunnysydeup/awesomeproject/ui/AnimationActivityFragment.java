package com.sunnysydeup.awesomeproject.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.sunnysydeup.awesomeproject.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AnimationActivityFragment extends Fragment implements View.OnClickListener {

    private Button fade;

    public AnimationActivityFragment() {
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fade) {
            ObjectAnimator.ofFloat(v, View.ALPHA, 1, 0.2f).start();
        } else if (v.getId() == R.id.rotation) {
            ObjectAnimator.ofFloat(v, View.ROTATION, 0, 90f).start();
        } else if (v.getId() == R.id.rotation_x) {
            ObjectAnimator.ofFloat(v, View.ROTATION_X, 0, 60f).start();
        } else if (v.getId() == R.id.scale_x) {
            ObjectAnimator.ofFloat(v, View.SCALE_X, 2f).start();
        } else if (v.getId() == R.id.translation_x) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(v, View.TRANSLATION_X, 180f).setDuration(1200);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
        } else if (v.getId() == R.id.y) {
            ObjectAnimator.ofFloat(v, View.Y, fade.getY()).start();
        } else if (v.getId() == R.id.animation_set) {
            AnimatorSet set = new AnimatorSet();
            set.playSequentially(
                    ObjectAnimator.ofFloat(v, View.TRANSLATION_X, 180f),
                    ObjectAnimator.ofFloat(v, View.ALPHA, 0.2f),
                    ObjectAnimator.ofFloat(v, View.ALPHA, 1),
                    ObjectAnimator.ofFloat(v, View.TRANSLATION_X, -120)
            );
            set.start();
        } else if (v.getId() == R.id.xml_animator) {
            Animator anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.xml_animator);
            anim.setTarget(v);
            anim.start();
        } else if (v.getId() == R.id.new_animation_method) {
            v.animate().translationXBy(180f).translationY(-80f);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // old way
        fade = (Button) view.findViewById(R.id.fade);
        fade.setOnClickListener(this);
        Button rotation = (Button) view.findViewById(R.id.rotation);
        rotation.setOnClickListener(this);
        Button rotationX = (Button) view.findViewById(R.id.rotation_x);
        rotationX.setOnClickListener(this);
        Button scaleX = (Button) view.findViewById(R.id.scale_x);
        scaleX.setOnClickListener(this);
        Button translationX = (Button) view.findViewById(R.id.translation_x);
        translationX.setOnClickListener(this);
        Button y = (Button) view.findViewById(R.id.y);
        y.setOnClickListener(this);
        Button animationSet = (Button) view.findViewById(R.id.animation_set);
        animationSet.setOnClickListener(this);

        // xml
        Button xmlAnimator = (Button) view.findViewById(R.id.xml_animator);
        xmlAnimator.setOnClickListener(this);

        // simpler way
        Button newAnimationMethod = (Button) view.findViewById(R.id.new_animation_method);
        newAnimationMethod.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animation, container, false);
    }
}
