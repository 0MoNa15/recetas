package com.mona15.recetas.recipe.detail.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import com.mona15.domain.recipe.model.RecipeDetail
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun RecipeDetailContent(
    recipe: RecipeDetail,
    loading: Boolean,
    error: Boolean,
    popBackStack: () -> Unit,
    navigateToLocationMapScreen: (location: LocationParcelable) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
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
/*
@Preview(showBackground = true)
@Composable
fun RecipeDetailContentPreview() {
    val recipe = RecipeDetail(
        id = "COL001",
        name = "Ajiaco",
        description = "Sopa colombiana espesa y nutritiva.",
        image = "https://ibb.co/wMHM21N",
        ingredients = listOf(
            Ingredient("Papa criolla", 200, "gramos"),
            Ingredient("Pollo", 300, "gramos"),
            Ingredient("Mazorca", 1, "unidad"),
            Ingredient("Caldo de pollo", 1, "litro"),
            Ingredient("Alcaparras", 50, "gramos"),
            Ingredient("Crema de leche", 100, "mililitros")
        ),
        macronutrients = Macronutrient(400, 25, 10, 50),
        location = Location(4.6097, -74.0817, "Bogotá", Country("Colombia", "https://ibb.co/wdzWDHD")),
        preparationTimeMinutes = 40,
        slices = 4,
        difficulty = "Media",
        instructions = listOf(
            "1. Lavar y pelar las papas criollas.",
            "2. Cocinar el pollo en una olla grande con agua.",
            "3. Agregar las papas criollas, la mazorca, el caldo, y otros ingredientes.",
            "4. Cocinar hasta que las papas estén suaves y el caldo espese.",
            "5. Servir caliente y agregar alcaparras y crema al gusto."
        )
    )

    RecipeDetailContent(
        recipe = recipe,
        loading = false,
        error = false,
        popBackStack = {},
        navigateToLocationMapScreen = {}
    )
}*/