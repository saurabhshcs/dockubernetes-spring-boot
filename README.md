# dockubernetes-spring-boot
This is a simple demo for dockubernetes-spring-boot example

#################################################################################################################################################################
# SUMMARY of Tutorial
1- Create a simaple spring-boot project
   References: https://start.spring.io/ or you can download from https://github.com/saurabhshcs/dockubernetes-spring-boot
2- Create a Dockerfile //Please refer line number at 15-23 or download from https://github.com/saurabhshcs/dockubernetes-spring-boot/blob/main/Dockerfile
3- Create a local docker-image or create a remote repository. Please follow the below mentioned commands from line 28 to line 38.
4- Create a dockubernetes-k8s-demo.yaml file for deploying into kubernetes. 
   Reference - Please download or create - https://github.com/saurabhshcs/dockubernetes-spring-boot/blob/main/dockubernetes-k8s-demo.yaml
5- Cretae a cluster on Google Cloud Platform and deploye above yaml file
   Reference - https://console.cloud.google.com/kubernetes/list?authuser=1&project=gentle-operator-294020
#
###################################################################################################################################################################
#
#   Docker Commands
#
###################################################################################################################################################################
#   0 - Create a Dockerfile into your project-space
#
#   FROM java:8
#  
#   EXPOSE 9006
#   ADD target/dockubernetes.jar dockubernetes.jar  ///(This is the location of the produced jar file of your project. It may depend on your maven's pom.xml or 
#                                                   ///build.gradle)
#
#   ENTRYPOINT ["java", "-jar", "dockubernetes.jar"]
#
####################################################################################################################################################################
#
1- Go to https://hub.docker.com/ and download docker for desktop
2- Sign-up and either create repository manually on web or you can push the repository from local console.
3- Open terminal and type docker login
4- Go to the project location on your system where e.g ~/Desktop/techsharezone/spring-boot/dockubernetes-spring-boot
5- docker build -t dockubernetes . //Type this command to create an image of your project
6- docker images //To view all the images on your local repository of docker
7- docker tag dockubernetes saurabhshcs/dockubernetes //Need to tag first your local docker image to respective repository
8- docker push saurabhshcs/dockubernetes //To push your local repository to the remote docker hub - Here you can either refer to remote repository or push your                                            //local repository to the remote docker-hub

9- docker rmi dockubernetes saurabhshcs/dockubernetes //To remove your local images or associated local repositories
10- docker run -p 9006:9007 saurabhhscs/dockubernetes //once your docker-image has been pushed to the docker-hub then you can pull remote repository and run 
                                                      //your app/microservice from direct docker-hub by using this command.
###################################################################################################################################################################


###################################################################################################################################################################
#
#   Google Cloud Platform - Kuberneted Commands
#
###################################################################################################################################################################
1- Create an account on Google Cloud Platform
2- Go to the Kubernetes Engine
3- Create a cluster (k8s-dockubernetes-for-techsharezone) with default configurations.
4- select or use following comment connect from console to the kubernetes cluster.
   gcloud container clusters get-credentials k8s-dockubernetes-for-techsharezone --zone us-central1-c --project gentle-operator-294020
5- I have used cloud-shell provided by Google Cloud Platform
6- Upload the dockubernetes-k8s-demo.yaml
7- Run ls command to view the list of uploaded yaml file.
8- Run kubectl apply -f dockubernetes-k8s-demo.yaml you must see successfully created message on console.
10- Go to the Workload in the left-hand-side menu and find the expose blue color button on right-hand-side.
11- Now change the target-port as given in the dockubernetes-k8s-demo.yaml file.
12- Select the service-type as Load Balancer if it is not default selected and then click over the expose button following the screen at the bottom.
13- Go to Services & Ingress in the LHS menu and click to see the exposed services. (Eg. dockubernetes-k8s-dem-service)
14- Find the respective service (dockubernetes-k8s-dem-service) and then look for external-endpoints - http://34.72.123.179/login 
15- Happy Dockubernetes-spring-boot

#################################################################################################################################################################
#
# Contact me at saurabhshcs@gmail.com 
# Visit- https://www.linkedin.com/in/saurabhshcs | https://cherrydeck.com/profile/saurabhshcs
#
#################################################################################################################################################################
