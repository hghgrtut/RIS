import React, { Component } from 'react'

export class Types extends Component {
  constructor(props) {
    super(props)
    this.state = {
      types: [
        {
          key: 'all',
          name: 'All'
        },
        {
          key: 'awp',
          name: 'Awp'
        },
        {
          key: 'ak',
          name: 'AK-47'
        }
      ]
    }
  }
  render() {
    return (
      <div className='types'>
        {this.state.types.map(el => (
          <div key={el.key} onClick={() => this.props.chooseType(el.key)}>{el.name}</div>
        ))}
      </div>
    )
  }
}

export default Types