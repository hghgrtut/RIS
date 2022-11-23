const uuid = require('uuid')
const path = require('path');
const {BasketDevice, Device, Basket, Sale} = require('../models/models')
const ApiError = require('../error/ApiError');
const { Sequelize } = require('../db');

class BasketController {
    async create(req, res, next) {
        try {
            let {deviceId, basketId} = req.body
            let bBasketDevice = await BasketDevice.findOne({where:{basketId, deviceId}})
            if(!bBasketDevice){
                const basketDevice = await BasketDevice.create({deviceId, basketId});
                return res.json(basketDevice)
            }
            const basketDevice = await BasketDevice.update(
                {countDev: bBasketDevice.countDev+1},
                {where:{deviceId, basketId}}
            );
            return res.json(basketDevice)
        } catch (e) {
            next(ApiError.badRequest(e.message))
        }
    }

    async getAll(req, res, next) {
        try {
            let {basketId, limit, page} = req.query
            page = page || 1
            limit = 9
            let offset = page * limit - limit
            let basketDevicesID;
            console.log(basketId)
            basketDevicesID = await BasketDevice.findAll({where: {basketId}})
            console.log(basketDevicesID)
            let arrBasketDevicesID = [];
            basketDevicesID.map((bd) =>{
                arrBasketDevicesID.push(bd.deviceId)
            })
            let devices;
            console.log(arrBasketDevicesID)

            devices = await Device.findAndCountAll(
                {include: [{
                    model: BasketDevice, 
                    where:{basketId}
                }], 
                where:{id: arrBasketDevicesID}, limit, offset})
            
            //await Sequelize.query(
            //   "SELECT id, name, price, rating, img, brandId FROM basket_devices JOIN devices ON basket_devices.deviceId = devices.id WHERE device.id IN"+arrBasketDevicesID
        // )
            //= await Device.findAndCountAll({where:{id: arrBasketDevicesID}, limit, offset})

            console.log(devices)

            return res.json(devices)
        } catch (e) {
            next(ApiError.badRequest(e.message))
        }
    }

    async deleteByBasketId(req, res, next) {
        try {
            let {basketId, sales} = req.body
            console.log(basketId, sales)
            sales.map(async(sale) =>{
                await Sale.create({
                    name: sale.name, 
                    price: sale.price, 
                    countDev: sale.countDev, 
                    nameUser: sale.nameUser, 
                    addrUser: sale.addrUser
                })
            })
            let basketDevice = await BasketDevice.destroy({where: {basketId}})
            return res.json(basketDevice)
        } catch (e) {
            next(ApiError.badRequest(e.message))
        }
    }
}

module.exports = new BasketController()