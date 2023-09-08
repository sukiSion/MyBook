package minori.eden.sion.mybook.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import minori.eden.sion.mybook.dialog.LoadingDialog

/**
 * @author Sion
 * @date 2023/9/5 11:48
 * @description
 * @version 1.0.0
 **/
abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    protected lateinit var binding: VB
    private var loadingDialog:LoadingDialog? = null


    abstract fun getLayout(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getLayout(inflater , container)
        return binding.root
    }

    open fun initView(){}

    open fun initData(){}

    open fun init(){
        initData()
        initView()
    }

    fun showLoadingDialog(){
        val loadingDialog = LoadingDialog()
        loadingDialog.show(
            childFragmentManager,
            LoadingDialog.TAG
        )
        this.loadingDialog = loadingDialog
    }


    fun closeLoadingDialog(){
        loadingDialog?.takeIf {
            it.isVisible
        }?.also {
            it.dismissAllowingStateLoss()
        }
        loadingDialog = null
    }

}