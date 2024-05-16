package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.SplashScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignUpScreen
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.dashboard.DashboardScreen
import net.ezra.ui.home.HomeScreen
//import net.ezra.ui.auth.SignupScreen
//import net.ezra.ui.home.HomeScreen
import net.ezra.ui.products.AddProductScreen
import net.ezra.ui.products.ProductDetailScreen
import net.ezra.ui.products.ProductListScreen
import net.ezra.ui.ourstore.AddStudents
import net.ezra.ui.ourstore.Search
import net.ezra.ui.ourstore.Students
import net.ezra.ui.products.ProductsScreen
import net.ezra.ui.voucher.VoucherScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {


    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }


        composable(ROUTE_CONTACT) {
          ContactScreen(navController)
        }


        composable(ROUTE_ADD_GOODS) {
            AddStudents(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_VIEW_STUDENTS) {
           Students(navController = navController, viewModel = viewModel() )
        }



        composable(ROUTE_PRODUCTS) {
            Students(navController = navController, viewModel = viewModel() )
        }



        composable(ROUTE_VOUCHER) {
            VoucherScreen(navController )
        }





        composable(ROUTE_SEARCH) {
            Search(navController)
        }

        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }



        composable(ROUTE_PRO_SCREEN) {
            ProductsScreen(navController )
        }


//        composable(ROUTE_DETAILS) {
//            ProductDetailScreen(navController = navController, products = listOf())
//        }



        composable(ROUTE_REGISTER) {
           SignUpScreen(navController = navController) {

           }
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController){}
        }


        composable(ROUTE_UP_DATE) {
            UpdateProductScreen(navController = navController){}
        }

        composable(ROUTE_ADD_PRODUCT) {
            AddProductScreen(navController = navController){}
        }

//        composable(ROUTE_VIEW_PROD) {
//            ProductListScreen(navController = navController, products = listOf1())
//        }



        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(navController, productId)
        }









































    }
}

//fun listOf1(): Any {
//
//}

fun ProductDetailScreen(navController: NavHostController, products: Any) {
    TODO("Not yet implemented")
}

fun UpdateProductScreen(navController: NavHostController, productViewModel: () -> Unit) {

}


