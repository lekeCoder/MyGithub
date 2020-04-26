package com.syst.mygithub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syst.mygithub.R
import com.syst.mygithub.model.Repository
import kotlinx.android.synthetic.main.repo.view.*

open class RepositoryAdapter constructor(
    var list: List<Repository>
) : RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.repo,parent,false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val r : Repository = list.get(position)
        r.let {
            holder.setData(it)
        }
    }
}