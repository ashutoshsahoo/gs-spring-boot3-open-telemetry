FROM openjdk:17-slim AS builder
WORKDIR /usr/local/temp
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-slim
ARG VERSION=latest
LABEL version=${VERSION}
LABEL maintainer="Ashutosh Sahoo"
LABEL description="User Service Application"

WORKDIR /usr/local/app
RUN useradd --user-group --system --create-home --no-log-init app
USER app
COPY --from=builder /usr/local/temp/dependencies/ ./
COPY --from=builder /usr/local/temp/spring-boot-loader/ ./
COPY --from=builder /usr/local/temp/snapshot-dependencies/ ./
COPY --from=builder /usr/local/temp/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]