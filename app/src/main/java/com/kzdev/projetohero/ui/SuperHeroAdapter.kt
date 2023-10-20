package com.kzdev.projetohero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kzdev.projetohero.R
import com.kzdev.projetohero.model.SuperHero

class SuperHeroAdapter(private val dataSet: List<SuperHero>) :
    RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val textViewRace: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textViewName = view.findViewById(R.id.tv_s_hero_name)
            textViewRace = view.findViewById(R.id.tv_s_hero_race)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_super_hero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewName.text = dataSet[position].name
        viewHolder.textViewRace.text = dataSet[position].appearance.race
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

