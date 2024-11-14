const mongoose = require('mongoose');

const carSchema = new mongoose.Schema({
    ten: {
        type: String,
        required: true
    },
    namSx: {
        type: Number,
    },
    hang: {
        type: String,
        required: true
    },
    gia: {
        type: Number,
    }

});
const CarModel = new mongoose.model('car', carSchema);

module.exports = CarModel; 