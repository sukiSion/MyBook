package minori.eden.sion.mybook.page

import minori.eden.sion.mybook.base.BaseActivity
import minori.eden.sion.mybook.databinding.ActivityConsumeRecordBinding

/**
 * @author Sion
 * @date 2023/9/8 18:31
 * @description
 * @version 1.0.0
 **/
class ConsumeRecordActivity: BaseActivity<ActivityConsumeRecordBinding>() {

    override fun initLayout(): ActivityConsumeRecordBinding {
        return ActivityConsumeRecordBinding.inflate(layoutInflater)
    }


}