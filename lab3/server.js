const express = require('express');

const app = express();

const port = 3000;

app.listen(port,() => {
    console.log(' Example app listening on port ${port}')
});

const uri = 'mongodb+srv://Admin1:FuOzgITP7EbyiQAr@cluster0.f8cfq.mongodb.net/Md19304' 

const mongoose = require('mongoose');

const CarModel = require('./carmodel');

app.get('/', async (rep, res) => {
    await mongoose.connect(uri);

    let cars = await CarModel.find();

    console.log(cars);

    res.send(cars)
})

app.get('/add_xe', async (req, res) => {
    await mongoose.connect(uri);

    let car ={
        ten:'vf6',
        namSX:2024,
        hang:'vinfast',
        gia:100000
    }

    let kq = await CarModel.create(car);

    console.log(kq);

    let cars = await CarModel.find();

    console.log(cars);
})

app.get('/xoa/:id', async (req, res) => {
    await mongoose.connect(uri);

    let id = req.params.id;
    console.log(id);

    await CarModel.deleteOne({_id: id});

    res.redirect('../')
}) 

app.get('/update/:ten', async (req,res) =>{
    await mongoose.connect(uri);

    console.log('ket noi DB thanh cong');

    let tenXe = req.params.ten;

    console.log(tenXe);

    let tenXeMoi = tenXe + ' Phien ban moi 2024';

    await CarModel.updateOne({ten: tenXe}, {ten: tenXeMoi});

    let xehois = await CarModel.find({});

    res.send(xehois);

})