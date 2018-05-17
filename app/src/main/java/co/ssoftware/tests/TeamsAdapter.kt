package co.ssoftware.tests

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_team.view.*

/**
 * Created by Esteban Marín on 2/08/17.
 */
class TeamsAdapter(private val items: List<Team>, private val listener: (Team) -> Unit) :
        RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
       return TeamsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_team, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) = holder.bind(items[position], listener)

    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Team, listener: (Team) -> Unit) = with(itemView) {
            tvTeamName.text = item.teamName
            tvTeamCups.text = "Número de copas " + item.teamCups
            Glide.with(context).load(item.imageUrl).into(ivTeam)

            setOnClickListener { listener(item) }
        }

    }
}