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

```shell
cd user-service
gradle clean bootRun
```

### Send some traffic to application

```shell
while true; do curl http://localhost:8080/api/v1/users ; sleep 1; done
```

## Cleanup

```shell
cd infra
docker compose down
```

## Reference
* [Reactive Observability in Spring Boot 3](https://tanzu.vmware.com/developer/guides/observability-reactive-spring-boot-3/)
