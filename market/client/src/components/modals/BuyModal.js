import React, {useState, useContext} from 'react';
import Modal from "react-bootstrap/Modal";
import {Button, Form} from "react-bootstrap";
import {cleanBasket} from "../../http/basketAPI";
import {Context} from "../../index";
import { useNavigate } from 'react-router-dom';
import {SHOP_ROUTE} from "../../utils/consts";


const BuyModal = ({devices, show, onHide}) => {
    const [name, setName] = useState('')
    const [addr, setAddr] = useState('')
    const navigate = useNavigate()
    const {basketDevice} = useContext(Context)
    const {user} = useContext(Context)

    console.log(devices)
    const buy = () => {
        let sales =[]
        basketDevice.devices.map((dev) => {
            const tempDev = {
                name: dev.name, 
                price: dev.price, 
                countDev: dev.basket_devices[0].countDev, 
                nameUser: name, 
                addrUser: addr
            }
            sales.push(tempDev)
        }
        )
        console.log(sales)
        cleanBasket(user.user.id, sales)
        navigate(SHOP_ROUTE)
    }

    return (
        <Modal
            show={show}
            onHide={onHide}
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Данные для доставки
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Control
                        value={name}
                        onChange={e => setName(e.target.value)}
                        placeholder={"Введите ФИО"}
                    />
                </Form>
                <h1></h1>
                <Form>
                    <Form.Control
                        value={addr}
                        onChange={e => setAddr(e.target.value)}
                        placeholder={"Введите адрес"}
                    />
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="outline-danger" onClick={onHide}>Закрыть</Button>
                <Button variant="outline-success" onClick={buy}>Купить</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default BuyModal;