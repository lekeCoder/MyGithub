package com.syst.mygithub.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.syst.mygithub.model.Repository
import kotlinx.android.synthetic.main.repo.view.*

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(repo: Repository) {
        itemView.repoName.text = repo.name
        itemView.repoDesc.text = repo.description
        itemView.forkBut.text = repo.forks.toString()
        itemView.watchBut.text = repo.watchers.toString()
        itemView.starBut.text = repo.stars.toString()
    }

}
