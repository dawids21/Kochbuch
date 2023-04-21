package xyz.stasiak.kochbuch.data

import xyz.stasiak.kochbuch.R

object RecipesSource {
    val recipes = listOf(
        Recipe(
            id = 1,
            name = "Kotlet schabowy",
            type = RecipeType.MAIN_COURSE,
            image = R.drawable.main_course
        ),
        Recipe(
            id = 2,
            name = "Kotlet mielony",
            type = RecipeType.MAIN_COURSE,
            image = R.drawable.main_course
        ),
        Recipe(
            id = 3,
            name = "Kotlet drobiowy",
            type = RecipeType.MAIN_COURSE,
            image = R.drawable.main_course
        ),
        Recipe(
            id = 4,
            name = "Kotlet wołowy",
            type = RecipeType.MAIN_COURSE,
            image = R.drawable.main_course
        ),
        Recipe(
            id = 5,
            name = "Kotlet z indyka",
            type = RecipeType.MAIN_COURSE,
            image = R.drawable.main_course
        ),
        Recipe(
            id = 6,
            name = "Zupa pomidorowa",
            type = RecipeType.SOUP,
            image = R.drawable.soup
        ),
        Recipe(
            id = 7,
            name = "Zupa ogórkowa",
            type = RecipeType.SOUP,
            image = R.drawable.soup
        ),
        Recipe(
            id = 8,
            name = "Zupa cebulowa",
            type = RecipeType.SOUP,
            image = R.drawable.soup
        ),
        Recipe(
            id = 9,
            name = "Zupa pieczarkowa",
            type = RecipeType.SOUP,
            image = R.drawable.soup
        ),
        Recipe(
            id = 10,
            name = "Zupa grzybowa",
            type = RecipeType.SOUP,
            image = R.drawable.soup
        )
    )
}