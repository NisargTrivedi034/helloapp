package com.helloapp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.view.SimpleDraweeView
import com.helloapp.R
import com.helloapp.model.Users
import com.helloapp.util.Utility


class HomeUserStoryAdapter(context: Context, usersList: List<Users>) :
    RecyclerView.Adapter<HomeUserStoryAdapter.ViewHolder>() {

    var usersList: List<Users>
    var context:Context
    init {
        this.context =context
        this.usersList= usersList
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView
        var imgAddStory : ImageView
        var imgUser : SimpleDraweeView
        init {
            tvName = view.findViewById(R.id.tvName)
            imgAddStory = view.findViewById(R.id.imgAddStory)
            imgUser = view.findViewById(R.id.imgUser)
        }
    }


    override fun onBindViewHolder(
            holder: HomeUserStoryAdapter.ViewHolder,
            position: Int
    ) {
        val task: Users = usersList.get(position)
        if(position==0) {
            holder.imgAddStory.visibility = View.VISIBLE
            //holder.imgUser.borderColor = Color.WHITE
            holder.tvName.setTypeface(Utility.getFontSemiBold(context))
            holder.tvName.setTextColor(context.resources.getColor(R.color.your_story_text_color))

            val color: Int = context.getResources().getColor(R.color.white)
            val roundingParams = RoundingParams.fromCornersRadius(5f)
            roundingParams.setBorder(color, 1.0f)
            roundingParams.roundAsCircle = true
            holder.imgUser.getHierarchy().setRoundingParams(roundingParams)


        }else {
            holder.imgAddStory.visibility = View.GONE
            holder.tvName.setTextColor(context.resources.getColor(R.color.home_color_users))
            holder.tvName.setTypeface(Utility.getFontSemiBold(context))

            val color: Int = context.getResources().getColor(R.color.home_user_back)
            val roundingParams = RoundingParams.fromCornersRadius(5f)
            roundingParams.setBorder(color, 3.0f)
            roundingParams.roundAsCircle = true
            holder.imgUser.getHierarchy().setRoundingParams(roundingParams)

        }
//        val roundingParams = RoundingParams.fromCornersRadius(30f)
//        holder.imgUser.setHierarchy(
//                GenericDraweeHierarchyBuilder(context.resources)
//                        .setRoundingParams(roundingParams)
//                        .build()
//        )
        //holder.imgPost.setActualImageResource(R.drawable.nisarg)
        var imgURI = Uri.parse("https://miro.medium.com/fit/c/240/240/1*SF2VIRFshYt2etl6OhNm_Q.png");
        holder.imgUser.setImageURI(imgURI);

        holder.tvName.setText(task.userName)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.home_user_row, parent, false)
        return ViewHolder(itemView)

    }


}