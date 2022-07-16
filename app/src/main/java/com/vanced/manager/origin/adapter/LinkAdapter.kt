package com.ytplus.manager.origin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.databinding.ViewSocialLinkBinding
import com.ytplus.manager.origin.model.LinkModel
import com.ytplus.manager.origin.ui.viewmodels.HomeViewModel

class LinkAdapter(
    private val context: Context,
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<LinkAdapter.LinkViewHolder>() {

    private val github = LinkModel(
        AppCompatResources.getDrawable(context, R.drawable.ic_github),
        GITHUB
    )

    private val telegram = LinkModel(
        AppCompatResources.getDrawable(context, R.drawable.ic_telegram),
        TELEGRAM
    )
    private val instagram = LinkModel(
        AppCompatResources.getDrawable(context, R.drawable.ic_instagram),
        INSTAGRAM
    )

    val links = arrayOf(github, telegram, instagram)

    inner class LinkViewHolder(private val binding: ViewSocialLinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val logo = binding.linkImage

        fun bind(position: Int) {
            binding.linkBg.setOnClickListener {
                viewModel.openUrl(links[position].linkUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val view = ViewSocialLinkBinding.inflate(LayoutInflater.from(context), parent, false)
        return LinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.bind(position)
        holder.logo.setImageDrawable(links[position].linkIcon)
    }

    override fun getItemCount(): Int = links.size

    companion object {
        const val GITHUB = "https://github.com/sudhanshu947/YTPlus_Manager"
        const val TELEGRAM = "https://t.me/tgyoutubeplus"
        const val INSTAGRAM = "https://www.instagram.com/mesudhanshuu"
    }

}