package minori.eden.sion.mybook.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.blankj.utilcode.util.BarUtils
import dagger.hilt.android.AndroidEntryPoint
import minori.eden.sion.mybook.R
import minori.eden.sion.mybook.base.BaseActivity
import minori.eden.sion.mybook.databinding.ActivityMainBinding
import minori.eden.sion.mybook.page.adapter.MainPageAdapter
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject lateinit var planFragment: PlanFragment
    @Inject lateinit var consumeFragment: ConsumeFragment
    private lateinit var mainPageAdapter: MainPageAdapter
    private lateinit var onPageChangeCallback: OnPageChangeCallback

    override fun initLayout(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        BarUtils.addMarginTopEqualStatusBarHeight(binding.vp2Main)
        mainPageAdapter.registerPages(listOf(consumeFragment , planFragment) , binding.vp2Main)
        binding.vp2Main.registerOnPageChangeCallback(onPageChangeCallback)
        binding.bnvMain.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_consume -> {
                    binding.vp2Main.setCurrentItem(0 , true)
                }
                R.id.item_plan -> {
                    binding.vp2Main.setCurrentItem(1 , true)
                }
            }
            return@setOnItemSelectedListener true
        }
    }


    override fun initData() {
        super.initData()
        mainPageAdapter = MainPageAdapter(this)
        onPageChangeCallback = object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        binding.bnvMain.selectedItemId = R.id.item_consume
                    }
                    1 -> {
                        binding.bnvMain.selectedItemId = R.id.item_plan
                    }
                }
            }
        }
    }
}