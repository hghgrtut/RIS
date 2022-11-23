const Router = require('express')
const router = new Router()
const basketController = require('../controllers/basketController')

router.post('/', basketController.create)
router.get('/', basketController.getAll)
router.delete('/', basketController.deleteByBasketId)


module.exports = router