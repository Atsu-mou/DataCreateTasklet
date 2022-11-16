# Mock Api

This is the app for Mock Api

## Requirements

For building and running the application you need:

- [Docker](https://docs.docker.com/desktop/install/mac-install/)

## Running the application locally

First to run the app locally, you need to create the required componet. For this app you need to execute the command bellow.
```shell
docker-compose up -d
```

## Check Mock Api

```shell
curl -X POST http://localhost:1080/send/foo
```