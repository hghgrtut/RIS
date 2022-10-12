import { WebSocketServer } from 'ws';

const wss = new WebSocketServer({ port: 8080 });

wss.on('connection', function connection(ws) {
  ws.on('message', function(data) {
    console.log(`Полученное сообщение на сервере: ${data}`);
  });

  ws.send('Обьект был успешно получен');
});