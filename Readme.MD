# Spring Boot Open Telemetry

## Run Infrastructure:

```shell
cd infra
docker compose up -d
```

### URL for tools

- [Prometheus](http://localhost:9090/)
- [Grafana](http://localhost:3000/)

## Run application

* Address-Service

```shell
cd address-service
gradle clean bootRun
```

* User-Service

```shell
cd user-service
gradle clean bootRun
```

* open-api-aggregate-service (optional)

```shell
cd open-api-aggregate-service
gradle clean bootRun
```

### Send some traffic to application

```shell
while true; do curl -s -o /dev/null --show-error http://localhost:8080/api/v1/users; sleep 1; done
```

### Open API Documents

- [Common Swagger URL](http://localhost:8086/swagger-ui/index.html)
- [Address-Service](http://localhost:8085/swagger-ui/index.html)
- [User-Service](http://localhost:8080/swagger-ui/index.html)

## Cleanup

```shell
cd infra
docker compose down
```

## Reference

* [Reactive Observability in Spring Boot 3](https://tanzu.vmware.com/developer/guides/observability-reactive-spring-boot-3/)
* [Open API Spring Docs](https://springdoc.org/v2/)
* [Logbook: HTTP request and response logging](https://github.com/zalando/logbook#logbook-http-request-and-response-logging)