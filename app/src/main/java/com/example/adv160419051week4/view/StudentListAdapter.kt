package com.example.adv160419051week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160419051week4.R
import com.example.adv160419051week4.databinding.StudentListItemBinding
import com.example.adv160419051week4.model.Student
import com.example.adv160419051week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),
    ButtonDetailClickListener {

    class StudentViewHolder(var view: StudentListItemBinding)
        :RecyclerView.ViewHolder(view.root)

    fun updateStudentList(newStudentList:List<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val v = inflater.inflate(R.layout.student_list_item, parent, false)
        val v = DataBindingUtil.inflate<StudentListItemBinding>(inflater,
            R.layout.student_list_item, parent, false)

        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
//        holder.view.txtId.text = studentList[position].id
//        holder.view.txtName.text = studentList[position].name
//        holder.view.imageView.loadImage(studentList[position].photoUrl.toString(), holder.view.progressBar)
//
//        holder.view.btnDetail.setOnClickListener {
//            val studentId = studentList[position].id.toString()
//            val action = StudentListFragmentDirections.actionStudentDetail(studentId)
//            Navigation.findNavController(it).navigate(action)
//        }

        holder.view.student = studentList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}