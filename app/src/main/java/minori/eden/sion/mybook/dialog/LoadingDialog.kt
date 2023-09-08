package minori.eden.sion.mybook.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import minori.eden.sion.mybook.base.BaseDialog
import minori.eden.sion.mybook.databinding.DialogLoadingBinding
import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/8 15:03
 * @description
 * @version 1.0.0
 **/
class LoadingDialog @Inject constructor(): BaseDialog<DialogLoadingBinding>() {

    companion object{
         val TAG = LoadingDialog::class.java.simpleName
    }

    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): DialogLoadingBinding {
        return DialogLoadingBinding.inflate(inflater , container , false)
    }
}