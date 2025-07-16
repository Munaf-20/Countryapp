// pipeline {
//     agent any
//
//     stages {
//         stage('Checkout') {
//             steps {
//                 git 'https://github.com/Munaf-20/Countryapp.git'
//             }
//         }
//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh 'mvn test'
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 // Deploy commands or scripts here
//             }
//         }
//     }
// }

pipeline {
    agent any

    environment {
        IMAGE_NAME = "munaf20/countryapp" // Your DockerHub image name
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/Munaf-20/Countryapp.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        // Optional: Push to DockerHub
        stage('Push to DockerHub') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub-cred', url: '']) {
                    script {
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }

        // Optional: Run container
        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8080:8080 munaf20/countryapp:latest'
            }
        }
    }
}

