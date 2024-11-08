const express = require('express')//import thu vien
const app = express()
const port = 3003 //cong server chay

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})