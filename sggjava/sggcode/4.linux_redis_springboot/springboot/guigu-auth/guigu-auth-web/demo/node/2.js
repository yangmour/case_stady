const { log } = require('node:console');
const http = require('node:http');

// 官网找到创建一个服务
const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'application/json' });
  res.end(JSON.stringify({
    data: 'Hello World!'
  }));
});

server.listen(8000);

console.log("http://localhost:8000");