package minori.eden.sion.mybook.net

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import minori.eden.sion.mybook.R
import minori.eden.sion.mybook.bean.ConsumeItemBean

/**
 * @author Sion
 * @date 2023/9/8 15:43
 * @description
 * @version 1.0.0
 **/
@Module
@InstallIn(SingletonComponent::class)
object OtherModule {


 @Provides
 fun getConsumeList(): List<ConsumeItemBean>
         = listOf(
  ConsumeItemBean(R.string.cd , R.drawable.cd_icon),
  ConsumeItemBean(R.string.clothes , R.drawable.clothes_icon),
  ConsumeItemBean(R.string.cd_machine , R.drawable.electronics_devices_icon),
  ConsumeItemBean(R.string.eat , R.drawable.eat_icon),
  ConsumeItemBean(R.string.other , R.drawable.other_icon)
 )


}