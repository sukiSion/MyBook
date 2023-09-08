package minori.eden.sion.mybook.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @author Sion
 * @date 2023/9/8 15:46
 * @description
 * @version 1.0.0
 **/
data class ConsumeItemBean(
    @StringRes val consumeItemName: Int,
    @DrawableRes val consumeItemIcon: Int
)