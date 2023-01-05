package com.faishalbadri.ragamhiasbetawi.fragment.tokoh

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
import com.faishalbadri.ragamhiasbetawi.util.Server

class TokohDetailFragment(mainActivity: MainActivity) : Fragment() {

    @BindView(R.id.btn_next)
    lateinit var btnNext: ImageView

    @BindView(R.id.btn_video)
    lateinit var btnVideo: ImageView

    @BindView(R.id.btn_back)
    lateinit var btnBack: ImageView

    val mainActivity = mainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tokoh_detail, container, false)
        ButterKnife.bind(this, view)

        btnBack.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        btnNext.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)
        btnVideo.animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.shake)

        return view
    }

    @OnClick(R.id.btn_video)
    fun onBtnVideoClicked() {
        mainActivity.youtube(Server.YOUTUBE_SEJARAH_PITUNG)
    }

    @OnClick(R.id.btn_next)
    fun onBtnNextClicked() {
        mainActivity.sejarahBatikFragment()
    }

    @OnClick(R.id.btn_back)
    fun onBtnBackClicked() {
        mainActivity.homeFragment()
    }

}