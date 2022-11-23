import React, {useState} from 'react';
import {Card, Col} from "react-bootstrap";
import Image from "react-bootstrap/Image";
import star from '../assets/star.png'
import plus from '../assets/plus.svg'
import minus from '../assets/minus.svg'

import {useNavigate} from "react-router-dom"

const BasketItem = ({device}) => {
    const navigate = useNavigate()
    const [countBst, setCountBst] = useState(device.basket_devices[0].countDev)
    console.log(device.basket_devices[0].countDev)

    return (
        <Col md={3} className={"mt-3"}>
            <Card style={{width: '80vw'}} border={"light"}>
            <div className="text-black-50 mt-1 d-flex justify-content-between align-items-center">
                <Image width={150} height={150} src={'http://localhost:5000/' + device.img}/>
                <div>{device.name}</div>
                <div className="text-black-50 mt-1 d-flex justify-content-between align-items-center">
                                    </div>
                <div className="text-black-50 mt-1 d-flex justify-content-between align-items-center">
                    <div>{device.rating}</div>
                    <Image width={18} height={18} src={star} style={{marginRight: '20px'}}/> 
                    <div style={{marginRight: '5px'}}>Количество:</div>
                    <Image width={10} height={18} src={minus} style={{cursor: 'pointer'}}/> 
                    {countBst}
                    <Image width={10} height={18} src={plus} style={{cursor: 'pointer'}}/>
                </div>
            </div>
            </Card>
        </Col>
    );
};

export default BasketItem;