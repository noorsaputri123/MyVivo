package com.rie.myvivo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rie.myvivo.R
import com.rie.myvivo.activity.DetailVivoActivity
import com.rie.myvivo.model.Vivo

//Noor Saputri
class ListVivoAdapter (private val listVivo: ArrayList<Vivo>): RecyclerView.Adapter<ListVivoAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_vivo, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount() : Int = listVivo.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listVivo[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.getContext(), DetailVivoActivity::class.java)
            intentDetail.putExtra("key_vivo", listVivo.get(holder.getAdapterPosition()))
            holder.itemView.getContext().startActivity(intentDetail)
        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Vivo)
    }
}