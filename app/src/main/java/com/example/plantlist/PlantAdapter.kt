package com.example.plantlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter (private val plants: List<Plant>, private val onClick: (Plant) -> Unit) : RecyclerView.Adapter<PlantAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = plants[position]
        holder.bind(event, onClick)
    }

    override fun getItemCount(): Int = plants.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(plant: Plant, onClick: (Plant) -> Unit) {
            itemView.findViewById<TextView>(R.id.plant_name).text = plant.plantName

            itemView.setOnClickListener {
                onClick(plant)
            }
        }
    }
}