package com.helloapp.adapter

import android.content.Context
import android.graphics.Color
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
import com.helloapp.model.UserPost


class HomePostAdapter(context: Context, usersList: List<UserPost>) :
    RecyclerView.Adapter<HomePostAdapter.ViewHolder>() {

    var usersList: List<UserPost>
    var context:Context
    init {
        this.context =context
        this.usersList= usersList
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView
        var tvFolow : TextView
        var tvDate: TextView
        var tvTags:TextView
        var imgPost : SimpleDraweeView
        var imgUser : SimpleDraweeView
        init {
            tvName = view.findViewById(R.id.tvName)
            tvFolow = view.findViewById(R.id.tvFolow)
            tvDate = view.findViewById(R.id.tvDate)
            tvTags = view.findViewById(R.id.tvTags)
            imgPost =view.findViewById(R.id.imgPost)
            imgUser =view.findViewById(R.id.imgUser)
        }
    }


    override fun onBindViewHolder(
        holder: HomePostAdapter.ViewHolder,
        position: Int
    ) {
        val task: UserPost = usersList.get(position)

        holder.tvName.setText(task.name)
        holder.tvFolow.setText(task.follow)
        holder.tvDate.setText(task.date)
        holder.tvTags.setText(task.Tags)
//        Picasso.with(context)
//            .load(R.drawable.nisarg)
//            .transform(RoundedCornersTransform())
//            .into(holder.imgPost);
//        Glide.with(context)
//            .load(R.drawable.nisarg)
//            .into(holder.imgPost)
        val roundingParams = RoundingParams.fromCornersRadius(30f)
        holder.imgPost.setHierarchy(
            GenericDraweeHierarchyBuilder(context.resources)
                .setRoundingParams(roundingParams)
                .build()
        )
        //holder.imgPost.setActualImageResource(R.drawable.nisarg)
        var imgURI = Uri.parse("https://miro.medium.com/fit/c/240/240/1*SF2VIRFshYt2etl6OhNm_Q.png");
                holder.imgPost.setImageURI(imgURI,context);
        holder.imgUser.setImageURI(imgURI,context);



        val color: Int = ContextCompat.getColor(context,R.color.image_border)
        val roundingParams2 = RoundingParams.fromCornersRadius(5f)
        roundingParams2.setBorder(color, 3.0f)
        roundingParams2.roundAsCircle = true
        holder.imgUser.getHierarchy().setRoundingParams(roundingParams2)

    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.row_home_post, parent, false)
        return ViewHolder(itemView)

    }


}