<img src="https://www.docker.com/sites/default/files/d8/2019-07/horizontal-logo-monochromatic-white.png" width="256" height="72"> <img src="https://www.freecodecamp.org/news/content/images/2020/10/gcp.png" width="256" height="100">  <img src="https://miro.medium.com/max/700/1*-uckV8DOh3l0bCvqZ73zYg.png" width="256" height="100">

# dockubernetes-spring-boot
> Simaple example of deploying a very simple spring-boot microservice into the Google Cloud Platform K8s using docker image.

# Initial Configurations and steps

- Create a simaple spring-boot project
   References: https://start.spring.io/ or you can download from https://github.com/saurabhshcs/dockubernetes-spring-boot
- Create a Dockerfile //Please refer line number at 15-23 or download from https://github.com/saurabhshcs/dockubernetes-spring-boot/blob/main/Dockerfile
- Create a local docker-image or create a remote repository. Please follow the below mentioned commands from line 28 to line 38.
- Create a dockubernetes-k8s-demo.yaml file for deploying into kubernetes. 
   Reference - Please download or create - https://github.com/saurabhshcs/dockubernetes-spring-boot/blob/main/dockubernetes-k8s-demo.yaml
- Cretae a cluster on Google Cloud Platform and deploye above yaml file
   Reference - https://console.cloud.google.com/kubernetes/list?authuser=1&project=gentle-operator-294020
   
### Docker Configuration

```yaml
 Create a Dockerfile into your project-space
 FROM java:8
   EXPOSE 9006
    ADD target/dockubernetes.jar dockubernetes.jar  ///(This is the location of the produced jar file of your project. It may depend on your maven's pom.xml or 
ENTRYPOINT ["java", "-jar", "dockubernetes.jar"]
```
### Docker repository setup
- Go to https://hub.docker.com/ and download docker for desktop
- Sign-up and either create repository manually on web or you can push the repository from local console.
- Open terminal and type docker login
- Go to the project location on your system where e.g ~/Desktop/techsharezone/spring-boot/dockubernetes-spring-boot
- docker build -t dockubernetes . //Type this command to create an image of your project
- docker images //To view all the images on your local repository of docker
- docker tag dockubernetes saurabhshcs/dockubernetes //Need to tag first your local docker image to respective repository
- docker push saurabhshcs/dockubernetes //To push your local repository to the remote docker hub - Here you can either refer to remote repository or push your                                            //local repository to the remote docker-hub

- docker rmi dockubernetes saurabhshcs/dockubernetes //To remove your local images or associated local repositories
- docker run -p 9006:9007 saurabhhscs/dockubernetes //once your docker-image has been pushed to the docker-hub then you can pull remote repository and run 
                                                      //your app/microservice from direct docker-hub by using this command.
### MySQL setup and configurations for local environment
- Pull `MySQL` by running command `docker pull mysql` image from Official [MYSQL website](https://hub.docker.com/_/mysql)
- Go to the `docker dashboard` then click on `image` section
- Then click over the `run` option
- It should run that `docker mysql image` and create an instance of the `mysql` on local container.
- If it is not working then run this command `docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.26`
- Then go to the `Inspect` and get connetion details for your application configurations.

### Google Cloud Platform - Kubernetes Commands

- Create an account on Google Cloud Platform
- Go to the Kubernetes Engine
- Create a cluster (k8s-dockubernetes-for-techsharezone) with default configurations.
- select or use following comment connect from console to the kubernetes cluster.
   gcloud container clusters get-credentials k8s-dockubernetes-for-techsharezone --zone us-central1-c --project gentle-operator-294020
- I have used cloud-shell provided by Google Cloud Platform
- Upload the dockubernetes-k8s-demo.yaml
- Run ls command to view the list of uploaded yaml file.
- Run kubectl apply -f dockubernetes-k8s-demo.yaml you must see successfully created message on console.
- Go to the Workload in the left-hand-side menu and find the expose blue color button on right-hand-side.
- Now change the target-port as given in the dockubernetes-k8s-demo.yaml file.
- Select the service-type as Load Balancer if it is not default selected and then click over the expose button following the screen at the bottom.
- Go to Services & Ingress in the LHS menu and click to see the exposed services. (Eg. dockubernetes-k8s-dem-service)
- Find the respective service (dockubernetes-k8s-dem-service) and then look for external-endpoints - http://34.72.123.179/login 


Follow me on - [Medium](https://saurabhshcs.medium.com) | [Linkedin](https://www.linkedin.com/in/saurabhshcs/) | [YouTube](https://www.youtube.com/channel/UCSQqjPw7_tfx1Ie4yYHbcxQ?pbjreload=102) | [StackOverFlow](https://stackoverflow.com/users/10719720/saurabhshcs?tab=profile)
