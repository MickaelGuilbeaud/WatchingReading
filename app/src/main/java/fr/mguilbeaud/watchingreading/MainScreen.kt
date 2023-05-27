package fr.mguilbeaud.watchingreading

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mguilbeaud.watchingreading.ui.theme.WatchingReadingTheme

@Composable
fun MainScreen() {
    var selectedNavigationBarItem by remember { mutableStateOf(NavigationBarItem.Animes) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            MainNavigationBar(
                navigationBarItems = NavigationBarItem.values().toList(),
                selectedNavigationBarItem = selectedNavigationBarItem,
                onNavigationBarItemSelected = { selectedNavigationBarItem = it },
            )
        },
    ) { paddingValues ->
        Text(
            text = stringResource(selectedNavigationBarItem.nameResId) + " coming soon!",
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        )
    }
}

private enum class NavigationBarItem(
    @StringRes val nameResId: Int,
    @DrawableRes val iconResId: Int,
) {
    Animes(
        nameResId = R.string.navigation_bar_animes,
        iconResId = R.drawable.ic_tv_24,
    ),
    Mangas(
        nameResId = R.string.navigation_bar_mangas,
        iconResId = R.drawable.ic_menu_book_24,
    ),
    Search(
        nameResId = R.string.navigation_bar_search,
        iconResId = R.drawable.ic_search_24,
    ),
    News(
        nameResId = R.string.navigation_bar_news,
        iconResId = R.drawable.ic_newspaper_24,
    ),
    Settings(
        nameResId = R.string.navigation_bar_settings,
        iconResId = R.drawable.ic_settings_24,
    ),
}

@Composable
private fun MainNavigationBar(
    navigationBarItems: List<NavigationBarItem>,
    selectedNavigationBarItem: NavigationBarItem,
    onNavigationBarItemSelected: (NavigationBarItem) -> Unit,
) {
    NavigationBar {
        navigationBarItems.forEach { navigationBarItem ->
            NavigationBarItem(
                selected = navigationBarItem == selectedNavigationBarItem,
                onClick = { onNavigationBarItemSelected(navigationBarItem) },
                icon = {
                    Icon(
                        painter = painterResource(navigationBarItem.iconResId),
                        contentDescription = stringResource(navigationBarItem.nameResId),
                    )
                },
                label = { Text(stringResource(navigationBarItem.nameResId)) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    WatchingReadingTheme {
        MainScreen()
    }
}