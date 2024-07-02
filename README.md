1 Install docker locally
2 Install minikube
3 Start minikube => Minikube start
4 Verify status => Minikube status
5 Create a DOCKERfile
===========================================================
# Use the official OpenJDK image from the Docker Hub
FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/springboot-kubs-app.jar springboot-kubs-app.jar
ENTRYPOINT ["java","-jar","/springboot-kubs-app.jar"]
============================================================
5 Set Docker environment to use Minikube's Docker daemon => eval $(minikube docker-env)
6 Go to the project folder and run docker image command => Docker build -t jar_name:1.0 .
7 Check images => docker images
8 Create Deployment.yml file on the project folder and run deploy command
=========================================================================================
Kubectl apply -f deployment_file.yml
============================================
apiVersion: apps/v1
kind: Deployment # Kubernetes resource kind we are creating
metadata:
  name: springboot-kubs-app
spec:
  selector:
    matchLabels:
      app: springboot-kubs-app
  replicas: 3 # Number of replicas that will be created for this deployment
  template:
    metadata:
      labels:
        app: springboot-kubs-app
    spec:
      containers:
        - name: springboot-kubs-app
          image: springboot-kubs-app:1.0 # Image that will be used to containers in the cluster
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 8080 # The port that the container is running on in the cluster
=========================================================================================
9 See all deployments => kubectl get deployments
10 See all pods => kubectl get  pods
11 See logs for pod 1 => kubectl logs pod1

12 => Create k8_service.yml file 
=========================================================================================
apiVersion: v1
kind: Service
metadata:
  name: springboot-kubs-app
spec:
  selector:
    app: springboot-kubs-app
  ports:
    - protocol: "TCP"
      port: 8080
      targetPort: 8080
  type: NodePort
=========================================================================================
13 Run the file => kubectl apply -f k8-service.yml
14 Check service => Kubectl get svc (service)
15 Show IP => kubeclt get nodes -o wide
16 Get IP => Minikube IP
17 Combine IP+PORT+apiUrl and insert in browser
18 Check dashboard => Kubectl dashboard

