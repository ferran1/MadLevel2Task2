package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.example.madlevel2task2.databinding.ItemQuestionBinding

class QuestionAdapter(

    private val questions: ArrayList<Question>

) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    // ViewHolder innerclass
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemQuestionBinding.bind(itemView)

        fun databind(question: Question) {
            binding.tvQuestion.text = question.name
        }
    }

}
