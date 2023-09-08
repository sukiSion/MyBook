package minori.eden.sion.mybook.page

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import minori.eden.sion.mybook.BuildConfig
import minori.eden.sion.mybook.base.BaseFragment
import minori.eden.sion.mybook.databinding.FragmentConsumeBinding
import minori.eden.sion.mybook.page.adapter.ConsumeAdapter
import minori.eden.sion.mybook.viewmodel.ConsumeViewModel
import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/5 18:35
 * @description
 * @version 1.0.0
 **/
@AndroidEntryPoint
class ConsumeFragment @Inject constructor(): BaseFragment<FragmentConsumeBinding>() {

    private val consumeViewModel: ConsumeViewModel by viewModels()
    @Inject lateinit var consumeAdapter: ConsumeAdapter
    private val layoutManager by lazy {
        GridLayoutManager(context , 3)
    }

    override fun getLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentConsumeBinding  = FragmentConsumeBinding.inflate(inflater , container , false)

    override fun initData() {
        super.initData()
    }

    override fun initView() {
        super.initView()
        binding.also {
            it.rvConsume.layoutManager = layoutManager
            it.rvConsume.adapter = consumeAdapter
        }
    }

    override fun init() {
        super.init()
        consumeViewModel.getExchangeRate(
            onStart = {
                showLoadingDialog()
            }
        ){
            it?.also {
                binding.tvJpyUnit.text = it
            }
            closeLoadingDialog()
        }
    }
}