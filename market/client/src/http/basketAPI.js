import {$authHost, $host} from "./index";
import jwt_decode from "jwt-decode";

export const createBasketDevice = async ({deviceId, basketId}) => {
    const {data} = await $authHost.post('api/basket', {deviceId, basketId})
    return data
}

export const fetchBasketDevice = async (basketId, page, limit= 5) => {
    console.log(basketId, page, limit)
    const {data} = await $authHost.get('api/basket', {params: {
        basketId, page, limit
    }})
    return data
}

export const cleanBasket = async (basketId, sales) => {
    console.log(basketId)
    const {data} = await $authHost.delete('api/basket', {data:{basketId, sales}})
    return data
}
