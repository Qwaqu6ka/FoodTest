package com.rome4.testfoodrome4.data.repository

import com.rome4.testfoodrome4.data.FoodRepository
import com.rome4.testfoodrome4.data.models.Category
import com.rome4.testfoodrome4.data.models.FoodItem
import kotlinx.coroutines.delay
import java.util.UUID

class FoodLocalRepository : FoodRepository {

    override suspend fun getFood(): List<FoodItem> {
        delay(2000)
        return foodItems
    }

    override suspend fun getCategories(): List<Category> =
        FoodCategory.entries.map { Category(id = it.id, title = it.title) }

    override suspend fun getCities(): List<String> = listOf(
        "Москва",
        "Казань",
    )

    companion object {
        val foodItems = listOf(
            FoodItem(
                imageUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Cat_August_2010-4.jpg/1200px-Cat_August_2010-4.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://static.scientificamerican.com/sciam/cache/file/2AE14CDD-1265-470C-9B15F49024186C10_source.jpg?w=1200",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://cdn.theatlantic.com/thumbor/W544GIT4l3z8SG-FMUoaKpFLaxE=/0x131:2555x1568/1600x900/media/img/mt/2017/06/shutterstock_319985324/original.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://i.natgeofe.com/n/4cebbf38-5df4-4ed0-864a-4ebeb64d33a4/NationalGeographic_1468962_4x3.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://static01.nyt.com/images/2023/12/12/climate/12cli-cats/12cli-cats-articleLarge.jpg?quality=75&auto=webp&disable=upscale",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),
            FoodItem(
                imageUrl = "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Pizza.id
            ),

            FoodItem(
                imageUrl = "https://cdn.theatlantic.com/thumbor/W544GIT4l3z8SG-FMUoaKpFLaxE=/0x131:2555x1568/1600x900/media/img/mt/2017/06/shutterstock_319985324/original.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://i.natgeofe.com/n/4cebbf38-5df4-4ed0-864a-4ebeb64d33a4/NationalGeographic_1468962_4x3.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://static01.nyt.com/images/2023/12/12/climate/12cli-cats/12cli-cats-articleLarge.jpg?quality=75&auto=webp&disable=upscale",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://friendfunction.ru/upload/iblock/25e/9g7l8ytq5q3534u0ed3aqb22vscr82vb/utochka_rezinovaya_ochen_bolshaya_20-_3_.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Juvenile_Ragdoll.jpg/800px-Juvenile_Ragdoll.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),
            FoodItem(
                imageUrl = "https://static.scientificamerican.com/sciam/cache/file/2AE14CDD-1265-470C-9B15F49024186C10_source.jpg?w=1200",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Combo.id
            ),

            FoodItem(
                imageUrl = "https://friendfunction.ru/upload/iblock/25e/9g7l8ytq5q3534u0ed3aqb22vscr82vb/utochka_rezinovaya_ochen_bolshaya_20-_3_.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Juvenile_Ragdoll.jpg/800px-Juvenile_Ragdoll.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://static.scientificamerican.com/sciam/cache/file/2AE14CDD-1265-470C-9B15F49024186C10_source.jpg?w=1200",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://friendfunction.ru/upload/iblock/b84/pvvdjfzclz038dyem59dxg2qurp4ggae/utochka_rezinovaya_zhyeltaya_pervyy_sort_5.JPG",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcRlex2yeMomsbkm0qzpHjtPf8j9QLCDPLZ_brREwaQIrpsnwot3sOfn8Qr3ujA92cho",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://www.sakhalinzoo.ru/upload/photos/650a793a66e3a_1695185210.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),
            FoodItem(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnTHIC6oOdEo6KOj2PLO4wWVIYyCv_L2BZkw&usqp=CAU",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Drinks.id
            ),

            FoodItem(
                imageUrl = "https://friendfunction.ru/upload/iblock/b84/pvvdjfzclz038dyem59dxg2qurp4ggae/utochka_rezinovaya_zhyeltaya_pervyy_sort_5.JPG",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcRlex2yeMomsbkm0qzpHjtPf8j9QLCDPLZ_brREwaQIrpsnwot3sOfn8Qr3ujA92cho",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://www.sakhalinzoo.ru/upload/photos/650a793a66e3a_1695185210.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnTHIC6oOdEo6KOj2PLO4wWVIYyCv_L2BZkw&usqp=CAU",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
                title = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Cat_August_2010-4.jpg/1200px-Cat_August_2010-4.jpg",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
            FoodItem(
                imageUrl = "https://static.scientificamerican.com/sciam/cache/file/2AE14CDD-1265-470C-9B15F49024186C10_source.jpg?w=1200",
                title = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                price = 345,
                categoryId = FoodCategory.Deserts.id
            ),
        )
    }
}


private enum class FoodCategory(val id: String = UUID.randomUUID().toString(), val title: String) {
    Pizza(title = "Пицца"),
    Combo(title = "Комбо"),
    Deserts(title = "Десерты"),
    Drinks(title = "Напитки"),
}