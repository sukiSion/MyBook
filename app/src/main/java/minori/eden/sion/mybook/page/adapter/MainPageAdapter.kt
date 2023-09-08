package minori.eden.sion.mybook.page.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

/**
 * @author Sion
 * @date 2023/9/5 18:08
 * @description
 * @version 1.0.0
 **/
class MainPageAdapter(activity: FragmentActivity) :  FragmentStateAdapter(activity){

    private lateinit var pages: List<Fragment>

    fun registerPages(pages: List<Fragment> , vp2: ViewPager2){
        this.pages = pages
        vp2.adapter = this
    }

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment = pages[position]
}