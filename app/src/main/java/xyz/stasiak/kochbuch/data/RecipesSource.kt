package xyz.stasiak.kochbuch.data

import xyz.stasiak.kochbuch.R

object RecipesSource {
    val recipes = listOf(
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 1,
                name = "Kotlet schabowy",
                type = RecipeType.MAIN_COURSE,
                calories = 1000,
                image = R.drawable.pork_chop,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 1,
                    recipeId = 1,
                    name = "Schab",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 2,
                    recipeId = 1,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 3,
                    recipeId = 1,
                    name = "Jajko",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 4,
                    recipeId = 1,
                    name = "Sól",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 5,
                    recipeId = 1,
                    name = "Pieprz",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 6,
                    recipeId = 1,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 1,
                    order = 1,
                    description = "Schab pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 1,
                    order = 2,
                    description = "Kawałki schabu panierować w mące, jajku i mące.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 1,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 2,
                name = "Kotlet mielony",
                type = RecipeType.MAIN_COURSE,
                calories = 700,
                image = R.drawable.meatloaf,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 7,
                    recipeId = 2,
                    name = "Mięso mielone",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 8,
                    recipeId = 2,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 9,
                    recipeId = 2,
                    name = "Jajko",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 10,
                    recipeId = 2,
                    name = "Sól",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 11,
                    recipeId = 2,
                    name = "Pieprz",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 12,
                    recipeId = 2,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 2,
                    order = 1,
                    description = "Mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 2,
                    order = 2,
                    description = "Kawałki mięsa mielonego panierować w mące, jajku i mące.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 2,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 3,
                name = "Kotlet drobiowy",
                type = RecipeType.MAIN_COURSE,
                calories = 500,
                image = R.drawable.chicken_chop,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 13,
                    recipeId = 3,
                    name = "Drobiowe mięso mielone",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 14,
                    recipeId = 3,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 15,
                    recipeId = 3,
                    name = "Jajko",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 16,
                    recipeId = 3,
                    name = "Sól",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 17,
                    recipeId = 3,
                    name = "Pieprz",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 18,
                    recipeId = 3,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 3,
                    order = 1,
                    description = "Drobiowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 3,
                    order = 2,
                    description = "Kawałki drobiowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 3,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 4,
                name = "Kotlet wołowy",
                type = RecipeType.MAIN_COURSE,
                calories = 800,
                image = R.drawable.beef_chop
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 19,
                    recipeId = 4,
                    name = "Wołowe mięso mielone",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 20,
                    recipeId = 4,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 21,
                    recipeId = 4,
                    name = "Jajko",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 22,
                    recipeId = 4,
                    name = "Sól",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 23,
                    recipeId = 4,
                    name = "Pieprz",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 24,
                    recipeId = 4,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 4,
                    order = 1,
                    description = "Wołowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 4,
                    order = 2,
                    description = "Kawałki wołowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 4,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 5,
                name = "Kotlet z indyka",
                type = RecipeType.MAIN_COURSE,
                calories = 450,
                image = R.drawable.turkey_chop,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 25,
                    recipeId = 5,
                    name = "Indykowe mięso mielone",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 26,
                    recipeId = 5,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 27,
                    recipeId = 5,
                    name = "Jajko",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 28,
                    recipeId = 5,
                    name = "Sól",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 29,
                    recipeId = 5,
                    name = "Pieprz",
                    amount = 0.5f,
                    unit = "łyżka"
                ),
                RecipeIngredient(
                    id = 30,
                    recipeId = 5,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 5,
                    order = 1,
                    description = "Indykowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 5,
                    order = 2,
                    description = "Kawałki indykowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 5,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 6,
                name = "Zupa pomidorowa",
                type = RecipeType.SOUP,
                calories = 300,
                image = R.drawable.tomato_soup,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 31,
                    recipeId = 6,
                    name = "Cebula",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 32,
                    recipeId = 6,
                    name = "Pomidory",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 33,
                    recipeId = 6,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 34,
                    recipeId = 6,
                    name = "Bulion",
                    amount = 1f,
                    unit = "l"
                ),
                RecipeIngredient(
                    id = 35,
                    recipeId = 6,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 6,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 6,
                    order = 2,
                    description = "Pomidory pokroić w kostkę, dodać do cebuli, podsmażyć.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 6,
                    order = 3,
                    description = "Mąkę wymieszać z bulionem, dodać do zupy, wymieszać.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 6,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 15
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 7,
                name = "Zupa ogórkowa",
                type = RecipeType.SOUP,
                calories = 300,
                image = R.drawable.cucumber_soup,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 36,
                    recipeId = 7,
                    name = "Ogórek",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 37,
                    recipeId = 7,
                    name = "Cebula",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 38,
                    recipeId = 7,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 39,
                    recipeId = 7,
                    name = "Bulion",
                    amount = 1f,
                    unit = "l"
                ),
                RecipeIngredient(
                    id = 40,
                    recipeId = 7,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 7,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 7,
                    order = 2,
                    description = "Ogórki pokroić w kostkę, dodać do cebuli, podsmażyć.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 7,
                    order = 3,
                    description = "Mąkę wymieszać z bulionem, dodać do zupy, wymieszać.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 7,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 15
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 8,
                name = "Zupa cebulowa",
                type = RecipeType.SOUP,
                calories = 350,
                image = R.drawable.onion_soup,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 41,
                    recipeId = 8,
                    name = "Cebula",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 42,
                    recipeId = 8,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 43,
                    recipeId = 8,
                    name = "Bulion",
                    amount = 1f,
                    unit = "l"
                ),
                RecipeIngredient(
                    id = 44,
                    recipeId = 8,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 8,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 8,
                    order = 2,
                    description = "Mąkę wymieszać z bulionem, dodać do zupy, wymieszać.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 8,
                    order = 3,
                    description = "Zupę zagotować.",
                    time = 15
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 9,
                name = "Zupa pieczarkowa",
                type = RecipeType.SOUP,
                calories = 400,
                image = R.drawable.mushroom_soup,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 45,
                    recipeId = 9,
                    name = "Pieczarki",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 46,
                    recipeId = 9,
                    name = "Cebula",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 47,
                    recipeId = 9,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 48,
                    recipeId = 9,
                    name = "Bulion",
                    amount = 1f,
                    unit = "l"
                ),
                RecipeIngredient(
                    id = 49,
                    recipeId = 9,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 9,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 9,
                    order = 2,
                    description = "Pieczarki pokroić w kostkę, dodać do cebuli, podsmażyć.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 9,
                    order = 3,
                    description = "Mąkę wymieszać z bulionem, dodać do zupy, wymieszać.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 9,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 15
                )
            )
        ),
        RecipeWithIngredientsAndSteps(
            recipe = Recipe(
                id = 10,
                name = "Zupa grzybowa",
                type = RecipeType.SOUP,
                calories = 470,
                image = R.drawable.mushroom_soup_2,
            ),
            ingredients = listOf(
                RecipeIngredient(
                    id = 50,
                    recipeId = 10,
                    name = "Grzyby",
                    amount = 1f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 51,
                    recipeId = 10,
                    name = "Cebula",
                    amount = 1f,
                    unit = "szt"
                ),
                RecipeIngredient(
                    id = 52,
                    recipeId = 10,
                    name = "Mąka",
                    amount = 0.5f,
                    unit = "kg"
                ),
                RecipeIngredient(
                    id = 53,
                    recipeId = 10,
                    name = "Bulion",
                    amount = 1f,
                    unit = "l"
                ),
                RecipeIngredient(
                    id = 54,
                    recipeId = 10,
                    name = "Olej",
                    amount = 0.5f,
                    unit = "łyżka"
                )
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 10,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 10,
                    order = 2,
                    description = "Grzyby pokroić w kostkę, dodać do cebuli, podsmażyć.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 10,
                    order = 3,
                    description = "Mąkę wymieszać z bulionem, dodać do zupy, wymieszać.",
                    time = 0
                ),
                RecipeStep(
                    recipeId = 10,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 15
                )
            )
        )
    )
}