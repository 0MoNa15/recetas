package com.mona15.recetas.recipe.detail.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import com.mona15.domain.recipe.model.RecipeDetail
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mona15.domain.recipe.model.Ingredient
import com.mona15.domain.recipe.model.Macronutrient
import com.mona15.recetas.R
import com.mona15.recetas.map.mapper.LocationMapMapper
import com.mona15.recetas.map.model.LocationParcelable
import com.mona15.recetas.recipe.list.view.state.NoDataScreen

@Composable
fun RecipeDetailContent(
    recipe: RecipeDetail?,
    loading: Boolean,
    error: Boolean,
    navigateToLocationMapScreen: (location: LocationParcelable) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .testTag(stringResource(R.string.recipedetailcontenttag))
    ) {
        if (loading) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.loading_size))
                    .align(Alignment.Center)
                    .padding(
                        top = dimensionResource(id = R.dimen.detail_screen_padding) + dimensionResource(
                            id = R.dimen.card_size
                        ) / 2f,
                        start = dimensionResource(id = R.dimen.padding_double),
                        end = dimensionResource(id = R.dimen.padding_double),
                        bottom = dimensionResource(id = R.dimen.padding_double)
                    )
            )
        } else {
            if (recipe != null && !error){
                RecipeDetailView(recipe, navigateToLocationMapScreen)
            } else {
                NoDataScreen(message = stringResource(R.string.no_se_ha_encontrado_el_detalle), painterResource(id = R.drawable.detalle_404))
            }
        }
    }
}

@Composable
fun RecipeDetailView(recipe: RecipeDetail, navigateToLocationMapScreen: (location: LocationParcelable) -> Unit){
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            RecipeImageTime(imageUrl = recipe.image, time = recipe.preparationTimeMinutes)
        }

        item {
            RecipeNameAndDescription(name = recipe.name, description = recipe.description)
        }

        item {
            RecipeNutritionalInformation(macronutrients = recipe.macronutrients)
        }

        item {
            RecipeIngredient(ingredients = recipe.ingredients)
        }

        item {
            RecipeInstructions(instructions = recipe.instructions)
        }

        item {
            RecipeDetails(preparationTime = recipe.preparationTimeMinutes, slices = recipe.slices, difficulty = recipe.difficulty)
        }

        item {
            LocationButton(
                location = LocationMapMapper.fromDomainToParcelable(recipe.location),
                navigateToLocationMapScreen = navigateToLocationMapScreen)
        }
    }
}

@Composable
fun RecipeImageTime(imageUrl: String, time: Int) {
    Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            TimeItem(minuteTime = "$time min")
        }
    }
}

@Composable
fun TimeItem(minuteTime: String) {
    Row(Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)) {
        Text(text = minuteTime, style = TextStyle(color = Color.White))
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_time_white),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_24_dp))
        )
    }
}

@Composable
fun RecipeNameAndDescription(name: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_32_dp))
    ) {
        Text(
            text = name,
            style = typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding)))
        Text(text = description, style = typography.body1)
    }
}

@Composable
fun RecipeNutritionalInformation(macronutrients: Macronutrient) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_32_dp),
                end = dimensionResource(id = R.dimen.padding_32_dp)
            )
    ) {
        Text(text = stringResource(R.string.informaci_n_nutricional), style = typography.h6, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NutritionItem(name = stringResource(R.string.calor_as), value = macronutrients.calories)
            NutritionItem(name = stringResource(R.string.prote_nas), value = macronutrients.proteins)
            NutritionItem(name = stringResource(R.string.grasas), value = macronutrients.fats)
            NutritionItem(name = stringResource(R.string.carbohidratos), value = macronutrients.carbohydrates)
        }
    }
}

@Composable
fun NutritionItem(name: String, value: Int) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_4dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$value", style = typography.body2, fontWeight = FontWeight.Bold)
        Text(text = name, style = typography.caption)
    }
}

@Composable
fun RecipeIngredient(ingredients: List<Ingredient>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_32_dp),
                end = dimensionResource(id = R.dimen.padding_32_dp),
                top = dimensionResource(id = R.dimen.padding_double)
            )) {
        Text(
            text = stringResource(R.string.ingredientes),
            style = typography.h6,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding)))

        ingredients.forEachIndexed { index, ingredient ->
            Text(
                text = "${ingredient.amount} ${ingredient.presentation} de ${ingredient.name}",
                style = typography.body2
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RecipeInstructions(instructions: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(id = R.dimen.padding_double),
                start = dimensionResource(id = R.dimen.padding_32_dp),
                end = dimensionResource(id = R.dimen.padding_32_dp)
            )
    ) {
        Text(text = stringResource(R.string.preparaci_n), style = typography.h6, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding)))
        instructions.forEachIndexed { index, instruction ->
            Text(text = "${index + 1}. $instruction", style = typography.body2)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RecipeDetails(preparationTime: Int, slices: Int, difficulty: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(id = R.dimen.padding_double),
                bottom = dimensionResource(id = R.dimen.padding_double),
                start = dimensionResource(id = R.dimen.padding_32_dp),
                end = dimensionResource(id = R.dimen.padding_32_dp)
            )
    ) {
        Text(text = stringResource(R.string.detalles_de_la_receta), style = typography.h6, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_4dp)))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DetailItem(
                icon = R.drawable.ic_time_black,
                text = stringResource(R.string.min, preparationTime),
                label = stringResource(R.string.tiempo_de_preparaci_n))
            DetailItem(icon = R.drawable.ic_slice_black, text = "$slices", label = stringResource(R.string.porciones))
            DetailItem(icon = R.drawable.ic_difficulty_black, text = difficulty, label = stringResource(R.string.dificultad))
        }
    }
}

@Composable
fun DetailItem(icon: Int, text: String, label: String) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_4dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_24_dp))
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_4dp)))
        Text(text = text, style = typography.caption)
        Text(text = label, style = typography.caption)
    }
}

@Composable
fun LocationButton(location: LocationParcelable, navigateToLocationMapScreen: (location: LocationParcelable) -> Unit) {

    Button(
        onClick = {
                    navigateToLocationMapScreen(location)
                  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(id = R.dimen.padding_double),
                bottom = dimensionResource(id = R.dimen.padding_32_dp),
                start = dimensionResource(id = R.dimen.padding_32_dp),
                end = dimensionResource(id = R.dimen.padding_32_dp)
            ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(dimensionResource(id = R.dimen.padding_24_dp)))
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding)))
            Text(text = stringResource(R.string.ver_lugar_de_origen))
        }
    }
}