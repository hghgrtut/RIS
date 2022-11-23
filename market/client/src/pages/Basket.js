import React, {useContext, useEffect} from 'react';
import {Container} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import BasketList from "../components/BasketList";
import {observer} from "mobx-react-lite";
import {Context} from "../index";
import {fetchBasketDevice} from "../http/basketAPI";
import Pages from "../components/Pages";

const Basket = observer(() => {
    const {basketDevice} = useContext(Context)
    const {user} = useContext(Context)

    useEffect(() => {
        console.log(basketDevice.devices.length)
        fetchBasketDevice(user.user.id, 1, 2).then(data => {
            basketDevice.setDevices(data.rows)
            basketDevice.setTotalCount(data.count)
        })
    }, [])

    useEffect(() => {
        fetchBasketDevice(user.user.id, basketDevice.page, 2).then(data => {
            basketDevice.setDevices(data.rows)
            basketDevice.setTotalCount(data.count)
        })
    }, [basketDevice.page])

    return (
        <Container>
            <Row className="mt-2">
                {!basketDevice.devices.length == 0
                ?
                    <Col md={9}>
                        <BasketList/>
                        <Pages/>
                    </Col>
                :
                    <center style={{fontSize:"30pt"}}>
                        Корзина пуста
                    </center>
                }
                
            </Row>
        </Container>
    );
});

export default Basket;