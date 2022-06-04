package com.example.adv160419051week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160419051week4.R
import com.example.adv160419051week4.databinding.FragmentStudentDetailBinding
import com.example.adv160419051week4.model.Student
import com.example.adv160419051week4.util.loadImage
import com.example.adv160419051week4.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*

class StudentDetailFragment : Fragment(),
    ButtonUpdateClickListener {

    private lateinit var viewDetail:DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(
            inflater, R.layout.fragment_student_detail, container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId

            viewDetail = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewDetail.fetch(studentId)

            observeDetailViewModel()

            dataBinding.listener = this
        }
    }

    fun observeDetailViewModel() {
        viewDetail.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it

//            txtIdDetail.setText(it.id)
//            txtNameDetail.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)
//
//            imageView2.loadImage(it.photoUrl.toString(), progressBar2)
        })
    }

    override fun onButtonUpdateClick(v: View) {
        Toast.makeText(v.context, "Update Success", Toast.LENGTH_SHORT).show()
    }
}