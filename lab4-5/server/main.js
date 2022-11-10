import { WebSocketServer } from 'ws';

const webSocketServer = new WebSocketServer({ port: 8080 });

webSocketServer.on('connection', function connection(ws) {
  ws.on('message', function(data) {
    console.log(`Полученное сообщение на сервере: ${data}`);
  });

  ws.send('Обьект был успешно получен');
});