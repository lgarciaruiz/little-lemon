package com.example.littlelemon.model

import com.example.littlelemon.storage.MenuItemRoom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
//searialName can be used to change the name of the class when serializing
@SerialName("MenuNetwork")
data class MenuNetwork (
    val menu: List<MenuItemNetwork>
)

@Serializable
//searialName here and above is not needed as it is the same as the class name
@SerialName("MenuItemNetwork")
data class MenuItemNetwork (
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
){
    //convert MenuItemNetwork to MenuItemRoom
    fun toMenuItemNetwork() = MenuItemRoom(
        id = id,
        title = title,
        description = description,
        price = price,
        image = image,
        category = category
    )
}