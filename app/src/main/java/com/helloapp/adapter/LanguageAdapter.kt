package com.helloapp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.view.SimpleDraweeView
import com.helloapp.R
import com.helloapp.model.LanguageModel
import com.helloapp.model.UserPost


class LanguageAdapter(context: Context, languageList: List<LanguageModel>) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    var languageList: List<LanguageModel> = languageList
    var context:Context = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvLanguage: TextView
        var imgLanguage : SimpleDraweeView
        init {
            tvLanguage = view.findViewById(R.id.tvLanguage)
            imgLanguage =view.findViewById(R.id.imgLanguage)
        }
    }


    override fun onBindViewHolder(
        holder: LanguageAdapter.ViewHolder,
        position: Int
    ) {
        val task: LanguageModel = languageList.get(position)

        holder.tvLanguage.setText(task.name)
        val roundingParams = RoundingParams.fromCornersRadius(30f)
        holder.imgLanguage.setHierarchy(
            GenericDraweeHierarchyBuilder(context.resources)
                .setRoundingParams(roundingParams)
                .build())
        holder.imgLanguage.setActualImageResource(task.image)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.row_select_language,parent, false)
        return ViewHolder(itemView)

    }


}