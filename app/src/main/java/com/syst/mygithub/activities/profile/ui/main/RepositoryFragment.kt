package com.syst.mygithub.activities.profile.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syst.mygithub.R
import com.syst.mygithub.activities.profile.GithubProfileActivity
import com.syst.mygithub.adapters.RepositoryAdapter
import com.syst.mygithub.model.Repository
import com.syst.mygithub.utility.Constants
import com.syst.mygithub.utility.getStr

/**
 * A placeholder fragment containing a simple view.
 */
class RepositoryFragment private constructor() : Fragment() {

    private lateinit var pageViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gitUser = activity?.intent?.extras?.get(GithubProfileActivity.GITUSER) ?: activity?.getStr(
            Constants.GIT_USER)
        pageViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java).apply {
            getPublicRepos(gitUser as String)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_github_repo, container, false)
        val recyclerView:RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        pageViewModel.mlRepos?.observe(viewLifecycleOwner, Observer<List<Repository>> {
            recyclerView.adapter = RepositoryAdapter(it)
        })
        //TODO: pagination
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private lateinit var instance: RepositoryFragment

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): RepositoryFragment {
            instance = RepositoryFragment()
            return instance
        }
    }
}