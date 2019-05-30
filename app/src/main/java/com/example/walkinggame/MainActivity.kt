package com.example.walkinggame

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    var activePlayer = 2
    val player1 = "♔"
    val player2 = "♚"

    fun placedPiece(view: View){
        val clickedTile = view as Button

        if(activePlayer == 1){
            clearBoard()
            clickedTile.text = player1
            activePlayer = 2
        } else {
            clearBoard()
            clickedTile.text = player2
            activePlayer = 1
        }



    }

    fun placeWall(view: View){
        val clickedWall = view as Button

        clickedWall.setBackgroundResource(R.drawable.wood)

    }

    private fun clearBoard(){
        val buttonTiles = arrayOf(t00, t01, t02, t03, t04, t05,
            t10, t11, t12, t13, t14, t15,
            t20, t21, t22, t23, t24, t25,
            t30, t31, t32, t33, t34, t35,
            t40, t41, t42, t43, t44, t45,
            t50, t51, t52, t53, t54, t55
        )

        val currentPlayer = if(activePlayer == 1) player1 else player2

        for(buttonTile in buttonTiles){
            if(buttonTile.text == currentPlayer){
                buttonTile.text = ""
            }
        }

    }

}
