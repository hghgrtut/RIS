import React, {useContext, useEffect, useState} from 'react';
import {Button, Card, Col, Container, Image, Row, Form} from "react-bootstrap";
import bigStar from '../assets/bigStar.png'
import {useParams, useNavigate} from 'react-router-dom'
import {fetchOneDevice} from "../http/deviceAPI";
import {createBasketDevice} from "../http/basketAPI";
import {Context} from "../index";
import {SHOP_ROUTE} from '../utils/consts';

const DevicePage = () => {
    const [device, setDevice] = useState({info: []})
    const {user} = useContext(Context)
    const {id} = useParams()
    const navigate = useNavigate()

    useEffect(() => {
        fetchOneDevice(id).then(data => setDevice(data))
        console.log(parseInt(id), user.user.id)
    }, [])

    const addInBasket = () => {
        
        console.log(parseInt(id), user.user.id)
        createBasketDevice({deviceId: parseInt(id), basketId: user.user.id}).then(data => {})
        navigate(SHOP_ROUTE)
    }

    return (
        <Container className="mt-3">
            <Row>
                <Col md={4}>
                    <Image width={300} height={300} src={'http://localhost:5000/' + device.img}/>
                </Col>
                <Col md={4}>
                    <Form className="d-flex flex-column align-items-center">
                        <h2>{device.name}</h2>
                        <div
                            className="d-flex align-items-center justify-content-center"
                            style={{background: `url(${bigStar}) no-repeat center center`, width:240, height: 240, backgroundSize: 'cover', fontSize:64}}
                        >
                            {device.rating}
                        </div>
                    </Form>
                </Col>
                <Col md={4}>
                    <Card
                        className="d-flex flex-column align-items-center justify-content-around"
                        style={{width: 300, height: 300, fontSize: 32, border: '5px solid lightgray'}}
                    >
                        <h3>От: {device.price} руб.</h3>
                        <Button variant={"outline-dark"} onClick={addInBasket}>Добавить в корзину</Button>
                    </Card>
                </Col>
            </Row>
            <Row className="d-flex flex-column m-3">
                <h1>Характеристики</h1>
                {device.info.map((info, index) =>
                    <Row key={info.id} style={{background: index % 2 === 0 ? 'lightgray' : 'transparent', padding: 10}}>
                        {info.title}: {info.description}
                    </Row>
                )}
            </Row>
        </Container>
    );
};

export default DevicePage;