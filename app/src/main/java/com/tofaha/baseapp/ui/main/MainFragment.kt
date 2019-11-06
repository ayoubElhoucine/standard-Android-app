package com.tofaha.baseapp.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

import com.tofaha.baseapp.R
import com.tofaha.baseapp.superClasses.SuperFragment

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : SuperFragment() {

    @BindView(R.id.my_text_view)
    lateinit var myText : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        ButterKnife.bind(this , view)

        myText.text = "Text has been changed"

        return view
    }


}
