package xyz.stasiak.kochbuch.data

object RecipesSource {
    val recipes = listOf(
        Recipe(
            id = 1,
            name = "Kotlet schabowy",
            type = RecipeType.MAIN_COURSE
        ),
        Recipe(
            id = 2,
            name = "Kotlet mielony",
            type = RecipeType.MAIN_COURSE
        ),
        Recipe(
            id = 3,
            name = "Kotlet drobiowy",
            type = RecipeType.MAIN_COURSE
        ),
        Recipe(
            id = 4,
            name = "Kotlet wołowy",
            type = RecipeType.MAIN_COURSE
        ),
        Recipe(
            id = 5,
            name = "Kotlet z indyka",
            type = RecipeType.MAIN_COURSE
        ),
        Recipe(
            id = 6,
            name = "Zupa pomidorowa",
            type = RecipeType.SOUP
        ),
        Recipe(
            id = 7,
            name = "Zupa ogórkowa",
            type = RecipeType.SOUP
        ),
        Recipe(
            id = 8,
            name = "Zupa cebulowa",
            type = RecipeType.SOUP
        ),
        Recipe(
            id = 9,
            name = "Zupa pieczarkowa",
            type = RecipeType.SOUP
        ),
        Recipe(
            id = 10,
            name = "Zupa grzybowa",
            type = RecipeType.SOUP
        )
    )
}