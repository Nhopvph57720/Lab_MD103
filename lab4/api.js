const express = require('express');
const app = express();
const port = 3000;

let fruits = [
    { id: 1, name: 'Apple' },
    { id: 2, name: 'Banana' },
    { id: 3, name: 'Orange' }
];

// Endpoint GET để lấy thông tin một "fruit" theo ID
app.get('/api/fruits/:id', (req, res) => {
    const fruitId = parseInt(req.params.id);
    const fruit = fruits.find(fruit => fruit.id === fruitId);

    if (!fruit) {
        return res.status(404).json({ message: 'Không tìm thấy' });
    }

    res.json(fruit);
});

// Endpoint DELETE để xóa một "fruit" theo ID
app.delete('/api/fruits/:id', (req, res) => {
    const fruitId = parseInt(req.params.id);
    const fruitIndex = fruits.findIndex(fruit => fruit.id === fruitId);

    if (fruitIndex === -1) {
        return res.status(404).json({ message: 'không tìm thấy' });
    }

    const deletedFruit = fruits.splice(fruitIndex, 1);
    res.json({
        message: 'Xóa trái cây thành công',
        deletedFruit: deletedFruit[0]
    });
});

app.listen(port, () => {
    console.log(`Server đang chạy tại http://localhost:${port}`);
});
