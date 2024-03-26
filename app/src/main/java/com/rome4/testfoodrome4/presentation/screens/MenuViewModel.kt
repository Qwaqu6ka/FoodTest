package com.rome4.testfoodrome4.presentation.screens

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rome4.testfoodrome4.data.FoodRepository
import com.rome4.testfoodrome4.presentation.models.UICategory
import com.rome4.testfoodrome4.presentation.models.UICity
import com.rome4.testfoodrome4.presentation.models.UiFoodItem
import com.rome4.testfoodrome4.presentation.models.mapToUI
import com.rome4.testfoodrome4.presentation.result_api.Result
import com.rome4.testfoodrome4.presentation.result_api.ResultMutableStateFlow
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MenuViewModel(
    private val foodRepository: FoodRepository
) : ViewModel() {
    private var loadDataJob: Job? = null

    private val cities: ResultMutableStateFlow<ImmutableList<UICity>> =
        MutableStateFlow(Result.PendingResult())
    private val activeCity = MutableStateFlow(UICity())
    private val food: ResultMutableStateFlow<ImmutableList<UiFoodItem>> =
        MutableStateFlow((Result.PendingResult()))
    private val categories: ResultMutableStateFlow<ImmutableList<UICategory>> =
        MutableStateFlow(Result.PendingResult())
    private val activeCategory = MutableStateFlow(UICategory())

    val uiState = combine(cities, activeCity, food, categories, activeCategory, ::mergeSources)
        .stateIn(viewModelScope, SharingStarted.Eagerly, ViewState())

    private fun mergeSources(
        cities: Result<ImmutableList<UICity>>,
        activeCity: UICity,
        food: Result<ImmutableList<UiFoodItem>>,
        categories: Result<ImmutableList<UICategory>>,
        activeCategory: UICategory
    ): ViewState {
        val errorInResult = if (cities is Result.ErrorResult) {
            cities.error
        } else if (food is Result.ErrorResult) {
            food.error
        } else if (categories is Result.ErrorResult) {
            categories.error
        } else {
            null
        }

        var citiesList: ImmutableList<UICity> = persistentListOf()
        var categoriesList: ImmutableList<UICategory> = persistentListOf()
        var foodList: ImmutableList<UiFoodItem> = persistentListOf()
        var activeCityToShow = UICity()
        var activeCategoryToShow = UICategory()
        val allSuccess = if (cities is Result.SuccessResult && food is Result.SuccessResult &&
            categories is Result.SuccessResult
        ) {
            citiesList = cities.data
            categoriesList = categories.data
            activeCityToShow = if (activeCity == UICity()) {
                citiesList.first()
            } else {
                activeCity
            }
            activeCategoryToShow = if (activeCategory == UICategory()) {
                categoriesList.first()
            } else {
                activeCategory
            }
            foodList =
                food.data.filter { it.categoryId == activeCategoryToShow.id }.toImmutableList()

            true
        } else {
            false
        }

        val finalResult: Result<Unit> =
            if (errorInResult != null) {
                Result.ErrorResult()
            } else if (allSuccess) {

                Result.SuccessResult(Unit)
            } else {
                Result.PendingResult()
            }

        return ViewState(
            finalResult = finalResult,
            activeCity = activeCityToShow,
            cities = citiesList,
            categories = categoriesList,
            activeCategory = activeCategoryToShow,
            food = foodList
        )
    }

    init {
        loadData()
    }

    private fun loadData() {
        loadDataJob?.cancel()
        loadDataJob = viewModelScope.launch {
            categories.value = Result.PendingResult()
            food.value = Result.PendingResult()
            cities.value = Result.PendingResult()

            categories.value = try {
                Result.SuccessResult(foodRepository.getCategories().map { it.mapToUI() }
                    .toImmutableList())
            } catch (e: Exception) {
                Result.ErrorResult(e)
            }
            food.value = try {
                Result.SuccessResult(foodRepository.getFood().map { it.mapToUI() }
                    .toImmutableList())
            } catch (e: Exception) {
                Result.ErrorResult(e)
            }
            cities.value = try {
                Result.SuccessResult(foodRepository.getCities().map { UICity(it) }
                    .toImmutableList())
            } catch (e: Exception) {
                Result.ErrorResult(e)
            }
        }
    }

    fun reloadData() = loadData()

    fun changeActiveCity(new: UICity) {
        activeCity.value = new
    }

    fun changeActiveCategory(new: UICategory) {
        activeCategory.value = new
    }

    @Immutable
    data class ViewState(
        val activeCity: UICity = UICity(),
        val cities: ImmutableList<UICity> = persistentListOf(),
        val categories: ImmutableList<UICategory> = persistentListOf(),
        val activeCategory: UICategory = UICategory(),
        val food: ImmutableList<UiFoodItem> = persistentListOf(),
        val finalResult: Result<Unit> = Result.PendingResult()
    )
}