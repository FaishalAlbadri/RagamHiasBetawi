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

class HomeFragment(mainActivity: MainActivity) : Fragment() {

    @BindView(R.id.img_nona)
    lateinit var imgNona: ImageView

    @BindView(R.id.img_abang)
    lateinit var imgAbang: ImageView

    @BindView(R.id.btn_kuis)
    lateinit var btnKuis: ImageView

    @BindView(R.id.btn_penerapan)
    lateinit var btnPenerapan: ImageView

    @BindView(R.id.btn_sejarah)
    lateinit var btnSejarah: ImageView

    val mainActivity = mainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this, view)

        imgNona.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        imgAbang.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)

        btnPenerapan.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        btnSejarah.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        btnKuis.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)

        return view
    }

    @OnClick(R.id.btn_penerapan)
    fun onBtnPenerapanClicked() {
        mainActivity.penerapanBatikFragment()
    }

    @OnClick(R.id.btn_sejarah)
    fun onBtnSejarahClicked() {
        mainActivity.sejarahBatikFragment()
    }

    @OnClick(R.id.btn_kuis)
    fun onBtnKuisClicked() {
        mainActivity.kuisFragment()
    }
}