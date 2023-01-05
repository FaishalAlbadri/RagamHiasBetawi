package com.faishalbadri.ragamhiasbetawi.fragment

import android.os.Bundle
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

class ProfileFragment(mainActivity: MainActivity) : Fragment() {
    @BindView(R.id.btn_back)
    lateinit var btnBack: ImageView

    val mainActivity = mainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        ButterKnife.bind(this, view)
        btnBack.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)

        return view
    }

    @OnClick(R.id.btn_back)
    fun onBtnBackClicked() {
        mainActivity.homeFragment()
    }
}