import React, { useState } from 'react'
import Order from './Order'

const fileWrite = (data, file, orderList) => {
  console.log('2')
  const fileData = JSON.stringify({ ...orderList, ...data })
  const blob = new Blob([fileData], { type: "text/plain" })
  const url = URL.createObjectURL(blob)
  const link = document.createElement('a')
  link.download = `${file}.json`
  link.href = url
  link.click()
  console.log(orderList)
}

const showOrderCart = (props) => {
  let sum = 0
  props.orders.forEach(el => sum += Number.parseFloat(el.price));
  return (
    <div className='order-cart-list'>
      <p className='order-cart-title'>List:</p>

      {props.orders.map(el => (
        <div className='order-cart-info' key={el.id}>
          <p>{el.type}: {el.title} из {el.case} за {el.price} byn</p>
        </div>
      ))}

      <p className='sum'>Sum: {new Intl.NumberFormat().format(sum)} byn</p>
    </div>
  )
}

const showOrderCartError = () => { console.log('error') }

const showOrders = (props) => {
  let sum = 0
  props.orders.forEach(el => sum += Number.parseFloat(el.price));
  return (
    <div>
      {props.orders.map(el => (
        <Order onDelete={props.onDelete} key={el.id} item={el} />
      ))}
      <p className='sum'>Sum: {new Intl.NumberFormat().format(sum)} byn</p>
    </div>
  )
}

const showNothing = () => {
  return (<div className='empty'>
    <h2>
      Empty
    </h2>
  </div>)
}

export default function Header(props) {
  let [cartOpen, setCartOpen] = useState(false)
  let [orderOpen, setOrderOpen] = useState(false)
  let [orderList, setOrderList] = useState(
    {
      firstName: "",
      lastName: "",
      email: "",
      address: ""
    })

  return (
    <header>
      <div>
        <span className='logo'>Train Shop</span>
        <ul className='nav'>
          <li>Profile</li>
          <li>Info</li>
          <li onClick={() => setCartOpen(cartOpen = !cartOpen)} className={`shop-cart-button ${cartOpen && 'active'}`}>Cart</li>
          {cartOpen && (
            <div>
              <div className='shop-cart'>
                {props.orders.length > 0 ? showOrders(props) : showNothing()}
                <div className='order'>
                  <p onClick={() => props.orders.length > 0 ? setOrderOpen(orderOpen = true) : setOrderOpen(orderOpen = false)}>Оформить заказ</p>
                </div>
              </div>
              {orderOpen && (
                <div className='order-cart'>
                  <p onClick={() => setOrderOpen(orderOpen = false)} className='close-button'>X</p>
                  {
                    props.orders.length > 0 ? showOrderCart(props) : showOrderCartError()
                  }
                  <div>
                    <input value={orderList.firstName} type='text' placeholder='Enter first name' onChange={e => setOrderList({ ...orderList, firstName: e.target.value })}></input>
                    <input value={orderList.lastName} type='text' placeholder='Enter last name' onChange={e => setOrderList({ ...orderList, lastName: e.target.value })}></input>
                    <input value={orderList.email} type='email' placeholder='Enter email' onChange={e => setOrderList({ ...orderList, email: e.target.value })}></input>
                    <input value={orderList.address} type='text' placeholder='Enter address' onChange={e => setOrderList({ ...orderList, address: e.target.value })}></input>
                    <input type='button' onClick={() => fileWrite(props.orders, 'test', orderList)}></input>
                  </div>
                </div>
              )}
            </div>
          )
          }
        </ul>

      </div >
      <div className='presentation'></div>
    </header >
  )
}
