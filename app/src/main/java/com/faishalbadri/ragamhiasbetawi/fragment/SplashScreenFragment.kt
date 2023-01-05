package com.faishalbadri.ragamhiasbetawi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.faishalbadri.ragamhiasbetawi.MainActivity
import com.faishalbadri.ragamhiasbetawi.R


class SplashScreenFragment(mainActivity: MainActivity) : Fragment() {

    @BindView(R.id.img_ondel)
    lateinit var imgOndel: ImageView

    @BindView(R.id.btn_next)
    lateinit var btnNext: ImageView

    val mainActivity = mainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)
        ButterKnife.bind(this, view)

        imgOndel.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        btnNext.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)

        return view
    }

    @OnClick(R.id.btn_next)
    fun onBtnNextClicked() {
        mainActivity.homeFragment()
    }
}