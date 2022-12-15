import React from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Items from "./components/Items";
import Types from "./components/Types";
import ShowItem from "./components/ShowItem";
import { Auth } from "./components/Auth";

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      items: [
        {
          id: 1,
          title: 'Chromatic Aberration',
          img: 'awp_chromatic-aberration.png',
          case: 'Recoil',
          type: 'awp',
          price: '389.26'
        },
        {
          id: 2,
          title: 'Containment Breach',
          img: 'awp_containment-breach.png',
          case: 'Shattered Web',
          type: 'awp',
          price: '1691.09'
        },
        {
          id: 3,
          title: 'Wildfire',
          img: 'awp_wildfire.png',
          case: 'CS20',
          type: 'awp',
          price: '689.33'
        }
      ],
      currentItems: [],
      orders: [],
      showItem: false,
      itemInfo: {}
    }
    this.state.currentItems = this.state.items
    this.addToOrder = this.addToOrder.bind(this)
    this.deleteOrder = this.deleteOrder.bind(this)
    this.chooseType = this.chooseType.bind(this)
    this.onShowItem = this.onShowItem.bind(this)
  }
  render() {
    return (
      <div className="wrapper">
        <Auth />
        <Header orders={this.state.orders} onDelete={this.deleteOrder} onShowOrder={this.showOrder} />
        <Types chooseType={this.chooseType} />
        <Items onShowItem={this.onShowItem} items={this.state.currentItems} onAdd={this.addToOrder} />
        {this.state.showItem && <ShowItem onAdd={this.addToOrder} onShowItem={this.onShowItem} item={this.state.itemInfo} />}
        <Footer />
      </div>
    );
  }

  onShowItem(item) {
    this.setState({ itemInfo: item })
    this.setState({ showItem: !this.state.showItem })
  }

  addToOrder(item) {
    let isInArray = false;
    this.state.orders.forEach(el => {
      if (el.id === item.id) {
        isInArray = true
        alert('No more')
      }
    })
    if (!isInArray) {
      this.setState({ orders: [...this.state.orders, item] })
      alert('Added')
    }
  }

  deleteOrder(id) {
    this.setState({ orders: this.state.orders.filter(el => el.id !== id) })
  }

  chooseType(type) {
    if (type === 'all') {
      this.setState({ currentItems: this.state.items })
      return
    }
    this.setState({
      currentItems: this.state.items.filter(el => el.type === type)
    })
  }

}

export default App;
