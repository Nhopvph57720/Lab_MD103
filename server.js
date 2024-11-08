const { createServer } = require('node:http'); //import thu vien

const hostname = '127.0.0.1'; // local host
const port = 3000;//cổng lắng nghe server 

const server = createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain;charset=utf-8');
  res.write('NodeJS \n');
  res.write('Hello World');
  res.end();
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
