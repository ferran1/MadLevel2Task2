package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questions = arrayListOf<Question>()
    private val questionAdapter = QuestionAdapter(questions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        // Setup the recyclerview
        binding.rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvQuestions.adapter = questionAdapter

        createItemTouchHelperSwipe().attachToRecyclerView(rvQuestions)

        // Fill the recycle view with the questions
        addQuestionsToRecycleView()

        questionAdapter.notifyDataSetChanged()
    }

    private fun addQuestionsToRecycleView() {
        questions.add(Question("A 'val' and 'var' are the same.", false))
        questions.add(Question("Mobile Application Development grants 12 ECTS.", false))
        questions.add(Question("A Unit in Kotlin corresponds to a void in Java.", true))
        questions.add(Question("In Kotlin 'when' replaces the 'switch' operator in Java.", true))
    }

    private fun createItemTouchHelperSwipe(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper (enable left and right swipe only)
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

             // Callback which is triggered when the user swiped an item
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val question = questions[position]

                if ((direction == ItemTouchHelper.RIGHT && question.answer) || (direction == ItemTouchHelper.LEFT && !question.answer)
                ) {
                    questions.removeAt(position)
                } else {
                    Snackbar.make(
                        rvQuestions,
                        "Wrong answer!",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                questionAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }
}