start D:\Ice-3.7.0\bin\icegridregistry  --Ice.Config=registry.cfg
start D:\Ice-3.7.0\bin\icegridnode --Ice.Config=node1.cfg 
ping 127.0.0.1 -n 3 > null
D:\Ice-3.7.0\bin\icegridadmin  -u test -p test --Ice.Default.Locator="IceGrid/Locator:tcp -h localhost -p 4061"

