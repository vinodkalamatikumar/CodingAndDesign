# Observability Stack

Simply install Observability Stack ("ObservStack") - Prometheus, Jaeger, Loki, and Grafana in your environment.

- It comes with the demo application "hotrod", fully instrumented.
- Grafana is pre-configured with the persistence storage (./data directory).
- Prometheus, Jaeger, and Loki are pre-configured as stateless / ephemeral.
- Vector discovers container logs and send to Loki.

## Prerequisites

Docker Desktop now requires a subscription to run and is no longer free. 
Rancher Desktop and Podman are open source alternatives that can run containers on your local laptop.
You will need to install either one of them to run the observstack.

To learn more about Rancher Desktop, visit [here](https://docs.rancherdesktop.io/).

To learn more about Podman, visit [here](https://docs.podman.io/en/latest/).

### Prepare Rancher Desktop for observstack 

Follow the [instructions](https://docs.rancherdesktop.io/getting-started/installation) for your laptop platform.
When prompted, choose the following options:
- Dockerd as the Container Engine
- Let Rancher Desktop edits your shell profile for you. _Note_: this add `${HOME}/.rd/bin` to the beginning of your PATH so that all your docker commands are running from there. If you do not want to let Rancher Desktop edit your PATH, be sure to add `${HOME}/.rd/bin` to your PATH manually.

### Prepare Podman for observstack 

1. Install podman 
```
$ brew install podman
$ export PATH="$PATH:/opt/homebrew/bin/"
```

2. Start podman machine
```
$ podman machine init -v $HOME:$HOME
$ podman machine start
```

3. Export podman socket for docker-compose to access
```
After running "podman machine start", follow the instructions to set DOCKER_HOST env variable.
```

4. Install docker-compose
```
$ brew install docker-compose
```

5. Create symlink to run podman with docker command (Optional)
```
$ ln -s /usr/local/bin/podman /usr/local/bin/docker
```

6. Update podman vm selinux to permissive
```
$ podman machine ssh
$ sudo -i
$ sed -i 's/SELINUX=enforcing/SELINUX=permissive/' /etc/selinux/config
```

7. Restart podman machine
```
$ podman machine stop
$ podman machine start
```

## Instructions

1. Clone ObservStack repository
```sh
$ git clone https://orahub.oci.oraclecorp.com/saas-dev-black/observstack.git
$ cd observstack
```

2. Install ObservStack

For Rancher Desktop
```
$ docker-compose -f docker-compose-rancher-desktop.yml up
```
For Podman
```
$ docker-compose -f docker-compose-podman.yml up
```  

3. Wait
It will take some time to install ObservStack - there's a lot of downloading to do.

## Accessing ObservStack

You should now be able to access ObservStack via 
- Grafana [http://localhost:3000/](http://localhost:3000).
- Prometheus [http://localhost:9090/](http://localhost:9090).
- Jaeger [http://localhost:16686/](http://localhost:16686).

## Hotrod Demo Application

To see how the stack works, use the demo app. 
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

## Disabling/enabling ObservStack
Should you wish to disable your Stack, use this command:

```sh
$ cd observstack
$ docker-compose -f docker-compose-rancher-desktop.yml down
```
or the following if you are using podman
```
$ docker-compose -f docker-compose-podman.yml down
```

## Configuring your Applications

To see metrics, logs, traces from your applications via ObservStack, refer the following examples.

_Note_: As default, ObservStack is launched in the `observstack_default` network by podman machine. 

- The following command will start a container in the same network, send logs to Loki, and traces to Jaeger. 
```
$ podman run --rm \
  --net observstack_default \
  -l namespace=demo -l service=myapp \
  --log-driver=k8s-file \
  -e JAEGER_ENDPOINT='http://jaeger:14268/api/traces' \
  -e JAEGER_SAMPLER_TYPE=const \
  -e JAEGER_SAMPLER_PARAM=1  \
  app:1.0
```

