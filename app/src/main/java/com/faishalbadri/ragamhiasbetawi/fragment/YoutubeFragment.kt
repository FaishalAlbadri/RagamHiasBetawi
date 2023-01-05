package com.faishalbadri.ragamhiasbetawi.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.faishalbadri.ragamhiasbetawi.MainActivity
import com.faishalbadri.ragamhiasbetawi.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController


class YoutubeFragment(url: String, mainActivity: MainActivity) : DialogFragment() {

    @BindView(R.id.youtube)
    lateinit var youtube: YouTubePlayerView

    @BindView(R.id.btn_close)
    lateinit var btnClose: ImageView

    var url = url
    var mainActivity = mainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_youtube, container, false)
        ButterKnife.bind(this, view)

        lifecycle.addObserver(youtube)

        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val defaultPlayerUiController = DefaultPlayerUiController(youtube, youTubePlayer)
                youtube.setCustomPlayerUi(defaultPlayerUiController.rootView)
                youTubePlayer.loadVideo(url, 0f)
            }
        }

        val options = IFramePlayerOptions.Builder().controls(0).build()
        youtube.initialize(listener, options)

        return view
    }

    override fun onStart() {
        super.onStart()
        var dialog: Dialog = getDialog()!!
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window!!.setLayout(width, height)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        return dialog
    }

    @OnClick(R.id.btn_close)
    fun onBtnCloseClicked() {
        mainActivity.playSound()
        dismiss()
    }

}