package com.ytplus.manager.origin.adapter

/*import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.databinding.ViewSponsorBinding
import com.ytplus.manager.origin.model.SponsorModel
import com.ytplus.manager.origin.ui.viewmodels.HomeViewModel
import com.ytplus.manager.origin.utils.LIGHT
import com.ytplus.manager.origin.utils.currentTheme

class SponsorAdapter(
    private val context: Context,
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<SponsorAdapter.LinkViewHolder>() {

    private val brave = SponsorModel(
        if (currentTheme == LIGHT) AppCompatResources.getDrawable(
            context,
            R.drawable.ic_brave_light
        ) else AppCompatResources.getDrawable(context, R.drawable.ic_brave),
        "Brave",
        BRAVE
    )

    private val adguard = SponsorModel(
        AppCompatResources.getDrawable(context, R.drawable.ic_adguard),
        "AdGuard",
        ADGUARD
    )

    val sponsors = arrayListOf(brave, adguard)

    inner class LinkViewHolder(private val binding: ViewSponsorBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        val logo = binding.sponsorLogo
        fun bind(position: Int) {
            with(binding) {
                sponsorName.text = sponsors[position].name
                cardSponsor.setOnClickListener {
                    viewModel.openUrl(sponsors[position].url)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val view = ViewSponsorBinding.inflate(LayoutInflater.from(context), parent, false)
        return LinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.bind(position)
        holder.logo.setImageDrawable(sponsors[position].logo)
    }

    override fun getItemCount(): Int = 2

    companion object {
        const val BRAVE = "https://vancedapp.com/brave"
        const val ADGUARD = "https://adguard.com/?aid=31141&source=manager"
    }

}*/