import React, { Component } from 'react'

export class ShowItem extends Component {
  render() {
    return (
      <div className='item-info'>
        <div>
          <h2>{this.props.item.title}</h2>
          <img src={"./img/" + this.props.item.img} alt='img' onClick={() => this.props.onShowItem(this.props.item)} />
          <p>{this.props.item.case} Case</p>
          <p>{this.props.item.price} byn</p>
          <div className='add-to-cart' onClick={() => this.props.onAdd(this.props.item)}>+</div>
        </div>
      </div>
    )
  }
}

export default ShowItem