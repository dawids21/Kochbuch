package xyz.stasiak.kochbuch.ui.recipedetails

class ShareDataCreator {

    fun dataCreator(recipeDetailsUiState: RecipeDetailsUiState): String {
        val ingredients =  recipeDetailsUiState.ingredients.map { "\n" + it.name + " " + it.amount + " " + it.unit }
        val steps = recipeDetailsUiState.steps
        var stepsString = ""
        for(step in steps) {
            stepsString += if(step.time != 0) {
                "\n" + step.description + " Czas:" + step.time + " min"
            } else {
                "\n" + step.description
            }
        }
        val result = ingredients.joinToString(separator = "") + "\n" + stepsString
        return result.trim()
    }
}