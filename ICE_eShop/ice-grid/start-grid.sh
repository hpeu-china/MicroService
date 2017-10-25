#!/bin/sh
#
echo 'start icegrid registry ...' 
nohup icegridregistry  --Ice.Config=registry.cfg > ice.log 2>&1 &
echo 'start icegrid node 1...'
nohup icegridnode --Ice.Config=node1.cfg > node-1.stderr.log 2>&1 &
ping 127.0.0.1 -c 5 > null
icegridadmin  -u test -p test --Ice.Default.Locator="IceGrid/Locator:tcp -h localhost -p 4061"

