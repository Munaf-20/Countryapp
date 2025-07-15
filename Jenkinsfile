pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Munaf-20/Countryapp.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy commands or scripts here
            }
        }
    }
}
