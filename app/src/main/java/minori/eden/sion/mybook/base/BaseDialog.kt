package minori.eden.sion.mybook.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

/**
 * @author Sion
 * @date 2023/9/8 15:09
 * @description
 * @version 1.0.0
 **/
abstract class BaseDialog<VB: ViewBinding>: DialogFragment() {

    protected lateinit var binding: VB

    abstract fun initLayout(inflater: LayoutInflater , container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.also {
            it.decorView.setPadding(0 , 0 , 0 , 0)
            it.setBackgroundDrawableResource(android.R.color.transparent)
            it.setLayout(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        }
        initLayout(inflater , container).also {
            binding = it
            return binding.root
        }
    }

    open fun initView(){}

    open fun initData(){}
}