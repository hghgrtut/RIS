import React, {useContext, useState} from 'react';
import {observer} from "mobx-react-lite";
import {Context} from "../index";
import {Row, Button, Form} from "react-bootstrap";
import BasketItem from "./BasketItem";
import BuyModal from "./modals/BuyModal";

const BasketList = observer(() => {
    const {basketDevice} = useContext(Context)
    const {user} = useContext(Context)
    const [modalVisible, setModalVisible] = useState(false)

    return (
            <Form>
                {basketDevice.devices.map(device =>
                    <BasketItem key={device.id} device={device}/>
                )}
                <div style={{textAlign:"right"}}>
                    <Button variant="outline-success" onClick={() => setModalVisible(true)}>Купить</Button>
                </div>
                <BuyModal devices={basketDevice.devices} show={modalVisible} onHide={() => setModalVisible(false)}/>
            </Form>        
    );
});

export default BasketList;