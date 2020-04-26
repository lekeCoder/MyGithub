package com.syst.mygithub.activities.profile.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.syst.mygithub.R
import com.syst.mygithub.model.Profile
import com.syst.mygithub.activities.profile.GithubProfileActivity
import com.syst.mygithub.utility.Constants
import com.syst.mygithub.utility.Utils
import com.syst.mygithub.utility.getStr
import kotlinx.android.synthetic.main.fragment_github_profile.*
import okhttp3.internal.Internal.instance

/**
 * A placeholder fragment containing a simple view.
 */
class ProfileFragment private constructor(): Fragment() {



    private lateinit var pageViewModel: ProfileViewModel
    private lateinit var htmlUrl: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gitUser = activity?.intent?.extras?.get(GithubProfileActivity.GITUSER) ?: activity?.getStr(Constants.GIT_USER)
        pageViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java).apply {
            setGitUser(gitUser as String)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_github_profile, container, false)
        pageViewModel.profile?.observe(viewLifecycleOwner, Observer {
            Utils.showLog(it.toString(),"ProfileFragment onCreateView()")
            guserTv.text = it.name
            fgTv.text = it.followers.toString()
            frTv.text = it.following.toString()
            pbrTv.text = it.public_repos.toString()
            pbgTv.text = it.public_gists.toString()
            gpBut.text = it.html_url
            htmlUrl = it.html_url
            Glide.with(this).load(it.avatar_url).placeholder(R.drawable.github_logo).into(imageView)
        })
        val gpb:Button = root.findViewById(R.id.gpBut);
        gpb.setOnClickListener {
            if(!htmlUrl.isBlank()){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gpBut.text as String?))
                activity?.startActivity(intent)
            }
        }
        return root
    }



    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private lateinit var profileFragment:ProfileFragment
        private lateinit var instance: ProfileFragment

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(): ProfileFragment {
            instance = ProfileFragment()
            return instance
        }

    }
}