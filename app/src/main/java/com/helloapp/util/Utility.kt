package com.helloapp.util

import android.content.Context
import android.graphics.Typeface
import android.widget.ImageView
import com.helloapp.R

class Utility {

    companion object util {
        fun setSelectedMenu(
            id: Integer,
            home1: ImageView,
            home2: ImageView,
            home3: ImageView,
            home4: ImageView,
            home5: ImageView
        ) {
            when (id) {
                Integer(1) -> {
                    home1.setImageResource(R.drawable.ic_menu_one_white)
                    home1.setBackgroundResource(R.drawable.selected_bottom_menu)

                    home2.setImageResource(R.drawable.ic_menu_two)
                    home2.setBackgroundResource(0)

                    home3.setImageResource(R.drawable.ic_menu_three)
                    home3.setBackgroundResource(0)

                    home4.setImageResource(R.drawable.ic_menu_four)
                    home4.setBackgroundResource(0)

                    home5.setImageResource(R.drawable.ic_menu_five)
                    home5.setBackgroundResource(0)

                }
                Integer(2) -> {
                    home1.setImageResource(R.drawable.ic_menu_one)
                    home1.setBackgroundResource(0)
                    home2.setImageResource(R.drawable.ic_menu_two_white)
                    home2.setBackgroundResource(R.drawable.selected_bottom_menu)

                    home3.setImageResource(R.drawable.ic_menu_three)
                    home3.setBackgroundResource(0)

                    home4.setImageResource(R.drawable.ic_menu_four)
                    home4.setBackgroundResource(0)

                    home5.setImageResource(R.drawable.ic_menu_five)
                    home5.setBackgroundResource(0)


                }
                Integer(3) -> {
                    home1.setImageResource(R.drawable.ic_menu_one)
                    home1.setBackgroundResource(0)

                    home2.setImageResource(R.drawable.ic_menu_two)
                    home2.setBackgroundResource(0)

                    home3.setImageResource(R.drawable.ic_menu_three_white)
                    home3.setBackgroundResource(R.drawable.selected_bottom_menu)
                    home4.setImageResource(R.drawable.ic_menu_four)
                    home4.setBackgroundResource(0)

                    home5.setImageResource(R.drawable.ic_menu_five)
                    home5.setBackgroundResource(0)

                }
                Integer(4) -> {
                    home1.setImageResource(R.drawable.ic_menu_one)
                    home1.setBackgroundResource(0)

                    home2.setImageResource(R.drawable.ic_menu_two)
                    home1.setBackgroundResource(0)

                    home3.setImageResource(R.drawable.ic_menu_three)
                    home3.setBackgroundResource(0)

                    home4.setImageResource(R.drawable.ic_menu_four_white)
                    home4.setBackgroundResource(R.drawable.selected_bottom_menu)
                    home5.setImageResource(R.drawable.ic_menu_five)
                    home5.setBackgroundResource(0)

                }
                Integer(5) -> {
                    home1.setImageResource(R.drawable.ic_menu_one)
                    home1.setBackgroundResource(0)

                    home2.setImageResource(R.drawable.ic_menu_two)
                    home2.setBackgroundResource(0)

                    home3.setImageResource(R.drawable.ic_menu_three)
                    home3.setBackgroundResource(0)

                    home4.setImageResource(R.drawable.ic_menu_four)
                    home4.setBackgroundResource(0)

                    home5.setImageResource(R.drawable.ic_menu_five_white)
                    home5.setBackgroundResource(R.drawable.selected_bottom_menu)
                }
            }
        }

        fun getFontSemiBold(context: Context) : Typeface{
            val face = Typeface.createFromAsset(
                context.getAssets(),
                "fonts/poppins_semibold.ttf"
            )
            return face
        }
    }

}