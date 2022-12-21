package by.hghgrtut.shop.contracts

class ApiRouter {
    
    companion object {

        private const val API_BASE_URL = "api/v1"
    }

    object AuthRouter {
        const val BASE_URL = "${API_BASE_URL}auth"
        const val LOGIN = "/login"
        const val TOKEN = "/token"
        const val REFRESH = "/refresh"
    }

    object UserRouter {
        const val BASE_URL = "${API_BASE_URL}user"
        const val FIND_BY_ID = "/{id}"
        const val UPDATE = "/{id}"
        const val DELETE_BY_ID = "/{id}"
    }

    object ItemRouter {
        const val BASE_URL = "${API_BASE_URL}item"
        const val FIND_BY_ID = "/{id}"
        const val UPDATE = "/{id}"
        const val DELETE_BY_ID = "/{id}"
    }

    object BasketItem {
        const val BASE_URL = "${API_BASE_URL}item"
        const val FIND_BY_ID = "/{id}"
        const val UPDATE = "/{id}"
        const val ADD_FLOWER = "/basket/itemId"
        const val DELETE_BY_ID = "/{id}"
    }
}