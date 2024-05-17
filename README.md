# Messages - kotlin course challenge project

> Project to prove learning. Through a resource, list, save and delete messages.

- Message list

```
curl -X GET http://localhost:8080/messages
```

- Add message

```
curl -X POST http://localhost:8080/messages -H "Content-Type: application/json" -d '{"text": "Hello, world!"}'
```

- Delete message (delete the first message from the list)

```
curl -X DELETE http://localhost:8080/messages/1
```

- Authors

[**Diorgenes Morais**](https://github.com/diorgenesmorais)
