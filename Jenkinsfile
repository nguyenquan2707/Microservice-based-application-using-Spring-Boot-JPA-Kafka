pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo 'checking out the application'
                deleteDir()
                checkout scm
            }
        }
        stage('Build stage') {
            steps {
                withMaven(maven : 'maven_3.1.0'){
                    bat 'mvn clean install'
                }
            }
        }
        stage('build docker image'){
            steps{
                script{
//                    echo "${env.WORKSPACE}"
                     def wspace = env.WORKSPACE
                     echo wspace
                     sh "docker build -t img-pos-cust -f ${env.WORKSPACE}/Customer-service/Dockerfile ."
//                     sh 'docker run -d -p 8081:8080  devops-integration:latest'
              }
          }
        }
    }
}
