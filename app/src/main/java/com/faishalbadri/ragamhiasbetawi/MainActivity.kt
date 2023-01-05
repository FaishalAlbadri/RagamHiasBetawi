package com.faishalbadri.ragamhiasbetawi

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.faishalbadri.ragamhiasbetawi.base.BaseActivity
import com.faishalbadri.ragamhiasbetawi.fragment.*
import com.faishalbadri.ragamhiasbetawi.fragment.batik.BatikDetailFragment
import com.faishalbadri.ragamhiasbetawi.fragment.batik.BatikFragment
import com.faishalbadri.ragamhiasbetawi.fragment.batik.PenerapanBatikDetailFragment
import com.faishalbadri.ragamhiasbetawi.fragment.batik.PenerapanBatikFragment
import com.faishalbadri.ragamhiasbetawi.fragment.rumah.RumahDetailFragment
import com.faishalbadri.ragamhiasbetawi.fragment.rumah.RumahFragment
import com.faishalbadri.ragamhiasbetawi.fragment.tokoh.TokohDetailFragment
import com.faishalbadri.ragamhiasbetawi.fragment.tokoh.TokohFragment

class MainActivity : BaseActivity() {

    internal lateinit var player: MediaPlayer
    var atHome = false
    var atSplashScreen = true
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMusic()
        showFragment(SplashScreenFragment(this))
        fragmentManager = supportFragmentManager
    }

    private fun startMusic() {
        player = MediaPlayer.create(this@MainActivity, R.raw.bg_music)
        player.isLooping = true
        player.setVolume(100f, 100f)
    }

    fun youtube(url: String) {
        YoutubeFragment(url, this).show(fragmentManager, "")
        player.pause()
    }

    fun playSound(){
        player.start()
    }

    fun homeFragment() {
        showFragment(HomeFragment(this))
        atSplashScreen = false
        atHome = true
    }

    fun profileFragment() {
        showFragment(ProfileFragment(this))
        atSplashScreen = false
        atHome = true
    }

    fun kuisFragment() {
        showFragment(KuisFragment(this))
        atHome = false
    }

    fun sejarahTokohFragment() {
        showFragment(TokohFragment(this))
        atHome = false
    }

    fun sejarahTokohDetailFragment() {
        showFragment(TokohDetailFragment(this))
        atHome = false
    }

    fun sejarahBatikFragment() {
        showFragment(BatikFragment(this))
        atHome = false
    }

    fun sejarahBatikDetailFragment() {
        showFragment(BatikDetailFragment(this))
        atHome = false
    }

    fun penerapanRumahFragment() {
        showFragment(RumahFragment(this))
        atHome = false
    }

    fun penerapanRumahDetailFragment() {
        showFragment(RumahDetailFragment(this))
        atHome = false
    }

    fun penerapanBatikFragment() {
        showFragment(PenerapanBatikFragment(this))
        atHome = false
    }

    fun penerapanBatikDetailFragment() {
        showFragment(PenerapanBatikDetailFragment(this))
        atHome = false
    }

    fun showFragment(fragment: Fragment) {
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragment_container, fragment)
        fram.commit()
    }

    override fun onResume() {
        player.start()
        super.onResume()
    }

    override fun onStart() {
        player.start()
        super.onStart()
    }

    override fun onDestroy() {
        player.stop()
        player.release()
        super.onDestroy()
    }

    override fun onPause() {
        player.pause()
        super.onPause()
    }

    override fun onBackPressed() {
        if (atHome) {
            super.onBackPressed()
        } else {
            if (atSplashScreen) {
                super.onBackPressed()
            } else {
                showFragment(HomeFragment(this))
            }
        }
    }
}