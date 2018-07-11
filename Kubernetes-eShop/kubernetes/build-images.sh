#!/bin/bash


cd ..

mvn package -DskipTests -Djar 

cd kubernetes

echo "copy auth-service file"
cp ../auth-service/target/eshop_k8s_auth_service.jar auth-service/
#/usr/bin/cp ../auth-service/src/main/resources/application.yml auth-service/

docker build -t eshop-auth-image:v1 auth-service/
docker tag eshop-auth-image:v1 philophilo/eshop-auth-image:v1
docker push philophilo/eshop-auth-image:v1

echo "copy product-service file=========================================================="
cp ../product-service/target/eshop_k8s_product-service.jar product-service/
#/usr/bin/cp ../product-service/src/main/resources/application.yml product-service/

docker build -t eshop-product-image:v1 product-service/
docker tag eshop-product-image:v1 philophilo/eshop-product-image:v1
docker push philophilo/eshop-product-image:v1

echo "copy cart-service file"
cp ../cart-service/target/eshop_k8s_cart-service.jar  cart-service/
#/usr/bin/cp ../cart-service/src/main/resources/application.yml cart-service/

docker build -t eshop-cart-image:v1 cart-service/
docker tag eshop-cart-image:v1 philophilo/eshop-cart-image:v1
docker push philophilo/eshop-cart-image:v1

echo "copy cart-service file============================================================="
cp ../eshop-web/target/eshop_k8s_eshop_web.jar  eshop-web/
#/usr/bin/cp ../eshop-web/src/main/resources/application.yml eshop-web/

docker build -t eshop-web:v1 eshop-web/
docker tag eshop-web:v1 philophilo/eshop-web:v1
docker push philophilo/eshop-web:v1



