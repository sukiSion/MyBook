package minori.eden.sion.mybook.page

import android.view.LayoutInflater
import android.view.ViewGroup
import minori.eden.sion.mybook.base.BaseFragment
import minori.eden.sion.mybook.databinding.FragmentPlanBinding
import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/5 18:33
 * @description
 * @version 1.0.0
 **/
class PlanFragment @Inject constructor() : BaseFragment<FragmentPlanBinding>() {
    override fun getLayout(inflater: LayoutInflater, container: ViewGroup?): FragmentPlanBinding
    = FragmentPlanBinding.inflate(inflater , container , false)


}