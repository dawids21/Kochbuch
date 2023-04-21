package xyz.stasiak.kochbuch.data

import xyz.stasiak.kochbuch.R

object RecipesSource {
    val recipes = listOf(
        RecipeWithSteps(
            recipe = Recipe(
                id = 1,
                name = "Kotlet schabowy",
                type = RecipeType.MAIN_COURSE,
                image = R.drawable.main_course,
                ingredients = "Schab,Mąka,Jajko,Sól,Pieprz,Olej"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 1,
                    order = 1,
                    description = "Schab pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 1,
                    order = 2,
                    description = "Kawałki schabu panierować w mące, jajku i mące.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 1,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 2,
                name = "Kotlet mielony",
                type = RecipeType.MAIN_COURSE,
                image = R.drawable.main_course,
                ingredients = "Mięso mielone,Mąka,Jajko,Sól,Pieprz,Olej"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 2,
                    order = 1,
                    description = "Mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 2,
                    order = 2,
                    description = "Kawałki mięsa mielonego panierować w mące, jajku i mące.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 2,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 3,
                name = "Kotlet drobiowy",
                type = RecipeType.MAIN_COURSE,
                image = R.drawable.main_course,
                ingredients = "Drobiowe mięso mielone,Mąka,Jajko,Sól,Pieprz,Olej"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 3,
                    order = 1,
                    description = "Drobiowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 3,
                    order = 2,
                    description = "Kawałki drobiowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 3,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 4,
                name = "Kotlet wołowy",
                type = RecipeType.MAIN_COURSE,
                image = R.drawable.main_course,
                ingredients = "Wołowe mięso mielone,Mąka,Jajko,Sól,Pieprz,Olej"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 4,
                    order = 1,
                    description = "Wołowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 4,
                    order = 2,
                    description = "Kawałki wołowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 4,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 5,
                name = "Kotlet z indyka",
                type = RecipeType.MAIN_COURSE,
                image = R.drawable.main_course,
                ingredients = "Indykowe mięso mielone,Mąka,Jajko,Sól,Pieprz,Olej"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 5,
                    order = 1,
                    description = "Indykowe mięso mielone pokroić na kawałki, wymieszać z mąką, jajkiem, solą i pieprzem.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 5,
                    order = 2,
                    description = "Kawałki indykowego mięsa mielonego panierować w mące, jajku i mące.",
                    time = 5
                ),
                RecipeStep(
                    recipeId = 5,
                    order = 3,
                    description = "Kotlety smażyć na patelni z olejem.",
                    time = 10
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 6,
                name = "Zupa pomidorowa",
                type = RecipeType.SOUP,
                image = R.drawable.soup,
                ingredients = "Pomidory,Cebula,Olej,Mąka,Bulion,Sól,Pieprz"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 6,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 5
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
                    time = 5
                ),
                RecipeStep(
                    recipeId = 6,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 5
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 7,
                name = "Zupa ogórkowa",
                type = RecipeType.SOUP,
                image = R.drawable.soup,
                ingredients = "Ogórki,Cebula,Olej,Mąka,Bulion,Sól,Pieprz"
            ),
            steps = listOf(
                RecipeStep(
                    recipeId = 7,
                    order = 1,
                    description = "Cebulę pokroić w kostkę, podsmażyć na patelni z olejem.",
                    time = 5
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
                    time = 5
                ),
                RecipeStep(
                    recipeId = 7,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 5
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 8,
                name = "Zupa cebulowa",
                type = RecipeType.SOUP,
                image = R.drawable.soup,
                ingredients = "Cebula,Olej,Mąka,Bulion,Sól,Pieprz"
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
                    time = 5
                ),
                RecipeStep(
                    recipeId = 8,
                    order = 3,
                    description = "Zupę zagotować.",
                    time = 5
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 9,
                name = "Zupa pieczarkowa",
                type = RecipeType.SOUP,
                image = R.drawable.soup,
                ingredients = "Pieczarki,Cebula,Olej,Mąka,Bulion,Sól,Pieprz"
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
                    time = 5
                ),
                RecipeStep(
                    recipeId = 9,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 5
                )
            )
        ),
        RecipeWithSteps(
            recipe = Recipe(
                id = 10,
                name = "Zupa grzybowa",
                type = RecipeType.SOUP,
                image = R.drawable.soup,
                ingredients = "Grzyby,Cebula,Olej,Mąka,Bulion,Sól,Pieprz"
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
                    time = 5
                ),
                RecipeStep(
                    recipeId = 10,
                    order = 4,
                    description = "Zupę zagotować.",
                    time = 5
                )
            )
        )
    )
}