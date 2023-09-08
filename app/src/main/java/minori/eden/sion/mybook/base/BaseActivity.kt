package minori.eden.sion.mybook.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.ViewDataBindingKtx
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import com.blankj.utilcode.util.BarUtils
import dagger.hilt.android.AndroidEntryPoint
import minori.eden.sion.mybook.dialog.LoadingDialog

/**
 * @author Sion
 * @date 2023/9/5 11:48
 * @description
 * @version 1.0.0
 **/
abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var binding: VB
    private var loadingDialog:LoadingDialog? = null

    abstract fun initLayout(): VB

    open fun transparentStatue() = true

    open fun initView(){}

    open fun initData(){}

    open fun init(){
        initData()
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(transparentStatue()){
            BarUtils.transparentStatusBar(this)
            BarUtils.setStatusBarLightMode(
                this,
                !BarUtils.isStatusBarLightMode(this)
            )
        }
        binding = initLayout()
        setContentView(binding.root)
        init()
    }

    fun showLoadingDialog(){
         loadingDialog.run {
             val loadingDialog = LoadingDialog()
             loadingDialog.show(
                 supportFragmentManager,
                 LoadingDialog.TAG
             )
             loadingDialog
         }
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