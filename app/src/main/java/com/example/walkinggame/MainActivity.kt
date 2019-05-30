package com.example.walkinggame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardSize = 10
        var gameBoard = Array(boardSize, { IntArray(boardSize) })

        for (row in 0 until boardSize) {
            for (col in 0 until boardSize) {
                gameBoard[row][col] = 0
            }
        }
    }

    // TODO: Implement Rules using the gameBoard

    var wallsPlaced = 0

    var activePlayer = 2
    val player1 = "♔"
    val player2 = "♚"

    fun placedPiece(view: View){
        val clickedTile = view as Button

        if(wallsPlaced > 0){
            return
        }

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

        if(clickedWall.text == " " && wallsPlaced != 0){
            clickedWall.text = ""
            clickedWall.setBackgroundResource(R.drawable.floor_soft)
            wallsPlaced -= 1

            return
        }

        if(clickedWall.text == " "){
            return
        }


        clickedWall.setBackgroundResource(R.drawable.button_bg_stroke)
        clickedWall.text = " "

        if(wallsPlaced == 1){
            wallsPlaced = 0
            activePlayer = if(activePlayer == 1) 2 else 1
            return
        }

        wallsPlaced += 1

    }

    private fun clearBoard(){
        val buttonTiles = arrayOf(
            arrayOf(t00, t01, t02, t03, t04, t05),
            arrayOf(t10, t11, t12, t13, t14, t15),
            arrayOf(t20, t21, t22, t23, t24, t25),
            arrayOf(t30, t31, t32, t33, t34, t35),
            arrayOf(t40, t41, t42, t43, t44, t45),
            arrayOf(t50, t51, t52, t53, t54, t55)
        )

        val currentPlayer = if(activePlayer == 1) player1 else player2

        for(row in buttonTiles){
            for(buttonTile in row)
            if(buttonTile.text == currentPlayer){
                buttonTile.text = ""
            }
        }

    }

}
