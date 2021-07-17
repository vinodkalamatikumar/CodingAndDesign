# Observability Stack

Simply install the observability stack - Prometheus, Jaeger, Loki, and Grafana in your environment.

It comes with the demo application "hotrod", fully instrumented with Prometheus, Jaeger and Loki logging

## Prerequisites

There are a set of tools you will need to download and install.

### Docker

Follow instructions [here](https://docs.docker.com/install/).

_Note_: Thie Observ Stack uses Docker Compose for installation. If you are using Docker Desktop for Mac or Windows, Compose is already included. If you are using a Linux system, follow instructions [here](https://docs.docker.com/compose/install/) for installations. 

## Instructions

If you wish to use a Kubernetes cluster other than a local `k3d` one, please adjust these
instructions accordingly.

1. Clone Observ Stack repository
```sh
$ git clone https://orahub.oci.oraclecorp.com/saas-dev-black/observstack.git
$ cd observstack
```

2. Install Observ Stack
```
$ docker-compose up -d
```  

3. Wait
It will take some time to install the stack - there's a lot of downloading to do.

## Accessing the Stack

You should now be able to access the stack via 
- Grafana [http://localhost:3000/](http://localhost:3000).
- Prometheus [http://localhost:9090/](http://localhost:9090).
- Jaeger [http://localhost:16686/](http://localhost:16686).

## Hotrod Demo Application

To see how the staxck works, use the demo app. 
_Note_: You should generate some traffic to the app. Open [http://localhost:8080/](http://localhost:8080) and click the buttons several times.

### Metrics -> Logs -> Traces
- Go to the Hotrod dashboard
- Zoom in on a section with failed requests if you are so inclined
- Panel Drop Down -> Explore
- Datasource Drop Down -> Loki
- Choose a log line with a traceID -> Jaeger

### Logs
- Go to Explore
- Choose Datasource Loki
- Run this query `{job="demo/hotrod"} | json`
- Choose a log line with a traceID -> Jaeger

## Disabling/enabling your Stack
Should you wish to disable your stack, use this command:

```sh
$ cd observstack
$ docker compose down
```

## Configuring your Applications

To see metrics, logs, traces from your applications in the stack, refer the following examples.

_Note_: As default, the stack is launched in the `observstack_default` network by Docker Engine.

- The following command will start a container in the same network, send logs to Loki, and traces to Jaeger. 
```
$ docker run --rm \
  --net observstack_default \
  --log-driver=loki --log-opt loki-url="http://127.0.0.1:3100/loki/api/v1/push" \
  --env JAEGER_AGENT_HOST="jaeger" --env JAEGER_AGENT_PORT=6831 \
  app:1.0 
```

