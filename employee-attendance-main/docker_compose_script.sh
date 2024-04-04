docker rmi bolpremk/api-gateway
docker rmi bolpremk/access-control-service
docker rmi bolpremk/report-service
docker rmi bolpremk/access-control-service
docker rmi bolpremk/jwt

docker compose -f docker-compose.yaml build

docker push bolpremk/api-gateway
docker push bolpremk/access-control-service
docker push bolpremk/report-service
docker push bolpremk/access-control-service
docker push bolpremk/jwt